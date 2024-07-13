import redis.clients.jedis.Jedis;

public class TestPing {
    public static void main(String[] args) {
        // Connecting to Redis server on localhost(start your redis server on Windows before running this code)
        // Because we are running a redis client, we only need to run redis-server.exe
        Jedis jedis = new Jedis("localhost", 6379);
        System.out.println(jedis.ping());  // PONG
    }
}
