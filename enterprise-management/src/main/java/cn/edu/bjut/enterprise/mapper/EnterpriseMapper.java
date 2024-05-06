package cn.edu.bjut.enterprise.mapper;

import cn.edu.bjut.entity.enterprise.Enterprise;
import cn.edu.bjut.entity.hr.HumanResource;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface EnterpriseMapper {
    Integer update(HumanResource humanResource);

    List<Map<Object,Object>> select(HumanResource humanResource);
}
