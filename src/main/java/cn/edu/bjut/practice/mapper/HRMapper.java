package cn.edu.bjut.practice.mapper;

import cn.edu.bjut.entity.hr.HumanResource;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface HRMapper {
    @Select("select * from human_resource where username = #{username} and password = #{password}")
    public HumanResource login(HumanResource humanResource);

}
