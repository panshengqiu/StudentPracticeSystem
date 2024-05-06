package cn.edu.bjut.hrpostmanagement.service;

import cn.edu.bjut.entity.hr.HumanResource;
import cn.edu.bjut.entity.post.Post;

import java.util.List;
import java.util.Map;

public interface PostComplexService {
    List<Map<Object,Object>> selectPosts(List<String> postTypes, List<String> workCities, String status, HumanResource humanResource);
}
