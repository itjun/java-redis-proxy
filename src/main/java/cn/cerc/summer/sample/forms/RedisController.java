package cn.cerc.summer.sample.forms;

import java.util.Set;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.cerc.db.redis.JedisFactory;
import redis.clients.jedis.Jedis;

@RestController
@RequestMapping("/redis")
public class RedisController {

    // wrk -t1 -c1 -d1s http://127.0.0.1:8080/redis/incr
    @PostMapping("incr")
    public Long incr(String key) {
        try (Jedis redis = JedisFactory.getJedis()) {
            return redis.incr(key);
        }
    }

    @PostMapping("set")
    public String set(String key, String value) {
        try (Jedis redis = JedisFactory.getJedis()) {
            return redis.set(key, value);
        }
    }

    @PostMapping("get")
    public String get(String key) {
        try (Jedis redis = JedisFactory.getJedis()) {
            return redis.get(key);
        }
    }

    @PostMapping("setex")
    public String setex(String key, int timeout, String value) {
        try (Jedis redis = JedisFactory.getJedis()) {
            return redis.setex(key, timeout, value);
        }
    }

    @PostMapping("ttl")
    public long ttl(String key) {
        try (Jedis redis = JedisFactory.getJedis()) {
            return redis.ttl(key).longValue();
        }
    }

    @PostMapping("del")
    public int delete(String key) {
        try (Jedis redis = JedisFactory.getJedis()) {
            return redis.del(key).intValue();
        }
    }

    @PostMapping("keys")
    public Set<String> keys(String pattern) {
        try (Jedis redis = JedisFactory.getJedis()) {
            return redis.keys(pattern);
        }
    }

    @PostMapping("lpush")
    public Long lpush(String key, String value) {
        try (Jedis redis = JedisFactory.getJedis()) {
            return redis.lpush(key, value);
        }
    }

    @PostMapping("rpop/")
    public String rpop(String key) {
        try (Jedis redis = JedisFactory.getJedis()) {
            return redis.rpop(key);
        }
    }

}