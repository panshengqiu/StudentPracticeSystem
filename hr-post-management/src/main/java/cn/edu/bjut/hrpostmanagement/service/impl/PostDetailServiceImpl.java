package cn.edu.bjut.hrpostmanagement.service.impl;

import cn.edu.bjut.entity.hr.HumanResource;
import cn.edu.bjut.entity.post.Post;
import cn.edu.bjut.hrpostmanagement.mapper.PostComplexSelectMapper;
import cn.edu.bjut.hrpostmanagement.service.PostComplexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Qualifier("postDetailServiceImpl")
public class PostDetailServiceImpl implements PostComplexService {
    @Autowired
    private PostComplexSelectMapper postComplexSelectMapper;
    @Override
    public List<Map<Object, Object>> selectPosts(List<String> postTypes, List<String> workCities, String status, HumanResource humanResource) {
        return null;
    }

    public List<Map<Object, Object>> selectPostDetail(Post post){
        return postComplexSelectMapper.selectPostDetail(post);
    }
}
