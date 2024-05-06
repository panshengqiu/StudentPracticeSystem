package cn.edu.bjut.entity.hr;

import cn.edu.bjut.entity.student.other.Student;
import cn.edu.bjut.entity.student.other.Submit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Data   // 自动生成toString(),equals(),hashCode(),setter(),getter()
@NoArgsConstructor  // 无参构造
@AllArgsConstructor  // 有参数构造方法
@Component
public class ResumeApproval {
    private Integer id;
    private Submit submit;
    private Student student;
    private LocalDateTime approvalTime;
    private ResumeApprovalStage resumeApprovalStage;

    private Integer hrId;

    private HumanResource humanResource;

    private LocalDateTime updateTime;
    private HumanResource humanResource;
}
