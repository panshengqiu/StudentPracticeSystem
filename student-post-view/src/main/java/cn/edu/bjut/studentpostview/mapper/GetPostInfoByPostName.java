package cn.edu.bjut.studentpostview.mapper;

import cn.edu.bjut.entity.post.Post;
import cn.edu.bjut.entity.post.PostAndEnterprise;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GetPostInfoByPostName {
    @Select("SELECT p.*, e.name as enterprise_name,e.address,e.description as enterprise_description,e.logo_url FROM post p JOIN enterprise e JOIN practice.human_resource hr ON p.hr_id = hr.id AND hr.firm_id=e.id WHERE p.id=#{name};")
    List<PostAndEnterprise> getPostByPostName(String name);

}
