package cn.edu.bjut.entity.student.other;

import cn.edu.bjut.entity.post.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data   // 自动生成toString(),equals(),hashCode(),setter(),getter()
@NoArgsConstructor  // 无参构造
@AllArgsConstructor  // 有参数构造方法
public class Submit {
    private Integer id;
    private Post post;
    private Resume resume;
    private LocalDateTime submitTime;
    private String status;
}
