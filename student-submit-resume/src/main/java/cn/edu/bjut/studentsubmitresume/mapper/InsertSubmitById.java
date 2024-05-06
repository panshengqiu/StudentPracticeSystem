package cn.edu.bjut.studentsubmitresume.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface InsertSubmitById {

    @Insert("INSERT INTO submit (stu_id, resume_id, post_id, submit_time) " +
            "VALUES (#{stu_id}, (SELECT resume.id FROM resume WHERE resume.resume_url = #{resumeUrl}),#{post_id}, NOW())"
    )
    void insertSubmit(int stu_id,int  post_id,String resumeUrl);




}

