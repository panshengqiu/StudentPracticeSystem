package cn.edu.bjut.entity.hr;

import cn.edu.bjut.entity.student.other.Student;
import cn.edu.bjut.entity.student.other.Submit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data   // 自动生成toString(),equals(),hashCode(),setter(),getter()
@NoArgsConstructor  // 无参构造
@AllArgsConstructor  // 有参数构造方法
public class ResumeApproval {
    private Integer id;
    private Submit submit;
    private Student student;
    private LocalDateTime approvalTime;
    private String approvalStage;
    private Integer hrId;
    private LocalDateTime updateTime;
}
