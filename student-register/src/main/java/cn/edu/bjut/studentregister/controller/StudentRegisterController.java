package cn.edu.bjut.studentregister.controller;
import cn.edu.bjut.entity.student.other.Student;
import cn.edu.bjut.result.Result;
import cn.edu.bjut.studentregister.service.StudentRegisterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
public class StudentRegisterController {
    @Autowired
    private StudentRegisterService studentRegister;
    @PostMapping("/studentRegisterView")
    public Result resgister(@RequestBody Student student){
        if (studentRegister.register(student)>0){
            return Result.success("成功注册");
        }
        else return Result.error("获取失败");


    }

}
