package com.noteflow.noteflowapp.util;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
public class RedisConnectionUtil {

    //  *** USING THE SINGLETON PATTERN ***
    // makes the single instance of the class
    // the variable holds an instance but is not actually tied to any instance (static variable)
    // this static variable gets created immediately
    private static final RedisConnectionUtil instance = new RedisConnectionUtil();

    // instance variables
    private Boolean isConnected = false;
    @Value("${noteflow.redis.hosts}")
    private List<String> hosts;
    @Value("${noteflow.redis.cluster.node.ports}")
    private List<Integer> ports;
    private JedisCluster jedisCluster;

    // make the constructor private to prevent you from making new instances of the class
    // IMPORTANT: do not run connect() method in the constructor. When the constructor gets called, the instance
    // variables are still in the process of getting initialized, so they will not return any values in them. Thus
    // when you run the connect() method and it uses those instance variables, it will say that the variables are empty.
    // Better solution is to use @PostConstruct, which runs anything right after the bean and any constructors
    // are initialized (thus the instance variable will have values in them)
    private RedisConnectionUtil() {
    }

    // gets the only instance of the class
    public static RedisConnectionUtil getInstance() {
        return instance;
    }

    //runs after the bean is initialized and the instance is created
    @PostConstruct
    public static void init() {
        if (!instance.isConnected) {
            instance.connect();
            instance.isConnected = true;
        }
    }

    //making this private so we can ensure only the class calls it and calls it once
    private void connect() {
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
            jedisCluster = new JedisCluster(jedisClusterNodes);

            // --- SANITY CHECK: printing out successful connections to each node
            for (int i = 0; i < hosts.size(); i++) {
                log.info("CONNECTED to port {} and host {}", ports.get(i), hosts.get(i));
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }

    public String read(String key) {
        return jedisCluster.get(key);
    }

    public void write(String key, String value) {
        jedisCluster.set(key, value);
    }

    public void delete(String key) {
        jedisCluster.del(key);
    }


}
