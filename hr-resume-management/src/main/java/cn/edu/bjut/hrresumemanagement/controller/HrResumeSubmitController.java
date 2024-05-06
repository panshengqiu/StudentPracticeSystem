package cn.edu.bjut.hrresumemanagement.controller;


import cn.edu.bjut.entity.student.other.Submit;
import cn.edu.bjut.hrresumemanagement.service.HrResumeSubmitService;
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
public class HrResumeSubmitController {

    @Autowired
    private HrResumeSubmitService hrResumeSubmitService;

    @PostMapping("/searchSubmitRecordConditionalTwo")
    public Result searchSubmitRecordConditionalTwo(@RequestBody Submit submit){
        List<Map<Object, Object>> maps = hrResumeSubmitService.select(submit);
        if(maps.isEmpty()){
            return Result.error("Not fund submit record!");
        }
        return Result.success(maps);
    }
}
