package cn.edu.bjut.hrresumemanagement.service;

import cn.edu.bjut.entity.hr.HumanResource;
import cn.edu.bjut.entity.hr.ResumeApproval;
import cn.edu.bjut.entity.student.other.Submit;

import java.util.List;
import java.util.Map;

public interface HrResumeManagementService {
     List<Map<Object,Object>> select(Submit submit);
     List<Map<Object,Object>> select(ResumeApproval resumeApproval);
     Integer updateSubmit(Submit submit);
     List<Map<Object,Object>> selectSubmit(HumanResource humanResource);
     List<Map<Object,Object>> selectSubmit(Submit submit);
     Integer insertResumeApproval(Submit submit, HumanResource humanResource);
     List<Map<Object,Object>> selectApprovalRecord(HumanResource humanResource);
     List<Map<Object,Object>> searchApprovalRecord(ResumeApproval resumeApproval);
}
