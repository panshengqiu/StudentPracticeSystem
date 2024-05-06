package cn.edu.bjut.enterprise.service;

import cn.edu.bjut.entity.enterprise.Enterprise;
import cn.edu.bjut.entity.hr.HumanResource;

import java.util.List;
import java.util.Map;

public interface EnterpriseService {
    Integer update(HumanResource humanResource);
    List<Map<Object,Object>> select(HumanResource humanResource);
    List<Enterprise> select();


}
