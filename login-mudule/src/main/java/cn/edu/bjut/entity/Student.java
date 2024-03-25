package cn.edu.bjut.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

/**
 * 部门实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private Integer id; //ID
    private String username; //学生名称
    private String name;
    private String password; //
}
