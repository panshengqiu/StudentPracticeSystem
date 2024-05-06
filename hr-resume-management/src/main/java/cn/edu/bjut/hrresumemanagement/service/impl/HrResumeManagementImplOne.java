package cn.edu.bjut.hrresumemanagement.service.impl;

import cn.edu.bjut.entity.student.other.Submit;
import cn.edu.bjut.hrresumemanagement.mapper.HrResumeManagementMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Qualifier("hrResumeManagementImplOne")
public class HrResumeManagementImplOne extends HrResumeManagementAbstractService{
    @Autowired
    private HrResumeManagementMapper hrResumeManagementMapper;

    @Override
    public List<Map<Object,Object>> select(Submit submit){
        List<Map<Object, Object>> maps = hrResumeManagementMapper.selectResumeSubmitOnStage(submit);
        return maps;
    }
}
