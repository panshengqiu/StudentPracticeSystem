package cn.edu.bjut.hrresumemanagement.mapper;

import cn.edu.bjut.entity.hr.ResumeApproval;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface HrResumeApprovalMapper {
    List<Map<Object,Object>> selectApprovalRecordOnId(ResumeApproval resumeApproval);
    Integer updateResumeApprovalStage(ResumeApproval resumeApproval);
    List<Map<Object, Object>> selectApprovalRecordConditionally(ResumeApproval resumeApproval);
}
