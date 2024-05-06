package cn.edu.bjut.studentsubmitresume.mapper;

import cn.edu.bjut.entity.student.other.Resume;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface SelectResumeByStudentId {
    @Select("SELECT resume_url,name FROM resume WHERE stu_id=#{studentId}")
    List<Resume> allResumeByStudentId(String studentId);
}
