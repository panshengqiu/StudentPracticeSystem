package cn.edu.bjut.postRecord.mapper;

import cn.edu.bjut.entity.PostRecordReturn;
import cn.edu.bjut.entity.hr.ResumeApproval;
import cn.edu.bjut.entity.student.other.Submit;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostRecordMapper {


    List<PostRecordReturn> getAllApproval(ResumeApproval resumeApproval);

    List<PostRecordReturn> getAllSeenApproval(Submit submit);

    List<PostRecordReturn> getAllSeenApprovalFail(ResumeApproval resumeApproval);
}
