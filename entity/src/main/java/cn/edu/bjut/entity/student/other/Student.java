package cn.edu.bjut.entity.student.other;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data   // 自动生成toString(),equals(),hashCode(),setter(),getter()
@NoArgsConstructor  // 无参构造
@AllArgsConstructor  // 有参数构造方法
public class Student {

    private Integer id; //ID
    private String username; //学生名称
    private String name;
    private String sex;
    private String password; //
    private LocalDate birthday;
    private String phone;
    private String email;
    private String headUrl;
}
