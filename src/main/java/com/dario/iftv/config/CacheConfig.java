package com.dario.iftv.config;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.Ticker;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Configuration
@EnableCaching
public class CacheConfig {

    public static final String DOG_FIND_BY_NAME = "DogRepository.findByName";

    @Bean
    @Primary
    public CacheManager cacheManager(Ticker ticker) {
        var cacheManager = new SimpleCacheManager();
        cacheManager.setCaches(List.of(
                new CaffeineCache(DOG_FIND_BY_NAME, buildCache(ticker, 10, 24))
        ));

        return cacheManager;
    }

    private Cache<Object, Object> buildCache(Ticker ticker, long size, long durationInHours) {
        return Caffeine.newBuilder()
                .ticker(ticker)
                .maximumSize(size)
                .expireAfterWrite(durationInHours, TimeUnit.HOURS)
                .build();
    }

    @Bean
    public Ticker ticker() {
        return Ticker.systemTicker();
    }
}
