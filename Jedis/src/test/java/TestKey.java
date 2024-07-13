import redis.clients.jedis.Jedis;

import java.util.Set;

public class TestKey {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);

        System.out.println("Clean up the database: " + jedis.flushDB());
        System.out.println("Check if a key exists: " + jedis.exists("username"));
        System.out.println("Add key-value pair <'key','value'>: " + jedis.set("thisIsKey", "thisIsValue"));
        System.out.println("Add key-value pair <'aa','bb'>: " + jedis.set("password", "123456"));
        System.out.print("All keys in the system: ");
        Set<String> keys = jedis.keys("*");
        System.out.println(keys);
        System.out.println("Delete key 'password': " + jedis.del("password"));
        System.out.println("Check if key 'password' exists: " + jedis.exists("password"));
        System.out.println("Check the type of value stored in key 'thisIsKey': " + jedis.type("thisIsKey"));
        System.out.println("Return a random key: " + jedis.randomKey());
        System.out.println("Rename key 'thisIsKey' to 'name': " + jedis.rename("thisIsKey", "name"));
        System.out.println("Get the value of key 'name': " + jedis.get("name"));
        System.out.println("Select database by index: " + jedis.select(0));
        System.out.println("Delete all keys in the current database: " + jedis.flushDB());
        System.out.println("Get the number of keys in the current database: " + jedis.dbSize());
        System.out.println("Delete all keys in all databases: " + jedis.flushAll());
    }
}
