package cn.edu.bjut.entity.hr;

import cn.edu.bjut.entity.enterprise.Enterprise;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data   // 自动生成toString(),equals(),hashCode(),setter(),getter()
@NoArgsConstructor  // 无参构造
@AllArgsConstructor  // 有参数构造方法
@Component
public class HumanResource {
    private Integer id;
    private String department;
    private Enterprise enterprise;
    private String username;
    private String password;
    private String email;
    private String phone;
    private String headUrl;
}
