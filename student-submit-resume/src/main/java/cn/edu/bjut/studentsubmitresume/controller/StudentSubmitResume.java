package cn.edu.bjut.studentsubmitresume.controller;

import cn.edu.bjut.entity.post.PostId;
import cn.edu.bjut.entity.student.other.Student;
import cn.edu.bjut.jwt.JWTUtils;
import cn.edu.bjut.studentsubmitresume.mapper.InsertSubmitById;
import cn.edu.bjut.studentsubmitresume.mapper.SelectSubmitRecord;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cn.edu.bjut.result.Result;

@Slf4j
@RestController
public class StudentSubmitResume {
    @Autowired
    private Student student;
    @Autowired
    private SelectSubmitRecord selectSubmitRecord;
    //判断是否投递过该岗位，以便于前端按钮来显示状态
    @PostMapping("/submitResume")
    public Result selectStudentSubmit(@RequestBody PostId postid , HttpServletRequest request){
        // 获取当前登入的学生的id号
        String jwt = request.getHeader("Authorization");
        Claims claims = JWTUtils.parseJWT(jwt);
        log.info("校验解析后的令牌：{}", claims);
        // 获取当前登入的学生的id号
        Integer studentId = (Integer) claims.get("id");
        student.setId(studentId);
        if (selectSubmitRecord.countSubmitRecord(postid.getPostId(),student.getId())==1){
            return Result.success("已经投递过该岗位");
        }
        else return Result.error("可以先去投递该岗位哦");
    }





}
