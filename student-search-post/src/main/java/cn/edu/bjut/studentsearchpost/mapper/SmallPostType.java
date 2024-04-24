package cn.edu.bjut.studentsearchpost.mapper;

import cn.edu.bjut.entity.post.PostSmallTypeWithBigTypeName;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SmallPostType {
    @Select("SELECT small.name AS small_name, big.name AS big_name " +
            "FROM post_small_type AS small " +
            "JOIN post_big_type AS big ON small.big_id = big.id")
    List<PostSmallTypeWithBigTypeName> getAllSmallPostTypesWithBigTypeName();

}
