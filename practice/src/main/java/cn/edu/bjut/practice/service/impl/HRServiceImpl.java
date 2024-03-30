package cn.edu.bjut.practice.service.impl;

import cn.edu.bjut.entity.hr.HumanResource;
import cn.edu.bjut.practice.mapper.HRMapper;
import cn.edu.bjut.practice.service.HRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HRServiceImpl implements HRService {

    @Autowired
    private HRMapper hrMapper;
    public HumanResource login(HumanResource humanResource) {
        return hrMapper.login(humanResource);
    }
}
