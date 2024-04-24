package cn.edu.bjut.studentsearchpost.controller;

import cn.edu.bjut.entity.post.Post;
import cn.edu.bjut.entity.post.PostBigType;
import cn.edu.bjut.entity.post.PostSmallType;
import cn.edu.bjut.entity.post.PostSmallTypeWithBigTypeName;
import cn.edu.bjut.studentsearchpost.mapper.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class StudentPostTypeController {
    @Autowired
    private BigPostType bigPostType;

    @Autowired
    private SmallPostType smallPostType;

    @GetMapping("/bigPostTypes")
    public List<PostBigType> getAllBigPostTypes() {
        List<PostBigType> bigPostTypes = bigPostType.getAllBigPostTypes();
        log.info("All Big Post Types: {}", bigPostTypes);
        return bigPostTypes;
    }

    @GetMapping("/smallPostTypes")
    public List<PostSmallTypeWithBigTypeName> getAllSmallPostTypes() {
        List<PostSmallTypeWithBigTypeName> smallPostTypes = smallPostType.getAllSmallPostTypesWithBigTypeName();
        log.info("All Small Post Types: {}", smallPostTypes);
        return smallPostTypes;
    }

    //最新按照小类搜索的岗位信息发送到搜索界面
    @Autowired
    private StudentPostInfo studentPostInfoMapper;
    @Autowired
    private SelectSmallTypeId selectSmallTypeId;
    public String smallTypeInputID;

    @PostMapping("/sendSmall")
    public void getInputSmallType(@RequestBody PostSmallType postSmallType) {
        String smallType = postSmallType.getName();
        System.out.println(smallType);
        smallTypeInputID= String.valueOf(selectSmallTypeId.selectSmallTypeIdByName(smallType));
    }


    @GetMapping("/posts")
    public List<Post> getAllPostsSortedByDeliveryDeadline() {
        List<Post> posts = studentPostInfoMapper.getAllPostsSortedByDeliveryDeadline(String.valueOf(smallTypeInputID));
        log.info("All Posts Sorted By Delivery Deadline: {}", posts);
        return posts;
    }
    @Autowired
    private RecommandNewPost recommandNewPost;
    @GetMapping("/recommandNew")
    public List<Post> getRecommandPostsNew() {
        List<Post> posts=recommandNewPost.getRecommandPostsNew();
        return posts;
    }

}
