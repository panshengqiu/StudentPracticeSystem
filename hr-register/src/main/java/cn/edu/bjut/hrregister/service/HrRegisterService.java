package cn.edu.bjut.hrregister.service;

import cn.edu.bjut.entity.enterprise.Enterprise;
import cn.edu.bjut.entity.hr.HumanResource;
import cn.edu.bjut.entity.manager.RegisterApproval;

public interface HrRegisterService {
    public int register(int id, String username, String password);
    public String isFirmRegister(String name, String creditCode);
    public String isFirmApproval(String name, String creditCode);
    public int getEnterpriseId(String name, String creditCode);

    public boolean checkHrUsername(String username);
}
