package cn.edu.bjut.controller;


import cn.edu.bjut.entity.HumanResource;
import cn.edu.bjut.filter.Result;
import cn.edu.bjut.service.HRService;
import cn.edu.bjut.utils.JWTUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
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
            claims.put("id", hr.getId());
            String jwt = JWTUtils.getJWT();
            return Result.success(jwt);
        }
        return Result.error("用户名或密码错误");
    }
}
