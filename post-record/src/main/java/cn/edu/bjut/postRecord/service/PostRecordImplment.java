package cn.edu.bjut.postRecord.service;

import cn.edu.bjut.entity.PostRecordReturn;
import cn.edu.bjut.entity.hr.ResumeApproval;
import cn.edu.bjut.postRecord.mapper.PostRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostRecordImplment implements PostRecordService{
    @Autowired
    private PostRecordMapper postRecordMapper;
    @Override
    public List<PostRecordReturn> getAllApproval(Integer studentId, String resumeApproval) {
        return postRecordMapper.getAllApproval(studentId,resumeApproval);
    }
}
