package com.toj.teacheronlinejudge.global.redis;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
@RequiredArgsConstructor
public class RedisService {

    private final StringRedisTemplate stringRedisTemplate;
    private final RedisTemplate<String, String> blackListTemplate;

    public String getData(String key) {
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
        return operations.get(key);
    }

    public void setData(String key, String value) {
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
        operations.set(key, value);
    }

    public void setDataExpire(String key, String value, Duration duration) {
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
        operations.set(key, value, duration);
    }

    public void deleteData(String key) {
        stringRedisTemplate.delete(key);
    }


    public void setBlackList(String key, long remainTime) {
        ValueOperations<String, String> operations = blackListTemplate.opsForValue();
        operations.set(key, "logout", remainTime);
    }

    public boolean hasBlackList(String key) {
        return Boolean.TRUE.equals(blackListTemplate.hasKey(key));
    }
}
