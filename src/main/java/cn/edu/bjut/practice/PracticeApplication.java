package cn.edu.bjut.practice;

import cn.edu.bjut.practice.config.AppConfig;
import cn.edu.bjut.practice.config.MyImportSelect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import({AppConfig.class, MyImportSelect.class})
@SpringBootApplication
public class PracticeApplication {
	public static void main(String[] args) {
		SpringApplication.run(PracticeApplication.class, args);
	}

}
