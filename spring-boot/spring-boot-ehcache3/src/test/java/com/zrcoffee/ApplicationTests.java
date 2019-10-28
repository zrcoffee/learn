package com.zrcoffee;

import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.CacheConfiguration;
import org.ehcache.config.ResourcePools;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.config.units.EntryUnit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void ehcacheTest1() {
        CacheManagerBuilder builder = CacheManagerBuilder.newCacheManagerBuilder();
        CacheManager cacheManager = builder.build();
        cacheManager.init();

        ResourcePoolsBuilder poolsBuilder = ResourcePoolsBuilder.newResourcePoolsBuilder();
        ResourcePools pools = poolsBuilder.heap(10, EntryUnit.ENTRIES).build();

        CacheConfigurationBuilder<Long, String> cacheConfigurationBuilder = CacheConfigurationBuilder.newCacheConfigurationBuilder(Long.class, String.class, pools);
        CacheConfiguration<Long, String> cacheConfiguration = cacheConfigurationBuilder.build();

        Cache myCache = cacheManager.createCache("myCache", cacheConfiguration);
        myCache.put(1L, "ehcache demo");
        System.out.println(myCache.get(1L));

        cacheManager.close();
    }

    @Test
    public void ehcacheTest2() {
        CacheManager cacheManager = CacheManagerBuilder.newCacheManagerBuilder()
                .withCache("preConfigured",
                        CacheConfigurationBuilder.newCacheConfigurationBuilder(Long.class, String.class, ResourcePoolsBuilder.heap(10)))
                .build();
        cacheManager.init();

        Cache<Long, String> preConfigured = cacheManager.getCache("preConfigured", Long.class, String.class);
        preConfigured.put(1L, "test preConfigured!");
        System.out.println(preConfigured.get(1L));

        Cache<Long, String> myCache = cacheManager.createCache("myCache",
                CacheConfigurationBuilder.newCacheConfigurationBuilder(Long.class, String.class, ResourcePoolsBuilder.heap(10)));

        myCache.put(1L, "test myCache!");
        System.out.println(myCache.get(1L));

        cacheManager.removeCache("preConfigured");

        cacheManager.close();
    }

    @Test
    public void ehcacheXMLTest() {

    }

}
