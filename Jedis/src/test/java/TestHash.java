import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

public class TestHash {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.flushDB();
        Map<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        map.put("key4", "value4");

        jedis.hmset("hash", map);
        jedis.hset("hash", "key5", "value5");
        System.out.println("All key-value pairs in hash: " + jedis.hgetAll("hash"));
        System.out.println("All keys in hash: " + jedis.hkeys("hash"));
        System.out.println("All values in hash: " + jedis.hvals("hash"));
        System.out.println("Increment the value of key6 by 6, adding key6 if it doesn't exist: " + jedis.hincrBy("hash", "key6", 6));
        System.out.println("All key-value pairs in hash: " + jedis.hgetAll("hash"));
        System.out.println("Increment the value of key6 by 3: " + jedis.hincrBy("hash", "key6", 3));
        System.out.println("All key-value pairs in hash: " + jedis.hgetAll("hash"));
        System.out.println("Delete one or more key-value pairs: " + jedis.hdel("hash", "key2"));
        System.out.println("All key-value pairs in hash: " + jedis.hgetAll("hash"));
        System.out.println("Number of key-value pairs in hash: " + jedis.hlen("hash"));
        System.out.println("Does hash contain key2: " + jedis.hexists("hash", "key2"));
        System.out.println("Does hash contain key3: " + jedis.hexists("hash", "key3"));
        System.out.println("Get value(s) from hash: " + jedis.hmget("hash", "key3"));
        System.out.println("Get value(s) from hash: " + jedis.hmget("hash", "key3", "key4"));
    }
}
