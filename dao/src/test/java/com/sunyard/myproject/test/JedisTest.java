package com.sunyard.myproject.test;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by Administrator on 2018/6/25.
 */
public class JedisTest {
    @Test
    public void testJedisSingle(){
        Jedis jedis=new Jedis("localhost",6379);
        jedis.set("key1","jedis test");
        String value=jedis.get("key1");
        System.out.println(value);
        jedis.close();
    }
    @Test
    public void testJedisPool(){
        JedisPool pool=new JedisPool("localhost",6379);
        Jedis jedis=pool.getResource();
        String value=jedis.get("key1");
        System.out.println(value);
        jedis.close();
        pool.close();
    }
}
