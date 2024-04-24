package cn.edu.bjut.studentsearchpost.mapper;

import cn.edu.bjut.entity.post.Post;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RecommandNewPost {
    @Select("SELECT * FROM post ORDER BY delivery_deadline")
    List<Post> getRecommandPostsNew();

}
