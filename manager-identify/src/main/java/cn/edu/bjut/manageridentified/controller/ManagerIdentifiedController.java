package cn.edu.bjut.manageridentified.controller;


import cn.edu.bjut.entity.enterprise.Enterprise;
import cn.edu.bjut.manageridentified.service.ManagerIdentifyService;
import cn.edu.bjut.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
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
        Enterprise enterprise1 = managerIdentifyService.enterpriseDetail(enterprise);
        if(enterprise1 == null)
            return Result.error("未查找到企业信息");
        return Result.success(enterprise1);
    }
}
