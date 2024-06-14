package com.hyde.util;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedisUtil {

    private static RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private RedisTemplate<String, Object> template;

    @PostConstruct
    public void init() {
        redisTemplate = template;
    }


    // String operations

    public static void set(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public static void set(String key, Object value, long timeout, TimeUnit unit) {
        redisTemplate.opsForValue().set(key, value, timeout, unit);
    }

    public static Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public static boolean delete(String key) {
        return redisTemplate.delete(key);
    }

    public static boolean expire(String key, long timeout, TimeUnit unit) {
        return redisTemplate.expire(key, timeout, unit);
    }

    public static boolean hasKey(String key) {
        return redisTemplate.hasKey(key);
    }

    // Hash operations

    public static void hSet(String key, String hashKey, Object value) {
        redisTemplate.opsForHash().put(key, hashKey, value);
    }

    public static Object hGet(String key, String hashKey) {
        return redisTemplate.opsForHash().get(key, hashKey);
    }

    public static void hDelete(String key, Object... hashKeys) {
        redisTemplate.opsForHash().delete(key, hashKeys);
    }

    // List operations

    public static void lPush(String key, Object value) {
        redisTemplate.opsForList().leftPush(key, value);
    }

    public static Object lPop(String key) {
        return redisTemplate.opsForList().leftPop(key);
    }

    public static void rPush(String key, Object value) {
        redisTemplate.opsForList().rightPush(key, value);
    }

    public static Object rPop(String key) {
        return redisTemplate.opsForList().rightPop(key);
    }

    // Set operations

    public static void sAdd(String key, Object... values) {
        redisTemplate.opsForSet().add(key, values);
    }

    public static void sRemove(String key, Object... values) {
        redisTemplate.opsForSet().remove(key, values);
    }

    public static boolean sIsMember(String key, Object value) {
        return redisTemplate.opsForSet().isMember(key, value);
    }

    // ZSet operations

    public static void zAdd(String key, Object value, double score) {
        redisTemplate.opsForZSet().add(key, value, score);
    }

    public static void zRemove(String key, Object... values) {
        redisTemplate.opsForZSet().remove(key, values);
    }

    public static Double zScore(String key, Object value) {
        return redisTemplate.opsForZSet().score(key, value);
    }
}
