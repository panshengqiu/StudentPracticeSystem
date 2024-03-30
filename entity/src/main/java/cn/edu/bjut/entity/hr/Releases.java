package cn.edu.bjut.entity.hr;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data   // 自动生成toString(),equals(),hashCode(),setter(),getter()
@NoArgsConstructor  // 无参构造
@AllArgsConstructor  // 有参数构造方法
public class Releases {
    private Integer id;
    private Integer postId;
    private Integer hrId;
    private LocalDateTime releaseTime;
}
