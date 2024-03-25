package cn.edu.bjut.mapper;

import cn.edu.bjut.entity.HumanResource;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface HRMapper {
    @Select("select * from hummanresource where username = #{username} and password = #{password}")
    public HumanResource login(HumanResource humanResource);

}
