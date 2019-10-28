package com.zrcoffee.util;

import org.springframework.cache.jcache.JCacheCacheManager;

import javax.cache.Cache;
import javax.cache.CacheManager;

/**
 * 缓存工具
 *
 * @author Terry
 * @version 2019-10-27
 */
public class CacheUtil {

    private static CacheManager cacheManager = ((JCacheCacheManager) ApplicationContextUtil.getBean("cacheManager")).getCacheManager();

    /**
     * 获取缓存管理器实例
     *
     * @return 缓存管理器实例
     */
    public static CacheManager getCacheManager() {
        return cacheManager;
    }

    /**
     * 获取缓存管理器中全部缓存实例名称
     *
     * @return 缓存实例名称
     */
    public static Iterable<String> getCacheNames() {
        return cacheManager.getCacheNames();
    }

    /**
     * 获取缓存实例
     *
     * @param cacheName 缓存名称
     * @return 缓存实例
     */
    public static Cache<String, Object> getCache(String cacheName) {
        return getCache(cacheName, String.class, Object.class);
    }

    /**
     * 获取缓存实例
     *
     * @param cacheName 缓存名称
     * @param keyType   键类型
     * @param valueType 值类型
     * @return 缓存实例
     */
    public static <K, V> Cache<K, V> getCache(String cacheName, Class<K> keyType, Class<V> valueType) {
        return cacheManager.getCache(cacheName, keyType, valueType);
    }

    /**
     * 校验缓存实例中是否含有指定的键
     *
     * @param cacheName 缓存名称
     * @param key       键
     * @return 布尔值
     */
    public static boolean containsKey(String cacheName, String key) {
        return getCache(cacheName).containsKey(key);
    }

    /**
     * 写入缓存数据
     *
     * @param cacheName 缓存名称
     * @param key       键
     * @param value     值
     */
    public static void put(String cacheName, String key, Object value) {
        getCache(cacheName).put(key, value);
    }

    /**
     * 写入缓存数据. 如果指定的键已存在, 则不写入缓存数据.
     *
     * @param cacheName 缓存名称
     * @param key       键
     * @param value     值
     * @return 布尔值
     */
    public static boolean putIfAbsent(String cacheName, String key, Object value) {
        return getCache(cacheName).putIfAbsent(key, value);
    }

    /**
     * 读取缓存数据
     *
     * @param cacheName 缓存名称
     * @param key       键
     * @return 值
     */
    public static Object get(String cacheName, String key) {
        return getCache(cacheName).get(key);
    }

    /**
     * 移除缓存数据
     *
     * @param cacheName 缓存名称
     * @param key       键
     * @return 布尔值
     */
    public static boolean remove(String cacheName, String key) {
        return getCache(cacheName).remove(key);
    }

}
