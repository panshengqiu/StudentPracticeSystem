package cn.edu.bjut.utils;

import com.aliyun.oss.OSSClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.aliyun.oss.OSS;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Component
public class AliOSSUtils {
    /*// https://oss-cn-beijing.aliyuncs.com
    @Value("${aliyun.oss.endpoint}")
    private String endpoint;

    // LTAI5tRcASVu4bL6uePxW65J
    @Value("${aliyun.oss.accessKeyId}")
    private String accessKeyId;

    @Value("${aliyun.oss.accessKeySecret}")
    // LugqfLSCWrd4wq9OSAtcOGcaByRYfm
    private String accessKeySecret;

    @Value("${aliyun.oss.bucketName}")
    // practice-springboot-web
    private String bucketName;*/

    @Autowired
    private AliOSSProperties aliOSSProperties;


    public String upload(MultipartFile file) throws IOException {
        //获取阿里云OSS参数
        String endpoint = aliOSSProperties.getEndpoint();
        String accessKeyId = aliOSSProperties.getAccessKeyId();
        String accessKeySecret = aliOSSProperties.getAccessKeySecret();
        String bucketName = aliOSSProperties.getBucketName();

        InputStream inputStream = file.getInputStream();

        String originalFileName = file.getOriginalFilename();
        String filename = UUID.randomUUID() + originalFileName.substring(originalFileName.lastIndexOf("."));

        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        ossClient.putObject(bucketName, filename, inputStream);

        String url = endpoint.split("//")[0] + "//" + bucketName + "." + endpoint.split("//")[1] + "/" + filename;
        ossClient.shutdown();
        return url;
    }

}


