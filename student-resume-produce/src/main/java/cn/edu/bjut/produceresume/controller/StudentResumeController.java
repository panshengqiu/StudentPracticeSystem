package cn.edu.bjut.produceresume.controller;

import cn.edu.bjut.entity.student.exprience.EducationInfo;
import cn.edu.bjut.entity.student.exprience.OrganizationExperience;
import cn.edu.bjut.entity.student.exprience.PracticeExperience;
import cn.edu.bjut.entity.student.exprience.ProjectExperience;
import cn.edu.bjut.entity.student.other.Student;
import cn.edu.bjut.entity.student.performance.Certification;
import cn.edu.bjut.jwt.JWTUtils;
import cn.edu.bjut.produceresume.service.StudentResumeService;
import cn.edu.bjut.result.Result;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class StudentResumeController {
    @Autowired
    Student student;
    @Autowired
    private StudentResumeService studentResumeService;
    @PostMapping("/saveEducation")
    public Result saveEducationInfo(@RequestBody EducationInfo educationInfo, HttpServletRequest request) {
        // 在这里处理接收到的教育信息，可以将信息保存到数据库或者进行其他操作
        System.out.println("Received education information: " +educationInfo.toString());
        String jwt = request.getHeader("Authorization");
        Claims claims = JWTUtils.parseJWT(jwt);
        log.info("校验解析后的令牌：{}", claims);

        // 获取当前登入的学生的id号
        Integer studentId = (Integer) claims.get("id");
        String username = (String) claims.get("username");
        student.setId(studentId);
        educationInfo.setStudent(student);
        System.out.println(studentId);
        System.out.println(username);

        Integer service=studentResumeService.insertEducation(educationInfo);
        return Result.success("Received project information: "+studentId);
//        return StuService.saveCertification(certification, request);
    }
    @PostMapping("/savePractice")
    public Result savePracticeInfo(@RequestBody PracticeExperience practiceExperience, HttpServletRequest request) {
        // 在这里处理接收到的教育信息，可以将信息保存到数据库或者进行其他操作
        System.out.println("Received practice information: " +practiceExperience.toString());
        String jwt = request.getHeader("Authorization");
        Claims claims = JWTUtils.parseJWT(jwt);
        log.info("校验解析后的令牌：{}", claims);

        // 获取当前登入的学生的id号
        Integer studentId = (Integer) claims.get("id");
        String username = (String) claims.get("username");
        student.setId(studentId);
        practiceExperience.setStudent(student);
        System.out.println(studentId);
        System.out.println(username);

        Integer service=studentResumeService.insertPractice(practiceExperience);
        return Result.success("Received project information: "+studentId);
//        return StuService.saveCertification(certification, request);
    }
    @PostMapping("/saveOrganization")
    public Result saveOrganizationInfo(@RequestBody OrganizationExperience organizationExperience, HttpServletRequest request) {
        // 在这里处理接收到的教育信息，可以将信息保存到数据库或者进行其他操作
        System.out.println("Received organization information: " +organizationExperience.toString());
        String jwt = request.getHeader("Authorization");
        Claims claims = JWTUtils.parseJWT(jwt);
        log.info("校验解析后的令牌：{}", claims);

        // 获取当前登入的学生的id号
        Integer studentId = (Integer) claims.get("id");
        String username = (String) claims.get("username");
        student.setId(studentId);
        organizationExperience.setStudent(student);
        System.out.println(studentId);
        System.out.println(username);

        Integer service=studentResumeService.insertOrganization(organizationExperience);
        return Result.success("Received project information: "+studentId);
//        return StuService.saveCertification(certification, request);
    }
    @PostMapping("/saveProject")
    public Result saveProjectInfo(@RequestBody ProjectExperience projectExperience, HttpServletRequest request) {
        // 在这里处理接收到的教育信息，可以将信息保存到数据库或者进行其他操作
        System.out.println("Received project information: " +projectExperience.toString());
        String jwt = request.getHeader("Authorization");
        Claims claims = JWTUtils.parseJWT(jwt);
        log.info("校验解析后的令牌：{}", claims);

        // 获取当前登入的学生的id号
        Integer studentId = (Integer) claims.get("id");
        String username = (String) claims.get("username");
        student.setId(studentId);
        projectExperience.setStudent(student);
        System.out.println(studentId);
        System.out.println(username);

        Integer service=studentResumeService.insertProject(projectExperience);
        return Result.success("Received project information: "+studentId);
//        return StuService.saveCertification(certification, request);
    }
    @PostMapping("/certification")
    public Result saveCertificationInfo(@RequestBody Certification certification, HttpServletRequest request) {
        // 在这里处理接收到的教育信息，可以将信息保存到数据库或者进行其他操作
        System.out.println("Received education information: " +certification.toString());
        String jwt = request.getHeader("Authorization");
        Claims claims = JWTUtils.parseJWT(jwt);
        log.info("校验解析后的令牌：{}", claims);

        // 获取当前登入的学生的id号
        Integer studentId = (Integer) claims.get("id");
        String username = (String) claims.get("username");
        student.setId(studentId);
        certification.setStudent(student);
        System.out.println(studentId);
        System.out.println(username);

        Integer service=studentResumeService.insertCertification(certification);
        return Result.success("Received education information: "+studentId);
//        return StuService.saveCertification(certification, request);
    }
    @PostMapping("/deleteEducation")
    public Result deleteEducationInfo(@RequestBody EducationInfo educationInfo, HttpServletRequest request) {
        // 获取当前登入的学生的id号
        String jwt = request.getHeader("Authorization");
        Claims claims = JWTUtils.parseJWT(jwt);
        log.info("校验解析后的令牌：{}", claims);
        // 获取当前登入的学生的id号
        Integer studentId = (Integer) claims.get("id");
        String username = (String) claims.get("username");
        student.setId(studentId);
        educationInfo.setStudent(student);
        Integer deletePractice=studentResumeService.deleteEducation(educationInfo);
        return Result.success("Received deleteCertification information: "+deletePractice);
    }
    @PostMapping("/deletePractice")
    public Result deletePracticeInfo(@RequestBody PracticeExperience practiceExperience, HttpServletRequest request) {
        // 获取当前登入的学生的id号
        String jwt = request.getHeader("Authorization");
        Claims claims = JWTUtils.parseJWT(jwt);
        log.info("校验解析后的令牌：{}", claims);
        // 获取当前登入的学生的id号
        Integer studentId = (Integer) claims.get("id");
        String username = (String) claims.get("username");
        student.setId(studentId);
        practiceExperience.setStudent(student);
        Integer deletePractice=studentResumeService.deletePractice(practiceExperience);
        return Result.success("Received deleteCertification information: "+deletePractice);
    }
    @PostMapping("/deleteProject")
    public Result deleteProjectInfo(@RequestBody ProjectExperience projectExperience, HttpServletRequest request) {
        // 获取当前登入的学生的id号
        String jwt = request.getHeader("Authorization");
        Claims claims = JWTUtils.parseJWT(jwt);
        log.info("校验解析后的令牌：{}", claims);
        // 获取当前登入的学生的id号
        Integer studentId = (Integer) claims.get("id");
        String username = (String) claims.get("username");
        student.setId(studentId);
        projectExperience.setStudent(student);
        Integer deleteCertification=studentResumeService.deleteProject(projectExperience);
        return Result.success("Received deleteCertification information: "+deleteCertification);
    }
    @PostMapping("/deleteOrganization")
    public Result deleteOrganizationInfo(@RequestBody OrganizationExperience organizationExperience, HttpServletRequest request) {
        // 获取当前登入的学生的id号
        String jwt = request.getHeader("Authorization");
        Claims claims = JWTUtils.parseJWT(jwt);
        log.info("校验解析后的令牌：{}", claims);
        // 获取当前登入的学生的id号
        Integer studentId = (Integer) claims.get("id");
        String username = (String) claims.get("username");
        student.setId(studentId);
        organizationExperience.setStudent(student);
        Integer deleteOrganization=studentResumeService.deleteOrganization(organizationExperience);
        return Result.success("Received deleteCertification information: "+deleteOrganization);
    }
    @PostMapping("/deleteCertification")
    public Result deleteCertificationInfo(@RequestBody Certification certification, HttpServletRequest request) {
        // 获取当前登入的学生的id号
        String jwt = request.getHeader("Authorization");
        Claims claims = JWTUtils.parseJWT(jwt);
        log.info("校验解析后的令牌：{}", claims);
        // 获取当前登入的学生的id号
        Integer studentId = (Integer) claims.get("id");
        String username = (String) claims.get("username");
        student.setId(studentId);
        certification.setStudent(student);
        Integer deleteCertification=studentResumeService.deleteCertification(certification);
        return Result.success("Received deleteCertification information: "+deleteCertification);
    }
    @GetMapping("/iniEducation")
    public Result iniEducation(HttpServletRequest request){
        String jwt = request.getHeader("Authorization");
        Claims claims = JWTUtils.parseJWT(jwt);
        log.info("校验解析后的令牌：{}", claims);

        // 获取当前登入的学生的id号
        Integer studentId = (Integer) claims.get("id");
        List<EducationInfo> educationInfos = studentResumeService.getAllEducation(studentId);

        return Result.success(educationInfos);
    }
    @GetMapping("/iniPractice")
    public Result iniPractice(HttpServletRequest request){
        String jwt = request.getHeader("Authorization");
        Claims claims = JWTUtils.parseJWT(jwt);
        log.info("校验解析后的令牌：{}", claims);

        // 获取当前登入的学生的id号
        Integer studentId = (Integer) claims.get("id");
        List<PracticeExperience> certificationList = studentResumeService.getAllPractice(studentId);

        System.out.println(certificationList.toString());
        return Result.success(certificationList);
    }
        @GetMapping("/inicertificates")
    public Result iniCertificates(HttpServletRequest request){
        String jwt = request.getHeader("Authorization");
        Claims claims = JWTUtils.parseJWT(jwt);
        log.info("校验解析后的令牌：{}", claims);

        // 获取当前登入的学生的id号
        Integer studentId = (Integer) claims.get("id");
        List<Certification> certificationList = studentResumeService.getAllCertificates(studentId);

        System.out.println(certificationList.toString());
        return Result.success(certificationList);
    }
    @GetMapping("/iniProject")
    public Result iniProject(HttpServletRequest request){
        String jwt = request.getHeader("Authorization");
        Claims claims = JWTUtils.parseJWT(jwt);
        log.info("校验解析后的令牌：{}", claims);

        // 获取当前登入的学生的id号
        Integer studentId = (Integer) claims.get("id");
        List<ProjectExperience> projectExperiencesList = studentResumeService.getAllProject(studentId);

        System.out.println(projectExperiencesList.toString());
        return Result.success(projectExperiencesList);
    }
    @GetMapping("/iniOrganization")
    public Result iniOrganization(HttpServletRequest request){
        String jwt = request.getHeader("Authorization");
        Claims claims = JWTUtils.parseJWT(jwt);
        log.info("校验解析后的令牌：{}", claims);

        // 获取当前登入的学生的id号
        Integer studentId = (Integer) claims.get("id");
        List<OrganizationExperience> organizationExperiencesList = studentResumeService.getAllOrganization(studentId);
        System.out.println(organizationExperiencesList.toString());
        return Result.success(organizationExperiencesList);
    }
}
