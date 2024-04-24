package cn.edu.bjut.postRecord.service;

import cn.edu.bjut.entity.PostRecordReturn;
import cn.edu.bjut.entity.hr.ResumeApproval;

import java.util.List;
import java.util.Map;

public interface PostRecordService {
     List<PostRecordReturn> getAllApproval(Integer studentId, String resumeApproval);
}
