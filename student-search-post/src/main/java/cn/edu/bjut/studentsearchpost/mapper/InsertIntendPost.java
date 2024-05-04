package cn.edu.bjut.studentsearchpost.mapper;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

@Mapper
public interface InsertIntendPost {

    @InsertProvider(type = IntendPostSqlProvider.class, method = "insertIntend")
    void insertIntend(Map<String, Object> params);
}
