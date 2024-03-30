package cn.edu.bjut.practice.mapper;

import cn.edu.bjut.entity.student.other.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface StudentMapper {
    @Select("select * from student where username = #{username} and password = #{password}")
    public Student login(String username, String password);
}
