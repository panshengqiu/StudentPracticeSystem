package cn.edu.bjut.studentregister.service.implement;

import cn.edu.bjut.entity.student.other.Student;
import cn.edu.bjut.studentregister.mapper.StudentMapperRegister;
import cn.edu.bjut.studentregister.service.StudentRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentRegisterImpl implements StudentRegisterService {

    @Autowired
    private StudentMapperRegister studentMapper1;

    public int register(String name,String username,String phone,String sex,String password) {
       return studentMapper1.insertStudent(name,username,phone,sex,password);
    }
}
