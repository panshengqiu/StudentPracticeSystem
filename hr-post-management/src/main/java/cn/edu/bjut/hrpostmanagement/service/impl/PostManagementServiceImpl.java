package cn.edu.bjut.hrpostmanagement.service.impl;

import cn.edu.bjut.entity.hr.HumanResource;
import cn.edu.bjut.entity.post.Post;
import cn.edu.bjut.entity.post.PostSmallType;
import cn.edu.bjut.hrpostmanagement.mapper.PostManagementMapper;
import cn.edu.bjut.hrpostmanagement.service.PostManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PostManagementServiceImpl implements PostManagementService {

    @Autowired
    private PostManagementMapper postManagementMapper;
    @Override
    public  List<Map<Object, Object>> selectPostInfo(HumanResource humanResource) {
        List<Map<Object, Object>> posts = postManagementMapper.selectPostInfo(humanResource);
        return posts;
    }

    @Override
    public Integer selectSmallPostIdOnName(PostSmallType postSmallType) {
        return postManagementMapper.selectSmallPostIdOnName(postSmallType);
    }

    @Override
    public List<String> selectAllSmallTypeName() {
        return postManagementMapper.selectAllSmallTypeName();
    }

    @Override
    public Integer insertPost(Post post) {
        Integer smallPostId = this.selectSmallPostIdOnName(post.getPostSmallType());
        post.getPostSmallType().setId(smallPostId);
        return postManagementMapper.insertPost(post);
    }
}
