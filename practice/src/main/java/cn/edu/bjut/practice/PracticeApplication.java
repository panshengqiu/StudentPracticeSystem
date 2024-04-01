package cn.edu.bjut.practice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@MapperScan("cn.edu.bjut.managerlogin.mapper")
@MapperScan("cn.edu.bjut.practice.mapper")
@MapperScan("cn.edu.bjut.enterpriseregister.mapper")
@MapperScan("cn.edu.bjut.hrregister.mapper")
@MapperScan("cn.edu.bjut.studentregister.mapper")
@SpringBootApplication(scanBasePackages = {"cn.edu.bjut.hrregister","cn.edu.bjut.practice", "cn.edu.bjut.interceptor", "cn.edu.bjut.result","cn.edu.bjut.managerlogin","cn.edu.bjut.enterpriseregister","cn.edu.bjut.studentregister"})
public class PracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticeApplication.class, args);
	}

}
