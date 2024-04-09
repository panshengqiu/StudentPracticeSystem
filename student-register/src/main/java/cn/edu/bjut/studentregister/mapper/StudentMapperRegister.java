package cn.edu.bjut.studentregister.mapper;


import cn.edu.bjut.entity.student.other.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Insert;
@Mapper
public interface StudentMapperRegister {

    //先完成电话验证，后期有时间做邮箱验证
    @Insert("insert into student(name,username,phone,sex,password)values(#{name},#{username},#{phone},#{sex},#{password})")
    int insertStudent(String name,String username,String phone,String sex,String password);

}
