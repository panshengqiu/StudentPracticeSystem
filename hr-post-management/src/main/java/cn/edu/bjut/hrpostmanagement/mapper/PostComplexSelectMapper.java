package cn.edu.bjut.hrpostmanagement.mapper;

import cn.edu.bjut.entity.hr.HumanResource;
import cn.edu.bjut.entity.post.Post;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface PostComplexSelectMapper {
    List<Map<Object, Object>> selectDepartmentPosts(List<String> postTypes, List<String> workCities, String status, HumanResource humanResource);
    List<Map<Object, Object>> selectEnterprisePosts(List<String> postTypes, List<String> workCities, String status, HumanResource humanResource);
    List<Map<Object, Object>> selectPostDetail(Post post);
}
