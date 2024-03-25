package cn.edu.bjut.entity.post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data   // 自动生成toString(),equals(),hashCode(),setter(),getter()
@NoArgsConstructor  // 无参构造
@AllArgsConstructor  // 有参数构造方法
public class Post {
    private Integer id;
    private Integer smallPostId;
    private Integer hrId;
    private String name;
    private String description;
    private String  demand;
    private Integer pay;
    private Integer minInternship;
    private String workPlace;
    private LocalDate deliveryDeadline;
    private String workCity;
}
