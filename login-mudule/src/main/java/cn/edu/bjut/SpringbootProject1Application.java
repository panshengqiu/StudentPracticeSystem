package cn.edu.bjut;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class SpringbootProject1Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootProject1Application.class, args);
    }


}
