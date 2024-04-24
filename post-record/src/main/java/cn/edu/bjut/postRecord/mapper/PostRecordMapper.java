package cn.edu.bjut.postRecord.mapper;

import cn.edu.bjut.entity.PostRecordReturn;
import cn.edu.bjut.entity.hr.ResumeApproval;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostRecordMapper {


    List<PostRecordReturn> getAllApproval(Integer studentId,String resumeApproval);
}
