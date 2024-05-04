package cn.edu.bjut.studentsubmitresume.mapper;

import cn.edu.bjut.entity.enterprise.Enterprise;
import cn.edu.bjut.entity.post.Post;
import cn.edu.bjut.entity.post.PostAndEnterprise;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SelectEnterpriseAll {
    @Select("SELECT * FROM enterprise WHERE name=#{enterpriseName}")
    List<Enterprise> selectEnterpriseAllInfo(String enterpriseName);

    @Select("SELECT p.*,e.logo_url, e.name as enterprise_name FROM post p JOIN enterprise e JOIN practice.human_resource hr ON p.hr_id = hr.id AND hr.firm_id=e.id WHERE e.id=(SELECT id FROM enterprise WHERE name=#{enterpriseName});")
    List<PostAndEnterprise> selectEnterpriseAllPostInfo(String enterpriseName);
}
