package cn.edu.bjut.mapper;


import cn.edu.bjut.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface StudentMapper {
    @Select("select * from student where username = #{username} and password = #{password}")
    public Student login(String username, String password);
}
