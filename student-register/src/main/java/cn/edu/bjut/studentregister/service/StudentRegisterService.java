package cn.edu.bjut.studentregister.service;

import cn.edu.bjut.entity.student.other.Student;

public interface StudentRegisterService {
    public int  register(String name,String username,String phone,String sex,String password);
}
