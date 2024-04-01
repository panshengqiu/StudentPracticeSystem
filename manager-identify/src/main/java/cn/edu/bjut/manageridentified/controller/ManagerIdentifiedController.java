package cn.edu.bjut.manageridentified.controller;


import cn.edu.bjut.entity.enterprise.Enterprise;
import cn.edu.bjut.entity.manager.Manager;
import cn.edu.bjut.entity.manager.RegisterApproval;
import cn.edu.bjut.jwt.JWTUtils;
import cn.edu.bjut.manageridentified.service.ManagerIdentifyService;
import cn.edu.bjut.result.Result;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@CrossOrigin
public class ManagerIdentifiedController {

    @Autowired
    private ManagerIdentifyService managerIdentifyService;
    @GetMapping("/selectPendingFirm")
    public Result selectPaddingFirm(){

        List<Enterprise> enterprises = managerIdentifyService.selectPendingFirm();
        return Result.success(enterprises);
    }


    @GetMapping("/selectApprovaledFirm")
    public Result selectApprovaledFirm(){
        List<Map<Object, Object>> approvals =  managerIdentifyService.selectApprovalFirm();
        log.info("approvals:", approvals);
        return Result.success(approvals);
    }

    @PostMapping("/enterpriseDetail")
    public Result enterpriseDetail(@RequestBody Enterprise enterprise){
        log.info("企业id", enterprise.getId());
        Enterprise enterprise1 = managerIdentifyService.enterpriseDetail(enterprise);
        if(enterprise1 == null)
            return Result.error("未查找到企业信息");
        return Result.success(enterprise1);
    }

    @PostMapping("/searchPendingFirm")
    public Result searchPendingFirm(@RequestBody Enterprise enterprise){
        log.info("企业名称：{}",enterprise.getName());
        log.info("社会信用代码：{}",enterprise.getCreditCode());
        List<Enterprise> pendingEnterprises = managerIdentifyService.selectPendingFirmOnNameAndCreditCode(enterprise);
        return Result.success(pendingEnterprises);
    }

    @PostMapping("/searchApprovalRecord")
    public Result searchApprovalRecord(@RequestBody RegisterApproval registerApproval){
        List<Map<Object, Object>> registerApprovalList = managerIdentifyService.selectApprovalFirmOnStatus(registerApproval);
        return  Result.success(registerApprovalList);
    }

    @PostMapping("/approvalRegisterFirm")
    public Result approvalRegisterFirm(@RequestBody RegisterApproval registerApproval, HttpServletRequest request){
         //5. 校验令牌

        log.info("registerApproval:", registerApproval);

        String jwt = request.getHeader("Authorization");
        Claims claims = JWTUtils.parseJWT(jwt);
        log.info("校验解析后的令牌：{}", claims);

        // 获取当前登入的管理员的用户名
        Integer managerId = (Integer) claims.get("id");
        Manager manager = new Manager();
        registerApproval.setManager(manager);
        registerApproval.getManager().setId(managerId);

        Boolean success = managerIdentifyService.approvalRegisterFirm(registerApproval);
        if(success)
            return Result.success("审核成功！");
        return Result.error("failure!");
    }
}
