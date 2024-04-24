package cn.edu.bjut.studentsearchpost.mapper;

import cn.edu.bjut.entity.post.Post;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

//再联合查询出企业信息+岗位信息
@Mapper
public interface StudentPostInfo {
    @Select("SELECT p.*, e.name as enterprise_name\n" +
            "FROM post p\n" +
            "JOIN enterprise e ON p.hr_id = e.id\n" +
            "WHERE p.small_post_id = #{id}\n" +
            "ORDER BY p.delivery_deadline;\n")
    List<Post> getAllPostsSortedByDeliveryDeadline(@Param("id") String id);
}
