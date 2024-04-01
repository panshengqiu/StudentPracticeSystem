package cn.edu.bjut.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data   // 自动生成toString(),equals(),hashCode(),setter(),getter()
@NoArgsConstructor  // 无参构造
@AllArgsConstructor  // 有参数构造方法
public class ChatRecord {
    private Integer id;
    private Object sender;
    private Object receiver;
    private String content;
    private LocalDateTime sendTime;
    private LocalDateTime receiveTime;
}
