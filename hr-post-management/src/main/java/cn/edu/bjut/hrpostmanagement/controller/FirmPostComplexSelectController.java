package cn.edu.bjut.hrpostmanagement.controller;

import cn.edu.bjut.entity.hr.HumanResource;
import cn.edu.bjut.hrpostmanagement.service.PostComplexService;
import cn.edu.bjut.hrpostmanagement.service.impl.FirmPostsComplexSelectImpl;
import cn.edu.bjut.jwt.JWTUtils;
import cn.edu.bjut.result.Result;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.message.ReusableMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class FirmPostComplexSelectController {
    private PostComplexService postComplexService;

    @Autowired
    private HumanResource humanResource;

    @Autowired
    public FirmPostComplexSelectController(@Qualifier("enterprisePostsComplexSelect")PostComplexService postComplexService ){
        this.postComplexService = postComplexService;
    }



    @PostMapping("/selectEnterprisePostsMultiple")
    public Result getEnterprisePosts(@RequestBody TempRequestBody tempRequestBody, HttpServletRequest request){
        List<String> workCities = tempRequestBody.getWorkCities();
        List<String> postTypes = tempRequestBody.getPostTypes();
        String status = tempRequestBody.getStatus();
        String jwt = request.getHeader("Authorization");
        Claims claims = JWTUtils.parseJWT(jwt);
        int hr_id = (int)claims.get("id");
        humanResource.setId(hr_id);
        List<Map<Object, Object>> posts = postComplexService.selectPosts(postTypes, workCities, status, humanResource);
        if(!posts.isEmpty()){
            return Result.success(posts);
        }
        return Result.error("Get firm posts error!");
    }
}
