package cn.edu.bjut.hrregister.controller;


import cn.edu.bjut.entity.hr.HumanResource;
import cn.edu.bjut.hrregister.service.HrRegisterService;
import cn.edu.bjut.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class HrRegisterController {

    @Autowired
    private HrRegisterService hrRegisterService;

    @PostMapping("/hrRegister")
    @Transactional
    public Result register(@RequestBody HumanResource humanResource){
        System.out.println("企业名称：" + humanResource.getEnterprise().getName());
        System.out.println("企业社会信用代码：" + humanResource.getEnterprise().getCreditCode());
        System.out.println("用户名：" + humanResource.getUsername());
        System.out.println("密码：" + humanResource.getPassword());
        String registerStatus = hrRegisterService.isFirmRegister(humanResource.getEnterprise().getName(), humanResource.getEnterprise().getCreditCode());
        System.out.println("registerStatus:"+ registerStatus);
        if(registerStatus == null){
            System.out.println("企业未注册");
            return Result.error("企业未注册，请您先注册企业！");
        }
        if(registerStatus.equals("待审核")){
            return Result.error("您的企业正在等待审核中，请等审核通过后再验证");
        }
        String approvalStatus = hrRegisterService.isFirmApproval(humanResource.getEnterprise().getName(), humanResource.getEnterprise().getCreditCode());
        System.out.println("approvalStatus:"+ approvalStatus);
        if(approvalStatus != null){
            if(approvalStatus.equals("未通过")) {
                return Result.error("企业合法身份认证失败，请联系您的公司或重新申请入驻！");
            }
        }else {
            return Result.error("您的企业正在等待审核中，请等审核通过后再验证");
        }
        int enterpriseId = hrRegisterService.getEnterpriseId(humanResource.getEnterprise().getName(), humanResource.getEnterprise().getCreditCode());
        humanResource.getEnterprise().setId(enterpriseId);
        int insertNum = hrRegisterService.register(humanResource);
        if(insertNum > 0 ){
            return Result.success("恭喜您，注册成功，请前往登入界面！");
        }
        return Result.error("注册失败，请联系系统管理员！");
    }

    @GetMapping("/checkHrUsername")
    public Result checkHrUsername(@RequestParam("username") String username){

        boolean available = hrRegisterService.checkHrUsername(username);
        System.out.println("available:"+available);
        return Result.result(available);
    }
}
