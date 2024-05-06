package cn.edu.bjut.hrpostmanagement.controller;


import cn.edu.bjut.entity.hr.HumanResource;
import cn.edu.bjut.entity.post.Post;
import cn.edu.bjut.hrpostmanagement.service.PostComplexService;
import cn.edu.bjut.hrpostmanagement.service.impl.PostDetailServiceImpl;
import cn.edu.bjut.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class PostDetailController {
    private PostComplexService postComplexService;

    @Autowired
    public PostDetailController(@Qualifier("postDetailServiceImpl")PostComplexService postComplexService ){
        this.postComplexService = postComplexService;
    }

    @PostMapping("/getPostDetailInformation")
    public Result getPostDetailInformation(@RequestBody Post post){
        PostDetailServiceImpl postDetailService = (PostDetailServiceImpl) postComplexService;
        List<Map<Object, Object>> postDetail = postDetailService.selectPostDetail(post);
        if(!postDetail.isEmpty()){
           return Result.success(postDetail);
        }
        return Result.error("Get post detail error!");
    }
}
