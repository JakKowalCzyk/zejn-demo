package eu.kowalczyk.zejn.person.domain;

import lombok.Builder;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * Created by JKowalczyk on 2018-12-04.
 */
@EnableCaching
@Configuration
class PersonConfig {

    @Bean
    public PersonFacade personFacade(PersonRepository personRepository) {
        return new PersonFacade(personRepository);
    }

    @Bean
    public CacheManager cacheManager() {
        SimpleCacheManager simpleCacheManager = new SimpleCacheManager();
        simpleCacheManager.setCaches(Arrays.asList(
                new ConcurrentMapCache("personCacheById")
        ));
        return simpleCacheManager;
    }

}
