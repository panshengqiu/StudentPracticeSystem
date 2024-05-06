package cn.edu.bjut.hrpostmanagement.controller;


import cn.edu.bjut.entity.hr.HumanResource;
import cn.edu.bjut.entity.post.Post;
import cn.edu.bjut.hrpostmanagement.service.PostManagementService;
import cn.edu.bjut.jwt.JWTUtils;
import cn.edu.bjut.result.Result;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@Slf4j
@CrossOrigin
public class PostManagementController {

    @Autowired
    private PostManagementService postManagementService;
    @Autowired
    private HumanResource humanResource;

    @RequestMapping("/selectPostData")
    public Result selectPostData(HttpServletRequest request){
        String jwt = request.getHeader("Authorization");
        Claims claims = JWTUtils.parseJWT(jwt);
        log.info("校验解析后的令牌：{}", claims);

        Integer hrId = (Integer) claims.get("id");
        humanResource.setId(hrId);
        List<Map<Object, Object>> posts = postManagementService.selectPostInfo(humanResource);
        return Result.success(posts);
    }

    @RequestMapping("/getEnterprisePosts")
    public Result getEnterprisePosts(HttpServletRequest request){
        String jwt = request.getHeader("Authorization");
        Claims claims = JWTUtils.parseJWT(jwt);
        log.info("校验解析后的令牌：{}", claims);

        Integer hrId = (Integer) claims.get("id");
        humanResource.setId(hrId);
        List<Map<Object, Object>> enterprisePosts = postManagementService.selectFirmPosts(humanResource);
        if(!enterprisePosts.isEmpty())
            return Result.success(enterprisePosts);
        return Result.error("enterprise have no enterprise posts");
    }

    @GetMapping("/getPostSmallType")
    public Result getPostSmallType(){
        Set<String> smallTypeNames = postManagementService.selectAllSmallTypeName();
        if(!smallTypeNames.isEmpty())
            return Result.success(smallTypeNames);
        return Result.error("No posts types!");
    }

    @GetMapping("/getPostWorkCities")
    public Result getPostWorkCities(){
        Set<String> workCities = postManagementService.selectPostsWorkCities();
        if(!workCities.isEmpty())
            return Result.success(workCities);
        return Result.error("No posts work cities!");
    }

    @PostMapping("/addPost")
    public Result addPost(@RequestBody Post post, HttpServletRequest request){

        String jwt = request.getHeader("Authorization");
        Claims claims = JWTUtils.parseJWT(jwt);
        log.info("校验解析后的令牌：{}", claims);
        Integer hrId = (Integer) claims.get("id");
        post.setHumanResource(this.humanResource);
        post.getHumanResource().setId(hrId);

        Integer updateNums = postManagementService.insertPost(post);
        if(updateNums>0)
            return Result.success("岗位发布成功！");
        return Result.error("岗位发布失败！");
    }

    // 获取一个需要更新的岗位信息
    @PostMapping("/getPostInfo")
    public Result getPostInfo(@RequestBody Post post, HttpServletRequest request){
        String jwt = request.getHeader("Authorization");
        Claims claims = JWTUtils.parseJWT(jwt);
        log.info("校验解析后的令牌：{}", claims);
        Integer hrId = (Integer) claims.get("id");
        post.setHumanResource(this.humanResource);
        post.getHumanResource().setId(hrId);
        List<Map<Object, Object>> post1 = postManagementService.getPostInfo(post);
        if(post1 != null)
            return Result.success(post1);
        return Result.error("Get Post information error!");
    }

    // 更新某个岗位信息
    @PostMapping("/updatePostInfo")
    public Result updatePostInfo(@RequestBody Post post, HttpServletRequest request){
        String jwt = request.getHeader("Authorization");
        Claims claims = JWTUtils.parseJWT(jwt);
        log.info("校验解析后的令牌：{}", claims);
        Integer hrId = (Integer) claims.get("id");
        post.setHumanResource(this.humanResource);
        post.getHumanResource().setId(hrId);
        Integer updateNum = postManagementService.updatePostInfo(post);
        if(updateNum > 0)
            return Result.success("update post information success!");
        return Result.error("Update post information error!");
    }

    // 条件查询岗位
    @PostMapping("searchPostConditionally")
    public Result queryPostOnCondition(@RequestBody Post post,HttpServletRequest request){
        String jwt = request.getHeader("Authorization");
        Claims claims = JWTUtils.parseJWT(jwt);
        log.info("校验解析后的令牌：{}", claims);
        Integer hrId = (Integer) claims.get("id");
        post.setHumanResource(this.humanResource);
        post.getHumanResource().setId(hrId);
        log.info("\ndeliveryDeadline: {}\n",post.getDeliveryDeadline());
        List<Map<Object, Object>> posts = postManagementService.queryPostCondition(post);
        if(posts.isEmpty())
            return Result.error("Posts not exist!!");
        return Result.success(posts);
    }

}
