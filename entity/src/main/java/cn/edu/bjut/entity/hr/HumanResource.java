package cn.edu.bjut.entity.hr;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data   // 自动生成toString(),equals(),hashCode(),setter(),getter()
@NoArgsConstructor  // 无参构造
@AllArgsConstructor  // 有参数构造方法
public class HumanResource {
    private Integer id;
    private Integer firmId;
    private String username;
    private String password;
    private String head_url;
}
