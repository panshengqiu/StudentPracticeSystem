package cn.edu.bjut.hrregister.service.implement;

import cn.edu.bjut.entity.enterprise.Enterprise;
import cn.edu.bjut.entity.hr.HumanResource;
import cn.edu.bjut.entity.manager.RegisterApproval;
import cn.edu.bjut.hrregister.mapper.HrRegisterMapper;
import cn.edu.bjut.hrregister.service.HrRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HrRegisterImpl implements HrRegisterService {

    @Autowired
    HrRegisterMapper hrRegisterMapper;
    @Override
    public int register(HumanResource humanResource) {
        return hrRegisterMapper.register(humanResource);
    }

    @Override
    public String isFirmRegister(String name, String creditCode) {
        return hrRegisterMapper.firmIsRegister(name,creditCode);
    }

    @Override
    public String isFirmApproval(String name, String creditCode) {
        return hrRegisterMapper.isFirmApproval(name, creditCode);
    }

    @Override
    public int getEnterpriseId(String name, String creditCode) {
        return hrRegisterMapper.selectEnterpriseId(name, creditCode);
    }

    @Override
    public boolean checkHrUsername(String username) {
        HumanResource humanResource = hrRegisterMapper.selectHrUsername(username);
        if(humanResource != null)
            return false;
        else return true;
    }
}
