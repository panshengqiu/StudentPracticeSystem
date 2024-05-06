package cn.edu.bjut.hrresumemanagement.service.impl;

import cn.edu.bjut.entity.hr.ResumeApproval;
import cn.edu.bjut.hrresumemanagement.mapper.HrResumeApprovalMapper;
import cn.edu.bjut.hrresumemanagement.service.HrResumeApprovalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class HrResumeApprovalImpl implements HrResumeApprovalService {
    @Autowired
    private HrResumeApprovalMapper hrResumeApprovalMapper;
    @Override
    public List<Map<Object, Object>> selectApprovalRecordOnId(ResumeApproval resumeApproval) {
        return hrResumeApprovalMapper.selectApprovalRecordOnId(resumeApproval);
    }

    @Override
    public Integer updateResumeApprovalStage(ResumeApproval resumeApproval) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        resumeApproval.setUpdateTime(currentDateTime);
        return hrResumeApprovalMapper.updateResumeApprovalStage(resumeApproval);
    }

    @Override
    public List<Map<Object, Object>> selectApprovalRecordConditionally(ResumeApproval resumeApproval) {
        return hrResumeApprovalMapper.selectApprovalRecordConditionally(resumeApproval);
    }
}
