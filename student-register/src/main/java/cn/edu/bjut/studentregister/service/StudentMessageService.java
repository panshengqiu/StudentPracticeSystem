package cn.edu.bjut.studentregister.service;

public interface StudentMessageService {
    String sendCode(String phoneNumber);

    void insertCode(String phone, String code);
}
