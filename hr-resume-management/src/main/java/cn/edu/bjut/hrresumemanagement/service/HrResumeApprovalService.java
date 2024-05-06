package cn.edu.bjut.hrresumemanagement.service;

import cn.edu.bjut.entity.hr.ResumeApproval;

import java.util.List;
import java.util.Map;

public interface HrResumeApprovalService {
    public List<Map<Object,Object>> selectApprovalRecordOnId(ResumeApproval resumeApproval);
    public Integer updateResumeApprovalStage(ResumeApproval resumeApproval);
    public List<Map<Object,Object>> selectApprovalRecordConditionally(ResumeApproval resumeApproval);
}
