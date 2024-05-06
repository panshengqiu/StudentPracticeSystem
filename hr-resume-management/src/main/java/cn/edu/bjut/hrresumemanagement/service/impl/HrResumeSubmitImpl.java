package cn.edu.bjut.hrresumemanagement.service.impl;

import cn.edu.bjut.entity.student.other.Submit;
import cn.edu.bjut.hrresumemanagement.mapper.HrResumeSubmitMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class HrResumeSubmitImpl extends HrResumeSubmitAbstractService{

    @Autowired
    private HrResumeSubmitMapper hrResumeSubmitMapper;
    @Override
    public List<Map<Object, Object>> select(Submit submit) {
        return hrResumeSubmitMapper.selectSubmitConditionallyOne(submit);
    }
}
