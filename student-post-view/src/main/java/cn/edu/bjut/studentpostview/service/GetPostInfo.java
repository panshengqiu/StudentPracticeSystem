package cn.edu.bjut.studentpostview.service;

import cn.edu.bjut.entity.post.Post;
import cn.edu.bjut.entity.post.PostAndEnterprise;

import java.util.List;

public interface GetPostInfo {
    List<PostAndEnterprise> getPostInfoByName(String name);

}
