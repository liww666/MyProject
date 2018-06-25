package com.sunyard.myproject.jedis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.PostConstruct;

/**
 * Created by Administrator on 2018/6/25.
 */
@Component
public class JedisClientSingle implements JedisClient {

    @Autowired
    private JedisPool jedisPool;

    @PostConstruct
    public void doPost(){
        System.out.println("Jedis-------------key1=" + this.get("key1"));
    }
    @Override
    public String get(String key) {
        Jedis jedis=jedisPool.getResource();
        String value=jedis.get(key);
        jedis.close();
        return value;
    }

    @Override
    public String set(String key, String value) {
        return null;
    }

    @Override
    public String hget(String hkey, String key) {
        return null;
    }

    @Override
    public long hset(String hkey, String key, String value) {
        return 0;
    }

    @Override
    public long incr(String key) {
        return 0;
    }

    @Override
    public long expire(String key, int second) {
        return 0;
    }

    @Override
    public long ttl(String key) {
        return 0;
    }

    @Override
    public long del(String key) {
        return 0;
    }

    @Override
    public long hdel(String hkey, String key) {
        return 0;
    }
}
