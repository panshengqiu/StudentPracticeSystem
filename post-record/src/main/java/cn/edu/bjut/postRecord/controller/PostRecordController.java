package cn.edu.bjut.postRecord.controller;

import cn.edu.bjut.entity.PostRecordReturn;
import cn.edu.bjut.entity.hr.ResumeApproval;
import cn.edu.bjut.entity.student.exprience.EducationInfo;
import cn.edu.bjut.entity.student.exprience.PracticeExperience;
import cn.edu.bjut.jwt.JWTUtils;
import cn.edu.bjut.postRecord.service.PostRecordImplment;
import cn.edu.bjut.postRecord.service.PostRecordService;
import cn.edu.bjut.result.Result;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import cn.edu.bjut.entity.student.other.Student;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class PostRecordController {
    @Autowired
    Student student;
    @Autowired
    private PostRecordImplment postRecordImplment;
    @PostMapping("/postRecordSelect")
    public Result selectPostRecord(@RequestBody ResumeApproval resumeApproval, HttpServletRequest request) {
        // 获取当前登入的学生的id号
        String jwt = request.getHeader("Authorization");
        Claims claims = JWTUtils.parseJWT(jwt);
        log.info("校验解析后的令牌：{}", claims);
        // 获取当前登入的学生的id号
        Integer studentId = (Integer) claims.get("id");
        String username = (String) claims.get("username");
        student.setId(studentId);
        resumeApproval.setStudent(student);
        log.info("企业名称：{}",resumeApproval.getApprovalStage());
        System.out.println("这是aaaa"+resumeApproval);
        List<PostRecordReturn> resumeSubmitId = postRecordImplment.getAllApproval(studentId,resumeApproval.getApprovalStage());
        System.out.println("hhh"+resumeSubmitId.toString());
        return Result.success(resumeSubmitId);
    }
}
