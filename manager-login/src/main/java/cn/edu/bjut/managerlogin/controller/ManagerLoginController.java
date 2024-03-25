package cn.edu.bjut.managerlogin.controller;

import cn.edu.bjut.entity.manager.Manager;
import cn.edu.bjut.jwt.JWTUtils;
import cn.edu.bjut.managerlogin.service.ManagerLoginService;
import cn.edu.bjut.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
public class ManagerLoginController {
    @Autowired
    private ManagerLoginService managerLoginService;
    @PostMapping("/managerLogin")
    public Result login(@RequestBody Manager manager){
        System.out.println("username: " + manager.getUsername() + " password: " + manager.getPassword());
        Manager manager1 = managerLoginService.login(manager);
        if(manager1 != null){
            Map<String, Object> claims = new HashMap<>();
            claims.put("username",manager1.getUsername());
            claims.put("id", manager1.getId());
            String jwt = JWTUtils.getJWT();
            return Result.success(jwt);
        }
        return Result.error("用户名或密码错误");
    }
}
