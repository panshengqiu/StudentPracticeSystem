package cn.edu.bjut.entity.post;

import cn.edu.bjut.entity.hr.HumanResource;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
@Data   // 自动生成toString(),equals(),hashCode(),setter(),getter()
@NoArgsConstructor  // 无参构造
@AllArgsConstructor  // 有参数构造方法
@Component
public class PostAndEnterprise
{
    private Integer id;
    private PostSmallType postSmallType;
    private HumanResource humanResource;
    private String name;
    private String description;
    private String  demand;
    private Integer pay;
    private Integer minInternship;
    private String workPlace;
    private LocalDate deliveryDeadline;
    private String workCity;
    private String status;
    private String month;
//需要的企业信息
    private String enterpriseName;
    private String address;
    private String enterpriseDescription;
    private String logoUrl;
    private String enterpriseId;
}
