package cn.edu.bjut.studentregister.service;

import cn.edu.bjut.entity.student.other.Student;

public interface StudentMessageService {
    String sendCode(String phoneNumber);

    boolean verifyCode(String phone, String code);
}
