package cn.edu.bjut.entity.student.exprience;

import cn.edu.bjut.entity.student.other.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data   // 自动生成toString(),equals(),hashCode(),setter(),getter()
@NoArgsConstructor  // 无参构造
@AllArgsConstructor  // 有参数构造方法

public class ProjectExperience {
    private Integer id;
    private Student student;
    private String name;
    private String role;
    private LocalDate startDate;
    private LocalDate overDate;
    private String performance;
    private Integer projectIndex;
}
