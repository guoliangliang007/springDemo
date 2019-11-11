package com.example.demo.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

public class RedisTest {
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;
}
