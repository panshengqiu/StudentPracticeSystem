package cn.edu.bjut.hrresumemanagement.controller;

import cn.edu.bjut.entity.hr.ResumeApproval;
import cn.edu.bjut.hrresumemanagement.service.HrResumeApprovalService;
import cn.edu.bjut.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class HrResumeApprovalController {
    @Autowired
    private HrResumeApprovalService hrResumeApprovalService;

    @PostMapping("/getOneSubmitApprovalInfo")
    public Result getOneSubmitApprovalInfo(@RequestBody ResumeApproval resumeApproval){
        List<Map<Object, Object>> maps = hrResumeApprovalService.selectApprovalRecordOnId(resumeApproval);
        if(maps.isEmpty()){
            return Result.error("Not fund approval record!");
        }
        return Result.success(maps);
    }

    @PostMapping("/updateApprovalStage")
    public Result updateApprovalStage(@RequestBody ResumeApproval resumeApproval){
        Integer updateNum = hrResumeApprovalService.updateResumeApprovalStage(resumeApproval);
        if(updateNum < 0){
            return Result.error("Not fund approval record!");
        }
        return Result.success("Update approval stage success!");
    }

    @PostMapping("/selectApprovalRecordConditionallyTow")
    public Result selectApprovalRecordConditionallyTow(@RequestBody ResumeApproval resumeApproval){
        List<Map<Object, Object>> maps = hrResumeApprovalService.selectApprovalRecordConditionally(resumeApproval);
        if(maps.isEmpty()){
            return Result.error("Get resume submit record error!");
        }
        return Result.success(maps);
    }



}
