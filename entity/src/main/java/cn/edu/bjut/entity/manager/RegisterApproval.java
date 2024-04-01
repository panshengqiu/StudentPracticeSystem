package cn.edu.bjut.entity.manager;

import cn.edu.bjut.entity.enterprise.Enterprise;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data   // 自动生成toString(),equals(),hashCode(),setter(),getter()
@NoArgsConstructor  // 无参构造
@AllArgsConstructor  // 有参数构造方法
public class RegisterApproval {
    private Integer id;
    private Manager manager;
    private Enterprise enterprise;
    private LocalDateTime approvalTime;
    private String status;
}
