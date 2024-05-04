package cn.edu.bjut.studentsubmitresume.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SelectSubmitRecord {
    @Select("SELECT COUNT(*) FROM submit WHERE post_id = #{postId} AND stu_id = #{studentId}")
    int countSubmitRecord(int postId, int studentId);

}

