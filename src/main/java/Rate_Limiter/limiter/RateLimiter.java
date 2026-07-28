package Rate_Limiter.limiter;

import Rate_Limiter.enums.RateLimitType;
import Rate_Limiter.model.RateLimitConfig;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class RateLimiter {
    protected final RateLimitConfig config;
    protected final RateLimitType type;

    public abstract boolean allowRequest(String userId);
}
