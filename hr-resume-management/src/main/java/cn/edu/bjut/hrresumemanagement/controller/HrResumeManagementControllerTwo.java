package cn.edu.bjut.hrresumemanagement.controller;


import cn.edu.bjut.entity.hr.ResumeApproval;
import cn.edu.bjut.hrresumemanagement.service.HrResumeManagementService;
import cn.edu.bjut.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class HrResumeManagementControllerTwo {
    private HrResumeManagementService hrResumeManagementService;

    @Autowired
    public HrResumeManagementControllerTwo(@Qualifier("hrResumeManagementImplTwo") HrResumeManagementService hrResumeManagementService) {
        this.hrResumeManagementService = hrResumeManagementService;
    }

    @PostMapping("/selectPostSubmitSituationOnApprovalStage")
    public Result selectPostSubmitSituation(@RequestBody ResumeApproval resumeApproval) {
        List<Map<Object, Object>> maps = hrResumeManagementService.select(resumeApproval);
        if (maps.isEmpty()) {
            return Result.error("Get resume submit record error!");
        }
        return Result.success(maps);
    }
}
