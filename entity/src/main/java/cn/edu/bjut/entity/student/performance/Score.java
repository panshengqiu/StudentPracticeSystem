package cn.edu.bjut.entity.student.performance;

import cn.edu.bjut.entity.student.other.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data   // 自动生成toString(),equals(),hashCode(),setter(),getter()
@NoArgsConstructor  // 无参构造
@AllArgsConstructor  // 有参数构造方法
public class Score {
    private Integer id;
    private Student student;
    private double score;
    private double ranking;
    private double gpa;
}
