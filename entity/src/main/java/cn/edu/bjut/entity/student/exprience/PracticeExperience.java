package cn.edu.bjut.entity.student.exprience;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data   // 自动生成toString(),equals(),hashCode(),setter(),getter()
@NoArgsConstructor  // 无参构造
@AllArgsConstructor  // 有参数构造方法
public class PracticeExperience {
    private Integer id;
    private Integer stuId;
    private String department;
    private String post;
    private LocalDate startDate;
    private LocalDate overDate;
    private String performance;

}