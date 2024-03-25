package cn.edu.bjut.practice.config;

import cn.edu.bjut.entity.manager.Manager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import cn.edu.bjut.oss.AliOSSProperties;
import cn.edu.bjut.oss.AliOSSUtils;

@Configuration
public class AppConfig {
    @Bean
    public AliOSSUtils aliOSSUtils() {
        return new AliOSSUtils();
    }

    @Bean
    public AliOSSProperties aliOSSProperties(){
        return new AliOSSProperties();
    }
    public void test(){
//        new ManagerLoginMapper(new Manager());
        new Manager();
    }
}

