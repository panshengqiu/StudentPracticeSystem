package cn.edu.bjut.practice.controller;

import cn.edu.bjut.entity.student.other.Student;
import cn.edu.bjut.jwt.JWTUtils;
import cn.edu.bjut.result.Result;
import cn.edu.bjut.practice.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;



@RestController
public class StudentController {
    //private static Logger log = LoggerFactory.getLogger(DeptController.class);
    @Autowired
    private StudentService studentService;
    @PostMapping("/studentLogin")
    public Result login(@RequestBody Student student){
        System.out.println("username: " + student.getUsername() + " password: " + student.getPassword());
        Student stu = studentService.login(student.getUsername(), student.getPassword());
        if(stu != null){
            Map<String, Object> claims = new HashMap<>();
            claims.put("username",stu.getUsername());
            claims.put("password", stu.getPassword());
            String jwt = JWTUtils.setAndGetJWT(claims);
            return Result.success(jwt);
        }
        return Result.error("用户名或密码错误");
    }
}
