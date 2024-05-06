package cn.edu.bjut.entity.student.other;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;


@Data   // 自动生成toString(),equals(),hashCode(),setter(),getter()
@NoArgsConstructor  // 无参构造
@AllArgsConstructor  // 有参数构造方法
@Component
public class Resume {
    private Integer id;
    private Student student;
    private String resumeUrl;
    private String uid;
    private String name;
}
