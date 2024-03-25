package cn.edu.bjut.practice.service;


import cn.edu.bjut.entity.student.other.Student;

public interface StudentService {
    Student login(String username, String password);
}
