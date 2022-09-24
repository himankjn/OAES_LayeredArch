package com.example.oaes_servlet.service;

import com.example.oaes_servlet.Entity.student.student;
import com.example.oaes_servlet.dao.StudentDao;

public class StudentAuthService {

    StudentDao studentDao=null;
    public StudentAuthService(){
        studentDao=new StudentDao();
    }
    public boolean validatestd(String email, String phone, String pass, boolean e){
        return studentDao.validate(email,phone,pass,e);
    }

}
