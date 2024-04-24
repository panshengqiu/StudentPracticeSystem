package cn.edu.bjut.studentsearchpost.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SelectSmallTypeId {
    @Select("SELECT id FROM post_small_type WHERE name = #{smallType}")
    int selectSmallTypeIdByName(@Param("smallType") String smallType);
}
