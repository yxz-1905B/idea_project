package com.fh.dao;

import com.fh.entity.po.Student;
import com.fh.entity.vo.Params;

import java.util.List;

public interface StudentDao {
    void addStudent(Student student);

    long queryCount(Params params);

    List<Student> queryStudentList(Params params);

    Student queryStudentById(Integer id);

    void updateStudent(Student student);

    void delStudent(Integer id);
}
