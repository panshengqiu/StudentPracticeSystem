package cn.edu.bjut.postRecord.service;

import cn.edu.bjut.entity.PostRecordReturn;
import cn.edu.bjut.entity.hr.ResumeApproval;
import cn.edu.bjut.entity.student.other.Submit;

import java.util.List;
import java.util.Map;

public interface PostRecordService {
     List<PostRecordReturn> getAllApproval(ResumeApproval resumeApproval);

     List<PostRecordReturn> getAllSeenApproval(Submit submit);

     List<PostRecordReturn> getAllApprovalFail(ResumeApproval resumeApproval);
}
