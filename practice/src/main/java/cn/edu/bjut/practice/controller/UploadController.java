package cn.edu.bjut.practice.controller;

import cn.edu.bjut.oss.AliOSSUtils;
import cn.edu.bjut.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;


@RestController
@Slf4j
public class UploadController {
    @Autowired
    private AliOSSUtils aliOSSUtils;
    @PostMapping("/upload")
    public Result upload(MultipartFile file) throws IOException {
        log.info("文件上传， 文件名称：{}", file.getOriginalFilename());
        System.out.println("文件上传， 文件名称：" + file.getOriginalFilename());
        String url = aliOSSUtils.upload(file);
        log.info("文件上传成功，文件的名称为{}", url);
        System.out.println("文件上传成功，文件的名称为" + url);
        return Result.success(url);
    }


}
