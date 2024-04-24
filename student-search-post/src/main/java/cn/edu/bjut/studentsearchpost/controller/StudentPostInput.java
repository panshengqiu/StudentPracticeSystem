package cn.edu.bjut.studentsearchpost.controller;

import cn.edu.bjut.entity.post.Post;
import cn.edu.bjut.entity.post.StudentChildInput;
import cn.edu.bjut.entity.post.StudentChildTypeInput;
import cn.edu.bjut.entity.post.StudentInput;
import cn.edu.bjut.studentsearchpost.mapper.PostByInput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class StudentPostInput {
    @Autowired
    private PostByInput postByInput;
    @PostMapping("/sendInput")
    public List<Post> getInput(@RequestBody StudentInput studentInput){
        return postByInput.findByPostName(studentInput.getSearchValue());
    }

    @PostMapping("sendChildInput")
    public List<Post> getChildInput(@RequestBody StudentChildInput studentChildInput){
        return postByInput.findByPostName(studentChildInput.getSearchValue());
    }

    @PostMapping("sendChildTypeInput")
    public List<Post> getChildInput(@RequestBody StudentChildTypeInput studentChildTypeInput){
        return postByInput.findByPostName(studentChildTypeInput.getSearchValue());
    }

}
