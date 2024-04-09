package cn.edu.bjut.studentregister.controller;

import cn.edu.bjut.result.Result;
import cn.edu.bjut.studentregister.mapper.StudentVerifyCode;
import cn.edu.bjut.studentregister.service.StudentMessageService;
import cn.edu.bjut.studentregister.service.StudentRegisterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class StudentMessageController {
    @Autowired
    private StudentRegisterService studentRegister;
    @Autowired
    private StudentMessageService smsService; // 注入短信服务
    @Autowired
    private StudentVerifyCode studentVerifyCode;

    @PostMapping("/sendCode")
    public Result sendcode(@RequestBody PhoneNumberRequest phoneNumberRequest) {
        String phoneNumber = phoneNumberRequest.getPhoneNumber();
        System.out.println(phoneNumber);
        String code = smsService.sendCode(phoneNumber); // 发送验证码
        smsService.insertCode(phoneNumber,code);
        return Result.success("验证码已发送");
    }

    // 将前端请求体中数据解析成java 字符串
    public static class PhoneNumberRequest {
        private String phoneNumber;

        public String getPhoneNumber() {
            //return一下将phonenumber方便取出来
            return phoneNumber;
        }
    }

    @PostMapping("/studentRegisterView")
    public Result verifyCode(@RequestBody VerifyCodeRequest verifyCodeRequest) {

        // 从数据库中获取存储的验证码
        String storedCode = studentVerifyCode.getMaxCodeByPhone(verifyCodeRequest.getPhone());
        // 从前端获取用户输入的代码
        String inputCode = verifyCodeRequest.getCode();

        if (inputCode.equals(storedCode) && studentRegister.register(verifyCodeRequest.getName(),verifyCodeRequest.getUsername(),verifyCodeRequest.getPhone(),verifyCodeRequest.getSex(),verifyCodeRequest.getPassword())>0){
            return Result.success("注册成功");
        }
        if(!inputCode.equals(storedCode)){
            return Result.error("验证码错误");
        }
        else return Result.error("注册失败");

    }


    // 将前端请求体中数据解析成Java字符串
    public static class VerifyCodeRequest {
        private String phone;
        private String code;

        private String name;
        private String username;

        private String sex;
        private String password;

        public String getCode() {
            return code;
        }

        public String getPhone(){
            return phone;
        }

        public String getName(){
            return name;
        }

        public String getUsername(){
            return username;
        }

        public String getSex(){
            return sex;
        }

        public String getPassword(){
            return password;
        }
    }
}



