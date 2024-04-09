package cn.edu.bjut.hrpostmanagement.service;

import cn.edu.bjut.entity.hr.HumanResource;
import cn.edu.bjut.entity.post.Post;
import cn.edu.bjut.entity.post.PostSmallType;

import java.util.List;
import java.util.Map;

public interface PostManagementService {
    public  List<Map<Object, Object>> selectPostInfo(HumanResource humanResource);

    public Integer selectSmallPostIdOnName(PostSmallType postSmallType);

    public List<String> selectAllSmallTypeName();

    public Integer insertPost(Post post);
}
