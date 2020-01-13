package com.fh.controller;

import com.fh.entity.po.Student;
import com.fh.entity.vo.DataTableData;
import com.fh.entity.vo.Params;
import com.fh.service.StudentService;
import com.fh.util.FileUtil;
import com.fh.util.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("student")
@CrossOrigin
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("/uploadFile")
    public ResponseData uploadFile(MultipartFile imgs, HttpServletRequest request){
        String filePath = FileUtil.uploadFile(imgs, request, "files");
        return ResponseData.success(filePath);
    }

    @RequestMapping("/addStudent")
    public ResponseData addStudent(Student student){
        studentService.addStudent(student);
        return ResponseData.success(null);
    }

    @RequestMapping("/queryStudentData")
    public DataTableData queryStudentData(Params params){
        DataTableData data = studentService.queryStudentData(params);
        return data;
    }

    @RequestMapping("/toUpdate")
    public ResponseData queryStudentById(Integer id){
        Student student = studentService.queryStudentById(id);
        return ResponseData.success(student);
    }

    @RequestMapping("/updateStudent")
    public ResponseData updateStudent(Student student,String newImg){
        if(newImg!=null && !newImg.equals("")){
            student.setImgPath(newImg);
        }
        studentService.updateStudent(student);
        return ResponseData.success(null);
    }

    @RequestMapping("/delStudent")
    public ResponseData delStudent(Integer id){
        studentService.delStudent(id);
        return ResponseData.success(null);
    }


}
