import redis.clients.jedis.Jedis;

import java.util.concurrent.TimeUnit;

public class TestString {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);

        jedis.flushDB();
        System.out.println("===========Add data===========");
        System.out.println(jedis.set("key1", "value1"));
        System.out.println(jedis.set("key2", "value2"));
        System.out.println(jedis.set("key3", "value3"));
        System.out.println("Delete key key2: " + jedis.del("key2"));
        System.out.println("Get value of key key2: " + jedis.get("key2"));
        System.out.println("Modify key1: " + jedis.set("key1", "value1Changed"));
        System.out.println("Get value of key1: " + jedis.get("key1"));
        System.out.println("Append value to key3: " + jedis.append("key3", "End"));
        System.out.println("Get value of key3: " + jedis.get("key3"));
        System.out.println("Add multiple key-value pairs: " + jedis.mset("key01", "value01", "key02", "value02", "key03", "value03"));
        System.out.println("Get multiple key-value pairs: " + jedis.mget("key01", "key02", "key03"));
        System.out.println("Get multiple key-value pairs (including non-existent key): " + jedis.mget("key01", "key02", "key03", "key04"));
        System.out.println("Delete multiple key-value pairs: " + jedis.del("key01", "key02"));
        System.out.println("Get multiple key-value pairs: " + jedis.mget("key01", "key02", "key03"));

        jedis.flushDB();
        System.out.println("===========Add key-value pair without overwriting existing value===========");
        System.out.println(jedis.setnx("key1", "value1"));
        System.out.println(jedis.setnx("key2", "value2"));
        System.out.println(jedis.setnx("key2", "value2-new"));
        System.out.println(jedis.get("key1"));
        System.out.println(jedis.get("key2"));

        System.out.println("===========Add key-value pair with expiration time===========");
        System.out.println(jedis.setex("key3", 2, "value3"));
        System.out.println(jedis.get("key3"));
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(jedis.get("key3"));

        System.out.println("===========Get old value and update to new value===========");
        System.out.println(jedis.getSet("key2", "key2GetSet"));
        System.out.println(jedis.get("key2"));

        System.out.println("Get substring of key2's value: " + jedis.getrange("key2", 2, 4));
    }
}
