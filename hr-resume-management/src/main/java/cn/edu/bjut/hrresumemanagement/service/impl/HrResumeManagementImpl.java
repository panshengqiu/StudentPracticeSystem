package cn.edu.bjut.hrresumemanagement.service.impl;


import cn.edu.bjut.entity.hr.HumanResource;
import cn.edu.bjut.entity.hr.ResumeApproval;
import cn.edu.bjut.entity.hr.ResumeApprovalStage;
import cn.edu.bjut.entity.student.other.Submit;
import cn.edu.bjut.hrresumemanagement.mapper.HrResumeManagementMapper;
import org.apache.ibatis.annotations.One;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
@Qualifier("HrResumeManagementImpl")
public class HrResumeManagementImpl extends HrResumeManagementAbstractService{
    @Autowired
    private HrResumeManagementMapper hrResumeManagementMapper;
    @Autowired
    private ResumeApprovalStage resumeApprovalStage;

    @Autowired
    private ResumeApproval resumeApproval;

    @Override
    public Integer updateSubmit(Submit submit){
        Integer i = hrResumeManagementMapper.updateSubmitStatus(submit);
        return i;
    }

    @Override
    public List<Map<Object,Object>> selectSubmit(HumanResource humanResource){
        return hrResumeManagementMapper.selectSubmit(humanResource);
    }

    @Override
    public List<Map<Object,Object>> selectSubmit(Submit submit){
        return hrResumeManagementMapper.selectSubmitConditional(submit);
    }

    @Override
    public Integer insertResumeApproval(Submit submit,HumanResource humanResource){
        ResumeApproval resumeApproval1 = hrResumeManagementMapper.selectResumeApprovalOnsubmitId(submit);
        if(resumeApproval1 != null){
            return -1;
        }
        resumeApprovalStage.setStageName("初筛");
        resumeApprovalStage.setStatus("审核中");
        Integer approvalStageId = hrResumeManagementMapper.selectResumeApprovalStageId(resumeApprovalStage);
        resumeApprovalStage.setId(approvalStageId);
        resumeApproval.setResumeApprovalStage(resumeApprovalStage);

        resumeApproval.setSubmit(submit);
        resumeApproval.setHumanResource(humanResource);
        LocalDateTime currentTime = LocalDateTime.now();
        resumeApproval.setApprovalTime(currentTime);
        resumeApproval.setUpdateTime(currentTime);
        return hrResumeManagementMapper.insertResumeApproval(resumeApproval);
    }


    public List<Map<Object,Object>> selectApprovalRecord(HumanResource humanResource){
        return hrResumeManagementMapper.selectApprovalRecord(humanResource);
    }

    @Override
    public List<Map<Object,Object>> searchApprovalRecord(ResumeApproval resumeApproval){
        return hrResumeManagementMapper.selectApprovalRecordConditionally(resumeApproval);
    }



}
