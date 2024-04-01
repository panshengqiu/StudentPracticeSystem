package cn.edu.bjut.studentregister.mapper;


import cn.edu.bjut.entity.student.other.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Insert;
@Mapper
public interface StudentMapper1 {

    @Insert("insert into student(name,username,phone,email,sex,birthday,password)values(#{name},#{username},#{phone},#{email},#{sex},#{birthday},#{password})")
    int insertStudent(Student student);

}
