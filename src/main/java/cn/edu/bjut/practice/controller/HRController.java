package cn.edu.bjut.practice.controller;

import cn.edu.bjut.entity.hr.HumanResource;
import cn.edu.bjut.jwt.JWTUtils;
import cn.edu.bjut.result.Result;
import cn.edu.bjut.practice.service.HRService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
public class HRController {
    @Autowired
    private HRService hrService;
    @PostMapping("/enterpriseLogin")
    public Result login(@RequestBody HumanResource humanResource){
        System.out.println("username: " + humanResource.getUsername() + " password: " + humanResource.getPassword());
        HumanResource hr = hrService.login(humanResource);
        if(hr != null){
            Map<String, Object> claims = new HashMap<>();
            claims.put("username",hr.getUsername());
            claims.put("password", hr.getPassword());
            claims.put("id", hr.getId());
            String jwt = JWTUtils.setAndGetJWT(claims);
            return Result.success(jwt);
        }
        return Result.error("用户名或密码错误");
    }
}
