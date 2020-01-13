package com.fh.service.impl;

import com.fh.dao.StudentDao;
import com.fh.entity.po.Student;
import com.fh.entity.vo.DataTableData;
import com.fh.entity.vo.Params;
import com.fh.service.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentDao studentDao;
    @Resource
    HttpServletRequest request;

    @Override
    public void addStudent(Student student) {
        int year = student.getBirthday().getYear();
        Date date = new Date();
        int year1 = date.getYear();
        student.setAge(year1-year);

        student.setIsDel(1);

        student.setIp(request.getRemoteAddr());

        studentDao.addStudent(student);
    }

    @Override
    public DataTableData queryStudentData(Params params) {
        long count = studentDao.queryCount(params);
        List<Student> list = studentDao.queryStudentList(params);

        DataTableData data = new DataTableData();
        data.setDraw(params.getDraw());
        data.setData(list);
        data.setRecordsTotal(count);
        data.setRecordsFiltered(count);
        return data;
    }

    @Override
    public Student queryStudentById(Integer id) {
        return studentDao.queryStudentById(id);
    }

    @Override
    public void updateStudent(Student student) {
        int year = student.getBirthday().getYear();
        Date date = new Date();
        int year1 = date.getYear();
        student.setAge(year1-year);

        student.setIsDel(1);

        student.setIp(request.getRemoteAddr());

        studentDao.updateStudent(student);
    }

    @Override
    public void delStudent(Integer id) {
        studentDao.delStudent(id);
    }
}
