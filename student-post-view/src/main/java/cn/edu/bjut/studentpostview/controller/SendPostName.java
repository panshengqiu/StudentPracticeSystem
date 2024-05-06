package cn.edu.bjut.studentpostview.controller;

import cn.edu.bjut.entity.post.Post;
import cn.edu.bjut.entity.post.PostAndEnterprise;
import cn.edu.bjut.entity.post.PostName;
import cn.edu.bjut.studentpostview.mapper.GetPostInfoByPostName;
import cn.edu.bjut.studentpostview.service.GetPostInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class SendPostName {
    @Autowired
    private GetPostInfo getPostInfo;
    @PostMapping("/sendPostName")
    public List<PostAndEnterprise> getPostFilter(@RequestBody PostName postName){
        return getPostInfo.getPostInfoByName(postName.getPostName());
    }

}
