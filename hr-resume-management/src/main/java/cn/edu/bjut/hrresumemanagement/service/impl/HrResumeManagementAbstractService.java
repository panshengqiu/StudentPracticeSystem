package cn.edu.bjut.hrresumemanagement.service.impl;

import cn.edu.bjut.entity.hr.HumanResource;
import cn.edu.bjut.entity.hr.ResumeApproval;
import cn.edu.bjut.entity.student.other.Submit;
import cn.edu.bjut.hrresumemanagement.service.HrResumeManagementService;

import java.util.List;
import java.util.Map;

public abstract class HrResumeManagementAbstractService implements HrResumeManagementService {
    @Override
    public List<Map<Object,Object>> select(Submit submit){
        return null;
    }

    @Override
    public List<Map<Object,Object>> select(ResumeApproval resumeApproval){
        return null;
    }

    @Override
    public Integer updateSubmit(Submit submit){
        return -1;
    }

    @Override
    public List<Map<Object,Object>> selectSubmit(HumanResource humanResource){
        return null;
    }

    @Override
    public List<Map<Object,Object>> selectSubmit(Submit submit){
        return null;
    }
    public Integer insertResumeApproval(Submit submit,HumanResource humanResource){
        return -1;
    }

    @Override
    public List<Map<Object,Object>> selectApprovalRecord(HumanResource humanResource){
        return null;
    }

    @Override
    public List<Map<Object,Object>> searchApprovalRecord(ResumeApproval resumeApproval){
        return null;
    }


}
