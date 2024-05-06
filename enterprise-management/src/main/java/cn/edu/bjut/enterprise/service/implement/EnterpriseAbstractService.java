package cn.edu.bjut.enterprise.service.implement;

import cn.edu.bjut.enterprise.service.EnterpriseService;
import cn.edu.bjut.entity.enterprise.Enterprise;
import cn.edu.bjut.entity.hr.HumanResource;

import java.util.List;
import java.util.Map;

public abstract class EnterpriseAbstractService implements EnterpriseService {
    @Override
    public Integer update(HumanResource humanResource){

        return 0;
    }

    @Override
    public List<Map<Object,Object>> select(HumanResource humanResource){
        return null;
    }

    @Override
    public List<Enterprise> select(){
        return null;
    }
}
