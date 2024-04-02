package cn.edu.bjut.studentregister.controller;

import cn.edu.bjut.result.Result;
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


    @PostMapping("/sendCode")
    public Result sendcode(@RequestBody PhoneNumberRequest phoneNumberRequest) {
        String phoneNumber = phoneNumberRequest.getPhoneNumber();
        System.out.println(phoneNumber);
        String code = smsService.sendCode(phoneNumber); // 发送验证码
        return Result.success("验证码已发送");
    }

    // 将前端请求体中数据解析成java 字符串
    public static class PhoneNumberRequest {
        private String phoneNumber;

        public String getPhoneNumber() {
            //return一下将phonenumber方便取出来
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }
    }


//    @PostMapping("/studentRegisterView")
//    public Result resgister(@RequestBody Student student, @RequestBody String code){
//        if (!smsService.verifyCode(student.getPhone(), code)) { // 验证验证码
//            return Result.error("验证码错误");
//        }
//        if (studentRegister.register(student)>0){
//            return Result.success("成功注册");
//        }
//        else return Result.error("获取失败");
//    }
}



