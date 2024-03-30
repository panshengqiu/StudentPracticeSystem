package cn.edu.bjut.enterpriseregister.controller;

import cn.edu.bjut.enterpriseregister.service.EnterpriseRegisterService;
import cn.edu.bjut.entity.enterprise.Enterprise;
import cn.edu.bjut.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnterpriseRegisterController {

    @Autowired
    private EnterpriseRegisterService ers;

    @PostMapping("/enterpriseRegister")
    public Result insert(@RequestBody Enterprise enterprise){
        int isInsert = ers.register(enterprise);
        if(isInsert > 0){
            return Result.success("提交成功，待管理员审核您的企业合法身份后，我们将会以短信的形式通知您！");
        }
        else
            return Result.error("提交失败，请联系系统管理员");
    }
}
