package cn.edu.bjut.studentsearchpost.controller;

import cn.edu.bjut.entity.post.Post;
import cn.edu.bjut.entity.post.PostAndEnterprise;
import cn.edu.bjut.entity.post.PostMainFilter;
import cn.edu.bjut.studentsearchpost.mapper.MainFilterPost;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@Slf4j
@RestController
public class StudentMainfilter {
    @Autowired
    private MainFilterPost mainFilterPost;
    @PostMapping("/sendMainFilter")
    public List<PostAndEnterprise> getPostFilter(@RequestBody PostMainFilter postFilter){
        List<PostAndEnterprise> posts = null;
        if (!Objects.equals(postFilter.getRegion(), "") &&Objects.equals(postFilter.getMonth(), "")&& Objects.equals(postFilter.getSalary(), "")){
            //岗位信息-只有地域条件时
            posts = mainFilterPost.getPostByRegion(postFilter.getRegion(), postFilter.getInput());
        }
        if (!Objects.equals(postFilter.getMonth(), "") &&Objects.equals(postFilter.getRegion(), "")&& Objects.equals(postFilter.getSalary(), "")){
            //岗位信息-只有月份条件时
            posts=mainFilterPost.getPostByFilterMonth(postFilter.getMonth(),postFilter.getInput());
        }
        if (!Objects.equals(postFilter.getSalary(), "") &&Objects.equals(postFilter.getRegion(), "") && Objects.equals(postFilter.getMonth(), "")){
            //岗位信息-只有薪资条件时
            posts=mainFilterPost.getPostByFilterSalary(postFilter.getSalary(),postFilter.getInput());
        }
        if (!Objects.equals(postFilter.getRegion(), "") &&!Objects.equals(postFilter.getMonth(), "")&& Objects.equals(postFilter.getSalary(), "")){
            //岗位信息-地域+月份
            posts=mainFilterPost.getPostByFilterRegionMonth(postFilter.getInput(),postFilter.getRegion(),postFilter.getMonth());
        }
        if (!Objects.equals(postFilter.getRegion(), "") &&Objects.equals(postFilter.getMonth(), "")&&!Objects.equals(postFilter.getSalary(), "")){
            //岗位信息-地域+薪资
            posts=mainFilterPost.getPostByFilterRegionSalary(postFilter.getInput(),postFilter.getRegion(),postFilter.getSalary());
        }
        if(!Objects.equals(postFilter.getMonth(), "")&& !Objects.equals(postFilter.getSalary(), "")&& Objects.equals(postFilter.getRegion(), "")){
            //岗位信息-月份+薪资
            posts=mainFilterPost.getPostByFilterMonthSalary(postFilter.getInput(),postFilter.getMonth(),postFilter.getSalary());
        }
        if(!Objects.equals(postFilter.getMonth(), "")&& !Objects.equals(postFilter.getSalary(), "")&& !Objects.equals(postFilter.getRegion(), "")){
            //筛选条件全选
            posts=mainFilterPost.getPostByFilterAll(postFilter.getInput(),postFilter.getRegion(),postFilter.getMonth(),postFilter.getSalary());
        }
        if(Objects.equals(postFilter.getMonth(), "")&& Objects.equals(postFilter.getSalary(), "")&& Objects.equals(postFilter.getRegion(), "")){
            //不筛选
            posts=mainFilterPost.getPostInfo(postFilter.getInput());
        }
        return posts;
    }

    @PostMapping("/sendMainFilterTime")
    public List<PostAndEnterprise> getPostFilterTime(@RequestBody PostMainFilter postFilter){
        List<PostAndEnterprise> posts = null;
        if (!Objects.equals(postFilter.getRegion(), "") &&Objects.equals(postFilter.getMonth(), "")&& Objects.equals(postFilter.getSalary(), "")){
            //岗位信息-只有地域条件时
            posts = mainFilterPost.getPostByRegionTime(postFilter.getRegion(), postFilter.getInput());
        }
        if (!Objects.equals(postFilter.getMonth(), "") &&Objects.equals(postFilter.getRegion(), "")&& Objects.equals(postFilter.getSalary(), "")){
            //岗位信息-只有月份条件时
            posts=mainFilterPost.getPostByFilterMonthTime(postFilter.getMonth(),postFilter.getInput());
        }
        if (!Objects.equals(postFilter.getSalary(), "") &&Objects.equals(postFilter.getRegion(), "") && Objects.equals(postFilter.getMonth(), "")){
            //岗位信息-只有薪资条件时
            posts=mainFilterPost.getPostByFilterSalaryTime(postFilter.getSalary(),postFilter.getInput());
        }
        if (!Objects.equals(postFilter.getRegion(), "") &&!Objects.equals(postFilter.getMonth(), "")&& Objects.equals(postFilter.getSalary(), "")){
            //岗位信息-地域+月份
            posts=mainFilterPost.getPostByFilterRegionMonthTime(postFilter.getInput(),postFilter.getRegion(),postFilter.getMonth());
        }
        if (!Objects.equals(postFilter.getRegion(), "") &&Objects.equals(postFilter.getMonth(), "")&&!Objects.equals(postFilter.getSalary(), "")){
            //岗位信息-地域+薪资
            posts=mainFilterPost.getPostByFilterRegionSalaryTime(postFilter.getInput(),postFilter.getRegion(),postFilter.getSalary());
        }
        if(!Objects.equals(postFilter.getMonth(), "")&& !Objects.equals(postFilter.getSalary(), "")&& Objects.equals(postFilter.getRegion(), "")){
            //岗位信息-月份+薪资
            posts=mainFilterPost.getPostByFilterMonthSalaryTime(postFilter.getInput(),postFilter.getMonth(),postFilter.getSalary());
        }
        if(!Objects.equals(postFilter.getMonth(), "")&& !Objects.equals(postFilter.getSalary(), "")&& !Objects.equals(postFilter.getRegion(), "")){
            //筛选条件全选
            posts=mainFilterPost.getPostByFilterAllTime(postFilter.getInput(),postFilter.getRegion(),postFilter.getMonth(),postFilter.getSalary());
        }
        if(Objects.equals(postFilter.getMonth(), "")&& Objects.equals(postFilter.getSalary(), "")&& Objects.equals(postFilter.getRegion(), "")){
            //不筛选
            posts=mainFilterPost.getPostInfoTime(postFilter.getInput());
        }

        return posts;
    }
}
