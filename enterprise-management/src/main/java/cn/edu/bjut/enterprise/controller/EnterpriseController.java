package cn.edu.bjut.enterprise.controller;

import cn.edu.bjut.enterprise.service.EnterpriseService;
import cn.edu.bjut.entity.enterprise.Enterprise;
import cn.edu.bjut.entity.hr.HumanResource;
import cn.edu.bjut.jwt.JWTUtils;
import cn.edu.bjut.result.Result;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class EnterpriseController {
    @Autowired
    private EnterpriseService enterpriseService;

    @PostMapping("/changeFirmInfo")
    public Result changeFirmInfo(@RequestBody HumanResource humanResource){
        Integer updateNum = enterpriseService.update(humanResource);
        if(updateNum>0)
            return Result.success("Update success!");
        return Result.error("Update failed!");
    }

    @PostMapping("/getFirmInfo")
    public Result getFirmInfo(@RequestBody HumanResource humanResource, HttpServletRequest request){
        String jwt = request.getHeader("Authorization");
        Claims claims = JWTUtils.parseJWT(jwt);
        log.info("校验解析后的令牌：{}", claims);
        Integer hrId = (Integer) claims.get("id");
        humanResource.setId(hrId);
        List<Map<Object,Object>> enterprises = enterpriseService.select(humanResource);
        if(!enterprises.isEmpty()){
            return Result.success(enterprises);
        }

        return Result.error("Get firm information error!");
    }
}
