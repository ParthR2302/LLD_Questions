package Rate_Limiter.service;

import Rate_Limiter.enums.RateLimitType;
import Rate_Limiter.enums.UserTier;
import Rate_Limiter.factory.RateLimiterFactory;
import Rate_Limiter.limiter.RateLimiter;
import Rate_Limiter.model.RateLimitConfig;
import Rate_Limiter.model.User;

import java.util.HashMap;
import java.util.Map;

public class RateLimiterService {
    private final Map<UserTier, RateLimiter> rateLimiters = new HashMap<>();

    public RateLimiterService() {
        rateLimiters.put(
                UserTier.FREE,
                RateLimiterFactory.createRateLimiter(
                        RateLimitType.TOKEN_BUCKET,
                        new RateLimitConfig(10, 60)
                )
        );

        rateLimiters.put(
                UserTier.PREMIUM,
                RateLimiterFactory.createRateLimiter(
                        RateLimitType.FIXED_WINDOW,
                        new RateLimitConfig(100, 60)
                )
        );
    }

    public boolean allowRequest(User user) {
        RateLimiter rateLimiter = rateLimiters.get(user.getTier());
        if (rateLimiter == null) {
            throw new IllegalArgumentException("No rate limiter configured for tier: " + user.getTier());
        }
        return rateLimiter.allowRequest(user.getUserId());
    }
}
