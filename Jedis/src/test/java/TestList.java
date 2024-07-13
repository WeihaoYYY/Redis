import redis.clients.jedis.Jedis;

public class TestList {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.flushDB();
        System.out.println("===========Add a list===========");
        jedis.lpush("collections", "ArrayList", "Vector", "Stack", "HashMap", "WeakHashMap", "LinkedHashMap");
        jedis.lpush("collections", "HashSet");
        jedis.lpush("collections", "TreeSet");
        jedis.lpush("collections", "TreeMap");
        System.out.println("Contents of collections: " + jedis.lrange("collections", 0, -1));
        System.out.println("Elements of collections from index 0 to 3: " + jedis.lrange("collections", 0, 3));
        System.out.println("===============================");
        System.out.println("Number of elements removed: " + jedis.lrem("collections", 2, "HashMap"));
        System.out.println("Contents of collections: " + jedis.lrange("collections", 0, -1));
        System.out.println("Remove elements outside index 0-3: " + jedis.ltrim("collections", 0, 3));
        System.out.println("Contents of collections: " + jedis.lrange("collections", 0, -1));
        System.out.println("Pop element from collections (left end): " + jedis.lpop("collections"));
        System.out.println("Contents of collections: " + jedis.lrange("collections", 0, -1));
        System.out.println("Add element to collections (right end): " + jedis.rpush("collections", "EnumMap"));
        System.out.println("Contents of collections: " + jedis.lrange("collections", 0, -1));
        System.out.println("Pop element from collections (right end): " + jedis.rpop("collections"));
        System.out.println("Contents of collections: " + jedis.lrange("collections", 0, -1));
        System.out.println("Modify element at index 1 in collections: " + jedis.lset("collections", 1, "LinkedArrayList"));
        System.out.println("Contents of collections: " + jedis.lrange("collections", 0, -1));
        System.out.println("===============================");
        System.out.println("Length of collections: " + jedis.llen("collections"));
        System.out.println("Element at index 2 in collections: " + jedis.lindex("collections", 2));
        System.out.println("===============================");
        jedis.lpush("sortedList", "3", "6", "2", "0", "7", "4");
        System.out.println("Contents of sortedList before sorting: " + jedis.lrange("sortedList", 0, -1));
        System.out.println(jedis.sort("sortedList"));
        System.out.println("Contents of sortedList after sorting: " + jedis.lrange("sortedList", 0, -1));
    }
}
