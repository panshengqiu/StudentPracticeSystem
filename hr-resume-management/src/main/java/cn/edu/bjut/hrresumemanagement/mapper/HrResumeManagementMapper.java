package cn.edu.bjut.hrresumemanagement.mapper;

import cn.edu.bjut.entity.hr.HumanResource;
import cn.edu.bjut.entity.hr.ResumeApproval;
import cn.edu.bjut.entity.hr.ResumeApprovalStage;
import cn.edu.bjut.entity.student.other.Submit;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface HrResumeManagementMapper {

    public List<Map<Object,Object>> selectResumeSubmitOnStage(Submit submit);
    public List<Map<Object,Object>> selectResumeSubmitOnApprovalStage(ResumeApproval resumeApproval);
    Integer updateSubmitStatus(Submit submit);

    List<Map<Object,Object>> selectSubmit(HumanResource humanResource);
    List<Map<Object,Object>> selectSubmitConditional(Submit submit);
    Integer insertResumeApproval(ResumeApproval resumeApproval);

    Integer selectResumeApprovalStageId(ResumeApprovalStage resumeApprovalStage);
    ResumeApproval selectResumeApprovalOnsubmitId(Submit submit);

    List<Map<Object,Object>> selectApprovalRecord(HumanResource humanResource);
    List<Map<Object,Object>> selectApprovalRecordConditionally(ResumeApproval resumeApproval);

}
