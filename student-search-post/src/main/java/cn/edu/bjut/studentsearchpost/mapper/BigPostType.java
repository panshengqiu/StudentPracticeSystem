package cn.edu.bjut.studentsearchpost.mapper;

import cn.edu.bjut.entity.post.PostBigType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BigPostType {
    @Select("select name from post_big_type")
    List<PostBigType> getAllBigPostTypes();

}
