package cn.edu.bjut.managerlogin.service.implement;


import cn.edu.bjut.entity.manager.Manager;
import cn.edu.bjut.managerlogin.mapper.ManagerLoginMapper;
import cn.edu.bjut.managerlogin.service.ManagerLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerLoginImpl implements ManagerLoginService {

    @Autowired
    private ManagerLoginMapper managerLoginMapper;

    public Manager login(Manager manager) {
        return managerLoginMapper.login(manager);
    }
}
