package cn.edu.bjut.studentsearchpost.controller;

import cn.edu.bjut.entity.post.Post;
import cn.edu.bjut.entity.post.PostAndEnterprise;
import cn.edu.bjut.entity.post.PostFilter;
import cn.edu.bjut.studentsearchpost.mapper.FilterPost;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@Slf4j
@RestController
public class StudentFilterTimePost {
    @Autowired
    private FilterPost filterPost;

    @PostMapping("/sendFilterTime")
    public List<PostAndEnterprise> getPostFilter(@RequestBody PostFilter postFilter) {
        List<PostAndEnterprise> posts = null;
        if (!Objects.equals(postFilter.getRegion(), "") &&Objects.equals(postFilter.getMonth(), "")&& Objects.equals(postFilter.getSalary(), "")){
            //岗位信息-只有地域条件时
            posts = filterPost.getPostByRegionTime(postFilter.getRegion(), postFilter.getSmallType());
        }
        if (!Objects.equals(postFilter.getMonth(), "") &&Objects.equals(postFilter.getRegion(), "")&& Objects.equals(postFilter.getSalary(), "")){
            //岗位信息-只有月份条件时
            posts=filterPost.getPostByFilterMonthTime(postFilter.getMonth(),postFilter.getSmallType());
        }
        if (!Objects.equals(postFilter.getSalary(), "") &&Objects.equals(postFilter.getRegion(), "") && Objects.equals(postFilter.getMonth(), "")){
            //岗位信息-只有薪资条件时
            posts=filterPost.getPostByFilterSalaryTime(postFilter.getSalary(),postFilter.getSmallType());
        }
        if (!Objects.equals(postFilter.getRegion(), "") &&!Objects.equals(postFilter.getMonth(), "")&& Objects.equals(postFilter.getSalary(), "")){
            //岗位信息-地域+月份
            posts=filterPost.getPostByFilterRegionMonthTime(postFilter.getSmallType(),postFilter.getRegion(),postFilter.getMonth());
        }
        if (!Objects.equals(postFilter.getRegion(), "") &&Objects.equals(postFilter.getMonth(), "")&&!Objects.equals(postFilter.getSalary(), "")){
            //岗位信息-地域+薪资
            posts=filterPost.getPostByFilterRegionSalaryTime(postFilter.getSmallType(),postFilter.getRegion(),postFilter.getSalary());
        }
        if(!Objects.equals(postFilter.getMonth(), "")&& !Objects.equals(postFilter.getSalary(), "")&& Objects.equals(postFilter.getRegion(), "")){
            //岗位信息-月份+薪资
            posts=filterPost.getPostByFilterMonthSalaryTime(postFilter.getSmallType(),postFilter.getMonth(),postFilter.getSalary());
        }
        if(!Objects.equals(postFilter.getMonth(), "")&& !Objects.equals(postFilter.getSalary(), "")&& !Objects.equals(postFilter.getRegion(), "")){
            //筛选条件全选
            posts=filterPost.getPostByFilterAllTime(postFilter.getSmallType(),postFilter.getRegion(),postFilter.getMonth(),postFilter.getSalary());
        }
        if(Objects.equals(postFilter.getMonth(), "")&& Objects.equals(postFilter.getSalary(), "")&& Objects.equals(postFilter.getRegion(), "")){
            //不筛选
            posts=filterPost.getPostInfoTime(postFilter.getSmallType());
        }

        return posts;

    }
}
