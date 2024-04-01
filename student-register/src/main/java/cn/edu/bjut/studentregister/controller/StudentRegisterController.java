package cn.edu.bjut.studentregister.controller;

import cn.edu.bjut.entity.student.other.Student;
import cn.edu.bjut.jwt.JWTUtils;
import cn.edu.bjut.result.Result;
import cn.edu.bjut.studentregister.mapper.StudentRegisterMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
public class StudentRegisterController {
    @Autowired
    private StudentRegisterMapper studentRegisterMapper;
    @PostMapping("/StudentRegisterView")
    public Result resgister(@RequestBody Student student){
        studentRegisterMapper.insertStudent(student);
        return new Result("success", "Student registered successfully");

    }

}
