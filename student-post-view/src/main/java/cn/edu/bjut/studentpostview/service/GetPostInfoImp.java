package cn.edu.bjut.studentpostview.service;

import cn.edu.bjut.entity.post.Post;
import cn.edu.bjut.entity.post.PostAndEnterprise;
import cn.edu.bjut.studentpostview.mapper.GetPostInfoByPostName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GetPostInfoImp implements GetPostInfo{
    @Autowired
    GetPostInfoByPostName getPostInfoByPostName;
    public List<PostAndEnterprise> getPostInfoByName(String name) {
        return getPostInfoByPostName.getPostByPostName(name);
    }
}
