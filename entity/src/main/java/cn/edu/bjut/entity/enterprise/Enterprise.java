package cn.edu.bjut.entity.enterprise;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data   // 自动生成toString(),equals(),hashCode(),setter(),getter()
@NoArgsConstructor  // 无参构造
@AllArgsConstructor  // 有参数构造方法
public class Enterprise {
    private Integer id;
    private String name;
    private String address;
    private String description;
    private String logoUrl;
    private String creditCode;
}
