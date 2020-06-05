package com.Kotori;

import org.junit.Test;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashSet;
import java.util.Set;

public class JedisClusterCrud {
    public static JedisCluster jedisCluster;
    static {
        Set<HostAndPort> jedisClusterNodes = new HashSet();
        jedisClusterNodes.add(new HostAndPort("192.168.111.10", 8001));
        jedisClusterNodes.add(new HostAndPort("192.168.111.10", 8004));
        jedisClusterNodes.add(new HostAndPort("192.168.111.11", 8002));
        jedisClusterNodes.add(new HostAndPort("192.168.111.11", 8005));
        jedisClusterNodes.add(new HostAndPort("192.168.111.12", 8003));
        jedisClusterNodes.add(new HostAndPort("192.168.111.12", 8006));

        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(500);
        config.setMaxIdle(100);
        config.setMaxWaitMillis(2000);
        config.setTestOnBorrow(true);

        jedisCluster = new JedisCluster(jedisClusterNodes, config);
    }

    @Test
    public void test1() {
        jedisCluster.set("Honoka", "1234");
        String val = jedisCluster.get("Honoka");
        System.out.println(val);
    }


}
