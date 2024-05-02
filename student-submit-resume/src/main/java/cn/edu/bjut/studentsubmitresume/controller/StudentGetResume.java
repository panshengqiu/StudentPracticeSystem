package cn.edu.bjut.studentsubmitresume.controller;

import cn.edu.bjut.entity.post.PostId;
import cn.edu.bjut.entity.student.other.Resume;
import cn.edu.bjut.entity.student.other.ResumeAndStudent;
import cn.edu.bjut.entity.student.other.Student;
import cn.edu.bjut.jwt.JWTUtils;
import cn.edu.bjut.result.Result;
import cn.edu.bjut.studentsubmitresume.mapper.InsertSubmitById;
import cn.edu.bjut.studentsubmitresume.mapper.SelectResumeByStudentId;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class StudentGetResume {
    @Autowired
    private SelectResumeByStudentId selectResumeByStudentId;
    @Autowired
    private Student student;
    @PostMapping("/resumeGetByStudentId")
    public List<Resume> selectStudentResume(HttpServletRequest request){
        // 获取当前登入的学生的id号
        String jwt = request.getHeader("Authorization");
        Claims claims = JWTUtils.parseJWT(jwt);
        log.info("校验解析后的令牌：{}", claims);
        // 获取当前登入的学生的id号
        Integer studentId = (Integer) claims.get("id");
        student.setId(studentId);
        return selectResumeByStudentId.allResumeByStudentId(String.valueOf(student.getId()));
    }
    @Autowired
    private InsertSubmitById insertSubmitById;
    @PostMapping("/submitResumeByStudentIdPostIdResume")
    public Result submitStudentResume(@RequestBody ResumeAndStudent resumeAndStudent, HttpServletRequest request){
        // 获取当前登入的学生的id号
        String jwt = request.getHeader("Authorization");
        Claims claims = JWTUtils.parseJWT(jwt);
        log.info("校验解析后的令牌：{}", claims);
        // 获取当前登入的学生的id号
        Integer studentId = (Integer) claims.get("id");
        student.setId(studentId);
        insertSubmitById.insertSubmit(student.getId(),resumeAndStudent.getPostId(),resumeAndStudent.getResumeUrl());
        return Result.success("成功投递");
    }

}
