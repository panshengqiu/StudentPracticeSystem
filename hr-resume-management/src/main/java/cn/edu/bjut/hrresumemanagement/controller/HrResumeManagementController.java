package cn.edu.bjut.hrresumemanagement.controller;

import cn.edu.bjut.entity.hr.HumanResource;
import cn.edu.bjut.entity.hr.ResumeApproval;
import cn.edu.bjut.entity.student.other.Submit;
import cn.edu.bjut.hrresumemanagement.service.HrResumeManagementService;
import cn.edu.bjut.jwt.JWTUtils;
import cn.edu.bjut.result.Result;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class HrResumeManagementController {

    private HrResumeManagementService hrResumeManagementService;

    @Autowired
    private HumanResource humanResource;

    @Autowired
    public HrResumeManagementController(@Qualifier("HrResumeManagementImpl") HrResumeManagementService hrResumeManagementService){
        this.hrResumeManagementService = hrResumeManagementService;
    }

    @PostMapping("/updateSubmitStatus")
    public Result updateSubmitStatus(@RequestBody Submit submit){
        Integer updateNum = hrResumeManagementService.updateSubmit(submit);
        if(updateNum>0){
            return Result.success("Update submit status success!");
        }
        return Result.error("Update submit status error!");
    }

    @GetMapping("/getSubmitRecord")
    public Result getSubmitRecord(HttpServletRequest request){
        String jwt = request.getHeader("Authorization");
        Claims claims = JWTUtils.parseJWT(jwt);
        Integer hrId = (Integer) claims.get("id");
        humanResource.setId(hrId);
        List<Map<Object, Object>> maps = hrResumeManagementService.selectSubmit(humanResource);
        if(maps.isEmpty()){
            return Result.error("No submit!");
        }
        return Result.success(maps);
    }
    @PostMapping("/searchSubmitRecordConditional")
    public Result searchSubmitRecordConditional(@RequestBody Submit submit,HttpServletRequest request){
        String jwt = request.getHeader("Authorization");
        Claims claims = JWTUtils.parseJWT(jwt);
        Integer hrId = (Integer) claims.get("id");
        humanResource.setId(hrId);
        submit.getPost().setHumanResource(humanResource);

        List<Map<Object, Object>> maps = hrResumeManagementService.selectSubmit(submit);
        if(maps.isEmpty()){
            return Result.error("Not fund resume submit record!");
        }
        return Result.success(maps);

    }


    @PostMapping("/intoPreliminaryScreening")
    public Result intoPreliminaryScreening(@RequestBody Submit submit, HttpServletRequest request){
        String jwt = request.getHeader("Authorization");
        Claims claims = JWTUtils.parseJWT(jwt);
        Integer hrId = (Integer) claims.get("id");
        humanResource.setId(hrId);
        Integer result = hrResumeManagementService.insertResumeApproval(submit,humanResource);
        if(result == -1){
            return Result.error("操作失败，简历已经在审批流程中！");
        }
        if(result > 0){
            return Result.success("操作成功，简历进入初筛阶段！");
        }
        return Result.error("操作失败，请联系系统管理员！");
    }

    @GetMapping("/getApprovalRecord")
    public Result getApprovalRecord(HttpServletRequest request){
        String jwt = request.getHeader("Authorization");
        Claims claims = JWTUtils.parseJWT(jwt);
        Integer hrId = (Integer) claims.get("id");
        humanResource.setId(hrId);
        List<Map<Object, Object>> maps = hrResumeManagementService.selectApprovalRecord(humanResource);
        if(maps.isEmpty()){
            return Result.error("Not fund approval record!");
        }
        return Result.success(maps);
    }

    @PostMapping("/selectApprovalRecordConditionally")
    public Result selectApprovalRecordConditionally(@RequestBody ResumeApproval resumeApproval,HttpServletRequest request){
        String jwt = request.getHeader("Authorization");
        Claims claims = JWTUtils.parseJWT(jwt);
        Integer hrId = (Integer) claims.get("id");
        humanResource.setId(hrId);
        resumeApproval.setHumanResource(humanResource);
        List<Map<Object, Object>> maps = hrResumeManagementService.searchApprovalRecord(resumeApproval);
        if(maps.isEmpty()){
            return Result.error("Not fund approval record!");
        }
        return Result.success(maps);
    }
}
