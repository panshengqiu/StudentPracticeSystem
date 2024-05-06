package cn.edu.bjut.enterprise.service.implement;

import cn.edu.bjut.enterprise.mapper.EnterpriseMapper;
import cn.edu.bjut.entity.enterprise.Enterprise;
import cn.edu.bjut.entity.hr.HumanResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class EnterpriseServiceImpl extends EnterpriseAbstractService {
    @Autowired
    private EnterpriseMapper enterpriseMapper;
    @Override
    public Integer update(HumanResource humanResource) {

        return enterpriseMapper.update(humanResource);
    }

    @Override
    public List<Map<Object,Object>> select(HumanResource humanResource){
        return enterpriseMapper.select(humanResource);
    }
}
