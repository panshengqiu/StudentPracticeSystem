package cn.edu.bjut.studentsubmitresume.controller;

import cn.edu.bjut.entity.enterprise.Enterprise;
import cn.edu.bjut.entity.enterprise.EnterpriseInfo;
import cn.edu.bjut.entity.post.Post;
import cn.edu.bjut.entity.post.PostAndEnterprise;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class SelectEnterpriseAllGetInfo {
    @Autowired
    private cn.edu.bjut.studentsubmitresume.mapper.SelectEnterpriseAll selectEnterpriseAll;
    List<Enterprise> enterprises;
    @PostMapping("/sendEnterpriseNameGetInfo")
    public List<Enterprise> enterpriseInfo(@RequestBody EnterpriseInfo enterprise){
        enterprises=selectEnterpriseAll.selectEnterpriseAllInfo(enterprise.getEnterpriseName());
        return enterprises;
    }
    List<PostAndEnterprise> postInfo;
    @PostMapping("sendEnterpriseNameGetAllPost")
    public List<PostAndEnterprise> postInfo(@RequestBody EnterpriseInfo enterpriseInfo){
        postInfo=selectEnterpriseAll.selectEnterpriseAllPostInfo(enterpriseInfo.getEnterpriseName());
        return postInfo;
    }

}
