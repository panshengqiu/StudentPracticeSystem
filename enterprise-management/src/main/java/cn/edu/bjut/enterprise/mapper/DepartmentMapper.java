package cn.edu.bjut.enterprise.mapper;

import cn.edu.bjut.entity.hr.HumanResource;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

@Mapper
public interface DepartmentMapper {
    @Select("select head_url from human_resource where id=#{id};")
    String selectHrHeadUrl(HumanResource humanResource);

    Integer updateDepartmentInfo(HumanResource humanResource);

    HumanResource selectDepartmentInfo(HumanResource humanResource);
}
