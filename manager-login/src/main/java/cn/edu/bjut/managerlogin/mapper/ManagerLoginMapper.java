package cn.edu.bjut.managerlogin.mapper;


import cn.edu.bjut.entity.manager.Manager;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ManagerLoginMapper {
    @Select("select * from Manager where username=#{username} and password=#{password}")
    Manager login(Manager manager);
}
