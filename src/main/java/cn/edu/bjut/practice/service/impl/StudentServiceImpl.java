package cn.edu.bjut.practice.service.impl;

import cn.edu.bjut.entity.student.other.Student;
import cn.edu.bjut.practice.mapper.StudentMapper;
import cn.edu.bjut.practice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Transactional(rollbackFor = Exception.class) // rollbackFor = Exception.class表面回滚所有类型的异常
    public void delete(Integer id) {              // 而 @Transactional回滚RuntimeException类型的异常
    }

    public Student login(Student student) {
        return studentMapper.login(student);
    }

}
