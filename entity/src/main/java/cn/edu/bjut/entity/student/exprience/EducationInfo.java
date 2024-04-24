package cn.edu.bjut.entity.student.exprience;


import cn.edu.bjut.entity.student.other.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data   // 自动生成toString(),equals(),hashCode(),setter(),getter()
@NoArgsConstructor  // 无参构造
@AllArgsConstructor  // 有参数构造方法
public class EducationInfo {
    private Integer id;
    private Student student;
    private String major;
    private String school;
    private String rank;
    private Integer score;
    private String education;
    private String lessonDescription;
    private Integer educationIndex;
    private LocalDate startDate;
    private LocalDate overDate;

    // 省略 getter 和 setter 方法
}
