package cn.edu.bjut.studentsearchpost.mapper;

import cn.edu.bjut.entity.post.Post;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PostByInput {
    @Select("SELECT p.*, e.name as enterprise_name\n" +
            "FROM post p\n" +
            "JOIN enterprise e JOIN practice.human_resource hr ON p.hr_id = hr.id AND hr.firm_id=e.id\n" +
            "WHERE p.name LIKE CONCAT('%', #{name}, '%');")
    List<Post> findByPostName(String postName);

}
