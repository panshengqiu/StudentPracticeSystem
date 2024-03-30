package cn.edu.bjut.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

public class JWTUtils {
    private static String signKey = "practice";
    private static long expire = 600 * 1000;
    public static String setAndGetJWT(Map<String, Object> claims){ // 生成JWT
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
    public static Claims parseJWT(String jwt){ // 解析JWT
        Claims claims = Jwts.parser()
                .setSigningKey(signKey)
                .parseClaimsJws(jwt)
                .getBody();
        System.out.println("解析后的令牌："  + claims);
        return claims;
    }
}
