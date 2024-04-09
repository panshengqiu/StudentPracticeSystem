package cn.edu.bjut.hrpostmanagement.controller;


import cn.edu.bjut.entity.hr.HumanResource;
import cn.edu.bjut.entity.post.Post;
import cn.edu.bjut.entity.post.PostSmallType;
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

    @PostMapping("/getPostSmallType")
    public Result getPostSmallType(){
        List<String> smallTypeNames = postManagementService.selectAllSmallTypeName();
        return Result.success(smallTypeNames);
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


}
