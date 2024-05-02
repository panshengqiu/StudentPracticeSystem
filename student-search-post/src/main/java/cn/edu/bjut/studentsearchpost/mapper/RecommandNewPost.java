package cn.edu.bjut.studentsearchpost.mapper;

import cn.edu.bjut.entity.post.Post;
import cn.edu.bjut.entity.post.PostAndEnterprise;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RecommandNewPost {
    @Select("SELECT p.*, e.logo_url,e.name  as enterprise_name FROM post p JOIN enterprise e JOIN practice.human_resource hr ON p.hr_id = hr.id AND hr.firm_id=e.id ORDER BY delivery_deadline")
    List<PostAndEnterprise> getRecommandPostsNew();

    @Select("SELECT COUNT(*) FROM intended_post WHERE stu_id = #{stuId} AND small_post_id IS NOT NULL")
    int countIntendedPostsByStuId(int stuId);

    @Select("SELECT p.*, e.logo_url, e.name AS enterprise_name " +
            "FROM post p JOIN enterprise e JOIN practice.human_resource hr ON p.hr_id = hr.id AND hr.firm_id=e.id  " +
            "LEFT JOIN intended_post ip ON p.small_post_id = ip.small_post_id AND ip.stu_id = #{stuId} " +
            "ORDER BY CASE WHEN ip.small_post_id IS NULL THEN 1 ELSE 0 END , p.delivery_deadline")
    List<PostAndEnterprise> getRecommandSpecificPostsNew(int stuId);

    @Select("SELECT p.*, e.logo_url, e.name AS enterprise_name\n" +
            "FROM post p JOIN enterprise e JOIN practice.human_resource hr ON p.hr_id = hr.id AND hr.firm_id=e.id  " +
            "LEFT JOIN intended_post ip ON p.small_post_id = ip.small_post_id AND ip.stu_id = #{stuId}\n" +
            "LEFT JOIN submit s ON s.post_id = p.id AND s.stu_id = #{stuId}\n" +
            "GROUP BY p.id, e.logo_url, e.name\n" +
            "ORDER BY \n" +
            "    CASE WHEN ip.small_post_id IS NOT NULL THEN 1 ELSE 0 END DESC,\n" +
            "    COUNT(s.post_id) DESC;")
    List<PostAndEnterprise> getRecommandSpecificPostsPopular(int stuId);

    @Select("SELECT p.*, e.logo_url, e.name AS enterprise_name\n" +
            "FROM post p JOIN enterprise e JOIN practice.human_resource hr ON p.hr_id = hr.id AND hr.firm_id=e.id  " +
            "LEFT JOIN submit s ON s.post_id = p.id\n" +
            "GROUP BY p.id, e.logo_url, e.name\n" +
            "ORDER BY \n" +
            "    COUNT(s.post_id) DESC;")
    List<PostAndEnterprise> getRecommandPostsPopular();


}
