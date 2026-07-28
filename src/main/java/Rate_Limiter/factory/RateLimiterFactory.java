package Rate_Limiter.factory;

import Rate_Limiter.enums.RateLimitType;
import Rate_Limiter.limiter.FixedWindowRateLimiter;
import Rate_Limiter.limiter.RateLimiter;
import Rate_Limiter.limiter.SlidingWindowLogRateLimiter;
import Rate_Limiter.limiter.TokenBucketRateLimiter;
import Rate_Limiter.model.RateLimitConfig;

public class RateLimiterFactory {
    public static RateLimiter createRateLimiter(RateLimitType algo, RateLimitConfig config) {
        return switch (algo) {
            case TOKEN_BUCKET -> new TokenBucketRateLimiter(config);
            case FIXED_WINDOW -> new FixedWindowRateLimiter(config);
            case SLIDING_WINDOW_LOG -> new SlidingWindowLogRateLimiter(config);
            default -> throw new IllegalArgumentException("Unknown algorithm: " + algo);
        };
    }
}
