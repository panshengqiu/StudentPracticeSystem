package cn.edu.bjut.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data   // 自动生成toString(),equals(),hashCode(),setter(),getter()
@NoArgsConstructor  // 无参构造
@AllArgsConstructor  // 有参数构造方法
public class PostRecordReturn {
    private String PostName;
    private String workCity;
    private LocalDate approvalTime;
    private String enterpriseName;
    private String status;
    private String stageName;
}
