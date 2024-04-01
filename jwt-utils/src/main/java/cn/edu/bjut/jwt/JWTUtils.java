package cn.edu.bjut.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
<<<<<<< HEAD

import java.util.Date;
import java.util.Map;

public class JWTUtils {
    private static String signKey = "practice";
    private static long expire = 600 * 1000;
    public static String setAndGetJWT(Map<String, Object> claims){ // 生成JWT
=======
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JWTUtils {
    private static String signKey = "panshengqiu";
    private static long expire = 600 * 1000;
    public static String getJWT(){ // 生成JWT
        Map<String, Object> claims = new HashMap<>();
        claims.put("username", "zhangsan");
        claims.put("id", "1");

>>>>>>> origin/main
        String jwt = Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS256, signKey)
                .setExpiration(new Date(System.currentTimeMillis() + expire))
                .compact();
        System.out.println(jwt);
        return jwt;
    }

    // 篡改解析报错
    // 过期解析报错
<<<<<<< HEAD
    public static Claims parseJWT(String jwt){ // 解析JWT
        Claims claims = Jwts.parser()
                .setSigningKey(signKey)
                .parseClaimsJws(jwt)
                .getBody();
        System.out.println("解析后的令牌："  + claims);
=======
    public static Claims parseJWT(){ // 解析JWT
        Claims claims = Jwts.parser()
                .setSigningKey("itheima")
                .parseClaimsJws(JWTUtils.getJWT())
                .getBody();
        System.out.println(claims);
>>>>>>> origin/main
        return claims;
    }
}
