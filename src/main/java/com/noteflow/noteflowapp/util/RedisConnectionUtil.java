package com.noteflow.noteflowapp.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
public class RedisConnectionUtil {
    // makes the single instance of the class
    private static final RedisConnectionUtil instance = new RedisConnectionUtil();

    @Value("${noteflow.redis.host}")
    private List<String> hosts;

    @Value("${noteflow.redis.cluster.node.ports}")
    private List<Integer> ports;
    private JedisCluster jedisCluster;

    // *** Using the Singleton pattern ***
    // prevents you from making instances of the class
    private RedisConnectionUtil() {
    }

    // gets the only instance of the class
    public static RedisConnectionUtil getInstance() {
        return instance;
    }

    public void connect() {
        try {
            // Add nodes to Jedis Cluster
            Set<HostAndPort> jedisClusterNodes = new HashSet<>();

            for (int i = 0; i < hosts.size(); i++) {
                jedisClusterNodes.add(new HostAndPort(hosts.get(i), ports.get(i)));
            }

            // --- SANITY CHECK: printing out the nodes in the cluster
            log.info("************************************************************");
            log.info("Trying to connect to JedisCluster nodes in Docker container");
            jedisClusterNodes.forEach(System.out::println);

            // Instantiate the connection to the Jedis Cluster
            this.jedisCluster = new JedisCluster(jedisClusterNodes);

            // --- SANITY CHECK: printing out successful connections to each node
            for (int i = 0; i < hosts.size(); i++) {
                log.info("CONNECTED to port {} and host {}", ports.get(i), hosts.get(i));
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
    }

    public void write() {
        this.jedisCluster.set("lokisPaws", "hello");

    }

    public void read() {
        System.out.println(jedisCluster.get("lokisPaws"));
    }
}
