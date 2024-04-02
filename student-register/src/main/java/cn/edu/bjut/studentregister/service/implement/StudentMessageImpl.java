package cn.edu.bjut.studentregister.service.implement;

import cn.edu.bjut.entity.student.other.Student;
import cn.edu.bjut.studentregister.service.StudentMessageService;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import org.springframework.stereotype.Component;

import java.rmi.ServerException;
import java.util.Random;
@Component
public class StudentMessageImpl implements StudentMessageService {
    private static final String ACCESS_KEY_ID = "LTAI5tDsWMLbqBZh73LFzkvz";
    private static final String ACCESS_KEY_SECRET = "SGR7TDBMz32qeABsG1gSagXik0IAkp";
    private static final String SIGN_NAME = "大学生实习招聘平台"; // 短信签名
    private static final String TEMPLATE_CODE = "SMS_465349163"; // 短信模板代码

    @Override
    public String sendCode(String phoneNumber) {
        // 生成验证码
        String code = generateCode();

        // 发送短信
        try {
            sendSms(phoneNumber, code);
            return code; // 返回生成的验证码
        } catch (ClientException e) {
            e.printStackTrace();
            return null; // 发送失败返回null
        }

    }

    @Override
    public boolean verifyCode(String phone, String code) {
        return false;
    }

    private String generateCode() {
        Random random = new Random();
        int code = 100000 + random.nextInt(900000);
        return String.valueOf(code);
    }

    // 发送短信
    private void sendSms(String phoneNumber, String code) throws ClientException {
        // 设置访问密钥
        IClientProfile profile = DefaultProfile.getProfile("cn-beijing", ACCESS_KEY_ID, ACCESS_KEY_SECRET);
        DefaultAcsClient client = new DefaultAcsClient(profile);

        // 创建请求对象
        SendSmsRequest request = new SendSmsRequest();
        request.setPhoneNumbers(phoneNumber); // 设置接收短信的手机号码
        request.setSignName(SIGN_NAME); // 设置短信签名
        request.setTemplateCode(TEMPLATE_CODE); // 设置短信模板代码
        request.setTemplateParam("{\"code\":\"" + code + "\"}"); // 设置短信模板参数，这里是验证码

        // 发送短信
        try {
            SendSmsResponse response = client.getAcsResponse(request);
            System.out.println("短信发送结果：" + response.getCode());
        } catch (ClientException e) {
            e.printStackTrace();
            System.out.println("短信发送失败，错误信息：" + e.getErrMsg()); // 打印错误信息
        }
    }
}
