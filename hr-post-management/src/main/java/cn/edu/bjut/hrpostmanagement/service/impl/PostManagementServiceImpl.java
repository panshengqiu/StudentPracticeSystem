package cn.edu.bjut.hrpostmanagement.service.impl;

import cn.edu.bjut.entity.hr.HumanResource;
import cn.edu.bjut.entity.post.Post;
import cn.edu.bjut.entity.post.PostSmallType;
import cn.edu.bjut.hrpostmanagement.mapper.PostManagementMapper;
import cn.edu.bjut.hrpostmanagement.service.PostManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class PostManagementServiceImpl implements PostManagementService {

    @Autowired
    private PostManagementMapper postManagementMapper;
    @Override
    public  List<Map<Object, Object>> selectPostInfo(HumanResource humanResource) {
        List<Map<Object, Object>> posts = postManagementMapper.selectPostsInfo(humanResource);
        return posts;
    }

    @Override
    public List<Map<Object, Object>> selectFirmPosts(HumanResource humanResource) {
        return postManagementMapper.selectFirmPosts(humanResource);
    }

    @Override
    public Integer selectSmallPostIdOnName(PostSmallType postSmallType) {
        return postManagementMapper.selectSmallPostIdOnName(postSmallType);
    }

    @Override
    public Set<String> selectAllSmallTypeName() {
        return postManagementMapper.selectAllSmallTypeName();
    }

    @Override
    public Set<String> selectPostsWorkCities() {
        return postManagementMapper.selectPostsWorkCities();
    }

    @Override
    public Integer insertPost(Post post) {
        Integer smallPostId = this.selectSmallPostIdOnName(post.getPostSmallType());
        post.getPostSmallType().setId(smallPostId);
        return postManagementMapper.insertPost(post);
    }

    @Override
    public List<Map<Object, Object>> getPostInfo(Post post) {
        return postManagementMapper.selectPostInfoOnId(post);
    }

    @Override
    public Integer updatePostInfo(Post post) {
        return postManagementMapper.updatePostInfo(post);
    }

    @Override
    public List<Map<Object, Object>> queryPostCondition(Post post) {
        return postManagementMapper.selectPostsInfoConditionally(post);
    }
}
