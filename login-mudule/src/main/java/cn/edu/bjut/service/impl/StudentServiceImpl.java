package cn.edu.bjut.service.impl;

import cn.edu.bjut.entity.Student;
import cn.edu.bjut.mapper.StudentMapper;
import cn.edu.bjut.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    public List<Student> list() {
        return null;
    }


    @Transactional(rollbackFor = Exception.class) // rollbackFor = Exception.class表面回滚所有类型的异常
    public void delete(Integer id) {              // 而 @Transactional回滚RuntimeException类型的异常
    }

    public void add(Student student) {

    }

    public Student login(String username, String password) {
        return studentMapper.login(username, password);
    }

}
