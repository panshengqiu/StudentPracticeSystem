package cn.edu.bjut;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//@SpringBootTest // springboot整合单元测试的注解
class SpringbootProject1ApplicationTests {
    @Test
    void contextLoads() {
        System.out.println("hello world");
    }

    @Test
    public void testGenJWT(){ // 生成JWT
        Map<String, Object> claims = new HashMap<>();
        claims.put("username", "zhangsan");
        claims.put("id", "1");

        String jwt = Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS256, "itheima")
                .setExpiration(new Date(System.currentTimeMillis() + 600 * 1000))
                .compact();
        System.out.println(jwt);
    }

}
