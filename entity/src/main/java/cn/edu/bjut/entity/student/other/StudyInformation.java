package cn.edu.bjut.entity.student.other;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data   // 自动生成toString(),equals(),hashCode(),setter(),getter()
@NoArgsConstructor  // 无参构造
@AllArgsConstructor  // 有参数构造方法
public class StudyInformation {
    private Integer id;
    private Student student;
    private String major;
    private String school;
    private String grade;
}
