package com.example.oaes_servlet.Entity.student;

import com.example.oaes_servlet.dao.StudentDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class student_iiitb extends student{

    StudentDao studentDao;
    student_iiitb(){
        studentDao=new StudentDao();
    }
//    student_iiitb(String name, String email, String uname, String passwd, String phone, String roll_number){
//        this.name = name;
//        this.email = email;
//        this.uname = uname;
//        this.passwd = passwd;
//        this.phone = phone;
//        this.roll_number = roll_number;
//        this.exam_id = "IIITB-"+roll_number;
//    }

    public String generate_id(){
        return studentDao.create_generate_id(this);
    }

    public boolean validate(String email, String phone, String pass, boolean e)
    {
        return studentDao.validate(email,phone,pass,e);
    }
}
