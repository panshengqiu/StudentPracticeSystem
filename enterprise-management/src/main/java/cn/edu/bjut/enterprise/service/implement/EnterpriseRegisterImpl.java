package cn.edu.bjut.enterprise.service.implement;

import cn.edu.bjut.enterprise.mapper.EnterpriseRegisterMapper;
import cn.edu.bjut.enterprise.service.EnterpriseRegisterService;
import cn.edu.bjut.entity.enterprise.Enterprise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnterpriseRegisterImpl implements EnterpriseRegisterService {

    @Autowired
    private EnterpriseRegisterMapper enterpriseRegisterMapper;
    @Override
    public int register(Enterprise enterprise) {
        return enterpriseRegisterMapper.insert(enterprise);
    }
}
