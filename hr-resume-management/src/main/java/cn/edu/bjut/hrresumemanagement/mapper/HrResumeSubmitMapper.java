package cn.edu.bjut.hrresumemanagement.mapper;

import cn.edu.bjut.entity.student.other.Submit;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface HrResumeSubmitMapper {
    public List<Map<Object,Object>> selectSubmitConditionallyOne(Submit submit);
}
