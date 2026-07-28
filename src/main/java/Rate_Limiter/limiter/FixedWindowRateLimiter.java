package Rate_Limiter.limiter;

import Rate_Limiter.enums.RateLimitType;
import Rate_Limiter.model.RateLimitConfig;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class FixedWindowRateLimiter extends RateLimiter{

    private final Map<String, Integer> requestCount = new ConcurrentHashMap<>();
    private final Map<String, Long> windowStartTime = new HashMap<>();

    public FixedWindowRateLimiter(RateLimitConfig config) {
        super(config, RateLimitType.FIXED_WINDOW);
    }

    @Override
    public boolean allowRequest(String userId) {
        AtomicBoolean allowed = new AtomicBoolean(false);

        long currentReqWindow = System.currentTimeMillis() / 1000 / config.getWindowInSeconds();

        requestCount.compute(userId, (id, count) -> {
            long lastReqWindow = windowStartTime.getOrDefault(id, currentReqWindow);

            if (lastReqWindow != currentReqWindow) {
                // window expired -> reset counter and window of last req
                windowStartTime.put(id, currentReqWindow);
                allowed.set(true);
                return 1; // first request in new window
            }

            if (count == null) count = 0;

            if (count < config.getMaxRequests()) {
                allowed.set(true);
                return count + 1; // increment count
            }

            return count; // remain same
        });

        return allowed.get();
    }
}
