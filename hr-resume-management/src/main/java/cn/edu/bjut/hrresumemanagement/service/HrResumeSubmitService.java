package cn.edu.bjut.hrresumemanagement.service;

import cn.edu.bjut.entity.student.other.Submit;

import java.util.List;
import java.util.Map;

public interface HrResumeSubmitService {
    List<Map<Object,Object>> select(Submit submit);
}
