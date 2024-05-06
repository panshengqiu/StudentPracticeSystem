package cn.edu.bjut.entity.hr;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class ResumeApprovalStage {
    private Integer id;
    private String stageName; // 阶段名称：初筛，笔试，面试，录取
    private String status; // 阶段状态： 通过，未通过，审核中
}
