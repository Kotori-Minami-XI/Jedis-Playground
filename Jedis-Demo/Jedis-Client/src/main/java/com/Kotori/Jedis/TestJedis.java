package com.Kotori.Jedis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TestJedis {
    private final String ip = "192.168.111.10";
   // private final String ip = "127.0.0.1";
    private final int port = 6379;

    @Test
    public void testJedis1() {
        Jedis jedis = new Jedis(ip, port);
        jedis.set("Kotori", "1234");
        String value = jedis.get("Kotori");
        System.out.println(value);
    }

    @Test
    public void testJedis2() {
        Jedis jedis = new Jedis(ip, port);
        jedis.flushDB();
    }

    @Test
    public void testJedis3() {
        Jedis jedis = new Jedis(ip, port);
        jedis.lpush("books","java","c","c++");
    }

    @Test
    public void testJedis4() {
        Jedis jedis = new Jedis(ip, port);
        jedis.mset("dog1", "wc","dog2", "db");
        List<String> list = jedis.mget("dog1", "dog2");
        System.out.println(list);
        jedis.flushDB();
    }

    @Test
    public void testJedis5() {
        Map<String, Double> map = new HashMap();
        map.put("eri",3.3);
        map.put("kotori",1.1);
        map.put("honoka",0.5);

        Jedis jedis = new Jedis(ip, port);
        jedis.zadd("idols", 4.4, "Nico");
        jedis.zadd("idols", map);

        Set<String> idols = jedis.zrange("idols", 0, -1);
        System.out.println(idols);

        Double score = jedis.zscore("idols", "honoka");
        Long rank = jedis.zrank("idols", "honoka");
        System.out.printf("honoka's score is %s , rank is %s", score, rank);
    }



}
