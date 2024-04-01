package cn.edu.bjut.managerlogin.controller;

import cn.edu.bjut.entity.manager.Manager;
import cn.edu.bjut.jwt.JWTUtils;
import cn.edu.bjut.managerlogin.service.ManagerLoginService;
import cn.edu.bjut.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ManagerLoginController {
    @Autowired
    private ManagerLoginService managerLoginService;

    @PostMapping("/managerLogin")
    public Result login(@RequestBody Manager manager) {

        Manager manager1 =  managerLoginService.login(manager);
        if(manager1 != null){
            Map<String, Object> claims = new HashMap<>();
            claims.put("username",manager1.getUsername());
            claims.put("password", manager1.getPassword());
            String jwt = JWTUtils.setAndGetJWT(claims);
            return Result.success(jwt);
        }
        return Result.error("用户名或密码错误");
    }
}
