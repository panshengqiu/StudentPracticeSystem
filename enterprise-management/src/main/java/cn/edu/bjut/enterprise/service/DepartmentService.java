package cn.edu.bjut.enterprise.service;

import cn.edu.bjut.entity.hr.HumanResource;

public interface DepartmentService {
    String select(HumanResource humanResource);

    HumanResource selectDepartmentInfo(HumanResource humanResource);

    Integer update(HumanResource humanResource);
}
