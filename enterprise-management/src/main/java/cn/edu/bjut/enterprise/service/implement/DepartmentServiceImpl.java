package cn.edu.bjut.enterprise.service.implement;

import cn.edu.bjut.enterprise.mapper.DepartmentMapper;
import cn.edu.bjut.enterprise.service.DepartmentService;
import cn.edu.bjut.entity.hr.HumanResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentMapper departmentMapper;
    @Override
    public String select(HumanResource humanResource) {
        return departmentMapper.selectHrHeadUrl(humanResource);
    }

    @Override
    public HumanResource selectDepartmentInfo(HumanResource humanResource) {
        return departmentMapper.selectDepartmentInfo(humanResource);
    }

    @Override
    public Integer update(HumanResource humanResource) {
        return departmentMapper.updateDepartmentInfo(humanResource);
    }
}
