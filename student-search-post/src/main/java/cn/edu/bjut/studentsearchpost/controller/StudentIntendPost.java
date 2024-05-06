package cn.edu.bjut.studentsearchpost.controller;

import cn.edu.bjut.entity.post.PostAndEnterprise;
import cn.edu.bjut.entity.post.PostFilter;
import cn.edu.bjut.entity.student.other.SelectedValue;
import cn.edu.bjut.entity.student.other.Student;
import cn.edu.bjut.jwt.JWTUtils;
import cn.edu.bjut.result.Result;
import cn.edu.bjut.studentsearchpost.mapper.InsertIntendPost;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class StudentIntendPost {
    @Autowired
    private Student student;
    @Autowired
    private InsertIntendPost insertIntendPost;
    @PostMapping("/selectedValues")
    public Result insertIntendPost(@RequestBody SelectedValue selectedValue, HttpServletRequest request){
        // 获取当前登入的学生的id号
        String jwt = request.getHeader("Authorization");
        Claims claims = JWTUtils.parseJWT(jwt);
        log.info("校验解析后的令牌：{}", claims);
        // 获取当前登入的学生的id号
        Integer studentId = (Integer) claims.get("id");
        student.setId(studentId);
        // 将字符串转换成 List<String> 形式
        ObjectMapper objectMapper = new ObjectMapper();
        List<String> selectedValuesList = null;
        try {
            selectedValuesList = objectMapper.readValue(selectedValue.getSelectedValues(), new TypeReference<List<String>>(){});
        } catch (Exception e) {
            log.error("Failed to parse selected values", e);
        }
        // 打印转换后的 List<String>
        log.info("Selected values list: {}", selectedValuesList);
        Map<String, Object> params = new HashMap<>();
        params.put("stuId", student.getId());
        params.put("bigTypeList", selectedValuesList);
        insertIntendPost.insertIntend(params);
        return Result.success();
    }
}
