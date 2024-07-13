import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

public class TestTranscation {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost", 6379);
        jedis.flushDB();

        Transaction transaction = jedis.multi();
        try{
            transaction.set("k4", "v4");
            transaction.set("k5", "v5");
            int i = 1/0;  // This will cause an exception
            transaction.exec();
        }catch (Exception e) {
            transaction.discard();
            e.printStackTrace();
        }finally {
            System.out.println(jedis.get("k4"));
            System.out.println(jedis.get("k5"));
            jedis.close();
        }

    }
}
