package cn.edu.bjut.entity.post;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data   // 自动生成toString(),equals(),hashCode(),setter(),getter()
@NoArgsConstructor  // 无参构造
@AllArgsConstructor  // 有参数构造方法
public class PostSmallType {
    private Integer id;
    private PostBigType postBigType;
    private String name;
}
