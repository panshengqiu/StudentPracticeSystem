package cn.edu.bjut.studentregister.controller;

import cn.edu.bjut.entity.student.other.Student;
import cn.edu.bjut.result.Result;

import cn.edu.bjut.studentregister.service.StudentRegisterService;


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

    private StudentRegisterService studentRegisterService;

    @PostMapping("/studentRegisterView")
    public Result resgister(@RequestBody Student student){
        if(studentRegisterService.register(student)>0){
            return Result.success("注册成功");
        }
        else return Result.error("注册失败");
    }

}
