package com.fh.service;

import com.fh.entity.po.Student;
import com.fh.entity.vo.DataTableData;
import com.fh.entity.vo.Params;

public interface StudentService {
    void addStudent(Student student);

    DataTableData queryStudentData(Params params);

    Student queryStudentById(Integer id);

    void updateStudent(Student student);

    void delStudent(Integer id);
}
