package cn.edu.bjut.practice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyCorsConfiguration {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // 可以限制到特定路径
                        .allowedOrigins("http://localhost:9001") // 允许前端应用的域名
                        .allowedMethods("GET", "POST", "PUT", "DELETE") // 允许的请求方法
                        .allowedHeaders("*") // 允许的请求头
                        .allowCredentials(true); // 是否允许发送Cookie信息
            }
        };
    }
}
