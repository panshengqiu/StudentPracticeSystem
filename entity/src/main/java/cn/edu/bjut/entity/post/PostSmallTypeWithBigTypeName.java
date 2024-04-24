package cn.edu.bjut.entity.post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class PostSmallTypeWithBigTypeName {
    private String smallName; // 小类名称
    private String bigName;   // 大类名称
}
