package cn.edu.bjut.studentregister.service.implement;

import cn.edu.bjut.entity.student.other.Student;
import cn.edu.bjut.studentregister.mapper.StudentMapper1;
import cn.edu.bjut.studentregister.service.StudentRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentRegisterImpl implements StudentRegisterService {

    @Autowired
    private StudentMapper1 studentMapper1;

    public int register(Student student) {
       return studentMapper1.insertStudent(student);
    }
}
