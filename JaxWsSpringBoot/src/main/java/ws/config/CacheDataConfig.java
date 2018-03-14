package ws.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * Created by EGBoldyr on 14.03.18.
 *
 * Конфигурация кеширования данных, чтобы без конца не лазить в БД
 *
 */

@Configuration
@EnableCaching
public class CacheDataConfig {

    @Bean
    public CacheManager cacheManager() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager();
        cacheManager.setCaffeine(
                Caffeine.newBuilder()
                        .initialCapacity(100)
                        .maximumSize(300)
                        .expireAfterAccess(5, TimeUnit.MINUTES)
                        .weakKeys());
        return cacheManager;
    }
}
