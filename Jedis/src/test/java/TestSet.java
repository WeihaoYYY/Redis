import redis.clients.jedis.Jedis;

public class TestSet {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.flushDB();
        System.out.println("============Add elements to the set (no duplicates)============");
        System.out.println(jedis.sadd("eleSet", "e1", "e2", "e4", "e3", "e0", "e8", "e7", "e5"));
        System.out.println(jedis.sadd("eleSet", "e6"));
        System.out.println(jedis.sadd("eleSet", "e6"));
        System.out.println("All elements in eleSet: " + jedis.smembers("eleSet"));
        System.out.println("Remove an element 'e0': " + jedis.srem("eleSet", "e0"));
        System.out.println("All elements in eleSet: " + jedis.smembers("eleSet"));
        System.out.println("Remove elements 'e7' and 'e6': " + jedis.srem("eleSet", "e7", "e6"));
        System.out.println("All elements in eleSet: " + jedis.smembers("eleSet"));
        System.out.println("Randomly remove an element from the set: " + jedis.spop("eleSet"));
        System.out.println("Randomly remove another element from the set: " + jedis.spop("eleSet"));
        System.out.println("All elements in eleSet: " + jedis.smembers("eleSet"));
        System.out.println("Number of elements in eleSet: " + jedis.scard("eleSet"));
        System.out.println("Is 'e3' in eleSet: " + jedis.sismember("eleSet", "e3"));
        System.out.println("Is 'e1' in eleSet: " + jedis.sismember("eleSet", "e1"));
        System.out.println("Is 'e5' in eleSet: " + jedis.sismember("eleSet", "e5"));
        System.out.println("=================================");
        System.out.println(jedis.sadd("eleSet1", "e1", "e2", "e4", "e3", "e0", "e8", "e7", "e5"));
        System.out.println(jedis.sadd("eleSet2", "e1", "e2", "e4", "e3", "e0", "e8"));
        System.out.println("Move 'e1' from eleSet1 to eleSet3: " + jedis.smove("eleSet1", "eleSet3", "e1"));
        System.out.println("Move 'e2' from eleSet1 to eleSet3: " + jedis.smove("eleSet1", "eleSet3", "e2"));
        System.out.println("All elements in eleSet1: " + jedis.smembers("eleSet1"));
        System.out.println("All elements in eleSet3: " + jedis.smembers("eleSet3"));
        System.out.println("============Set operations=================");
        System.out.println("All elements in eleSet1: " + jedis.smembers("eleSet1"));
        System.out.println("All elements in eleSet2: " + jedis.smembers("eleSet2"));
        System.out.println("Intersection of eleSet1 and eleSet2: " + jedis.sinter("eleSet1", "eleSet2"));
        System.out.println("Union of eleSet1 and eleSet2: " + jedis.sunion("eleSet1", "eleSet2"));
        System.out.println("Difference of eleSet1 and eleSet2: " + jedis.sdiff("eleSet1", "eleSet2"));
        jedis.sinterstore("eleSet4", "eleSet1", "eleSet2");
        System.out.println("All elements in eleSet4: " + jedis.smembers("eleSet4"));
    }
}
