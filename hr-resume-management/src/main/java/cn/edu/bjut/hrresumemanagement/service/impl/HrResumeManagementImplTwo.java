package cn.edu.bjut.hrresumemanagement.service.impl;


import cn.edu.bjut.entity.hr.ResumeApproval;
import cn.edu.bjut.hrresumemanagement.mapper.HrResumeManagementMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Qualifier("hrResumeManagementImplTwo")
public class HrResumeManagementImplTwo extends HrResumeManagementAbstractService{
    @Autowired
    private HrResumeManagementMapper hrResumeManagementMapper;

    @Override
    public List<Map<Object,Object>> select(ResumeApproval resumeApproval){
        return hrResumeManagementMapper.selectResumeSubmitOnApprovalStage(resumeApproval);
    }
}
