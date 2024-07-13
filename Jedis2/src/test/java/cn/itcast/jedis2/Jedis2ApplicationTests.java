package cn.itcast.jedis2;

import cn.itcast.jedis2.pojo.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class Jedis2ApplicationTests {

    //don't forget to start the Redis server
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    void contextLoads() {
        RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
        connection.flushDb();

        redisTemplate.opsForValue().set("key1", "value1");
        System.out.println(redisTemplate.opsForValue().get("key1"));
    }

    @Test
    void test() throws JsonProcessingException {
        User user = new User("Jack", 23);
        String json = new ObjectMapper().writeValueAsString(user);  // Serialize the object to a JSON string

        redisTemplate.opsForValue().set("user", json);
        System.out.println(redisTemplate.opsForValue().get("user"));  //{"name":"Jack","age":23}
    }

}
