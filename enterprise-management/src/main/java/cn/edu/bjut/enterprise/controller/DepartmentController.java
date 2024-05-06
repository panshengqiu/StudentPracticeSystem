package cn.edu.bjut.enterprise.controller;

import cn.edu.bjut.enterprise.service.DepartmentService;
import cn.edu.bjut.entity.hr.HumanResource;
import cn.edu.bjut.jwt.JWTUtils;
import cn.edu.bjut.result.Result;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class DepartmentController {
    ApplicationContext applicationContext;
    @Autowired
    DepartmentService departmentService;

    @Autowired
    HumanResource humanResource;

    @GetMapping("/getHeadLogoUrl")
    public Result getHeadLogoUrl(HttpServletRequest request){
        String jwt = request.getHeader("Authorization");
        Claims claims = JWTUtils.parseJWT(jwt);
        int hrId = (int)claims.get("id");
        humanResource.setId(hrId);
        String headLogoUrl = departmentService.select(humanResource);
        if(headLogoUrl != null){
            return Result.success(headLogoUrl);
        }
        return Result.error("Not fund department headLogUrl!");
    }

    @PostMapping("/updateDepartmentInfo")
    public Result updateDepartmentInfo(@RequestBody HumanResource humanResource,HttpServletRequest request){
        String jwt = request.getHeader("Authorization");
        Claims claims = JWTUtils.parseJWT(jwt);
        int hrId = (int)claims.get("id");
        humanResource.setId(hrId);

        Integer updateNum = departmentService.update(humanResource);
        if(updateNum > 0){
            return Result.success("Update success!");
        }
        return Result.error("Update error!");
    }

    @GetMapping("/getDepartmentInfo")
    public Result getDepartmentInfo(HttpServletRequest request){
        String jwt = request.getHeader("Authorization");
        Claims claims = JWTUtils.parseJWT(jwt);
        int hrId = (int)claims.get("id");
        humanResource.setId(hrId);
        HumanResource humanResource1 = departmentService.selectDepartmentInfo(humanResource);
        if(humanResource1 == null){
            return Result.error("Get department info error!");
        }
        return Result.success(humanResource1);
    }


}
