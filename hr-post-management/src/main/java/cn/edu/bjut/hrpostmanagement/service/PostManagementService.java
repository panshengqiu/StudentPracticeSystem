package cn.edu.bjut.hrpostmanagement.service;

import cn.edu.bjut.entity.hr.HumanResource;
import cn.edu.bjut.entity.post.Post;
import cn.edu.bjut.entity.post.PostSmallType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface PostManagementService {
     List<Map<Object, Object>> selectPostInfo(HumanResource humanResource);
     List<Map<Object, Object>> selectFirmPosts(HumanResource humanResource);

    Integer selectSmallPostIdOnName(PostSmallType postSmallType);

    Set<String> selectAllSmallTypeName();
    Set<String> selectPostsWorkCities();

    Integer insertPost(Post post);

    List<Map<Object, Object>> getPostInfo(Post post);

    Integer updatePostInfo(Post post);

    List<Map<Object, Object>> queryPostCondition(Post post);

}
