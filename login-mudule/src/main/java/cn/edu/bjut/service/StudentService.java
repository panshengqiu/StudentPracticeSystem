package cn.edu.bjut.service;

import cn.edu.bjut.entity.Student;

import java.util.List;

/**
 * 部门管理
 */
public interface StudentService {
    /**
     * 查询全部学生数据
     * @return
     */
    List<Student> list();

    /**
     * 删除学生
     * @param id
     */
    void delete(Integer id);

    /**
     * 新增学生 （注册）
     * @param student
     */
    void add(Student student);

    public Student login(String username, String password);
}
