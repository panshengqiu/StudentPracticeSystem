package cn.edu.bjut.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HumanResource {
    private Integer id;
    private Integer firmId;
    private String username;
    private String password;
}
