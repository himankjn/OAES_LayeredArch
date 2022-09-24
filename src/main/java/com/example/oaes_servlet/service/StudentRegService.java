package com.example.oaes_servlet.service;

import com.example.oaes_servlet.Entity.student.student;
import com.example.oaes_servlet.dao.StudentDao;

public class StudentRegService {
    StudentDao studentDao;
    public StudentRegService(){
        studentDao=new StudentDao();
    }


    public boolean confirmpass(String pass,String confirm){
        return confirm.equals(pass);
    }
    public boolean validatemail(student std){
        String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";

        //Matching the give email number with regular expression
        boolean result = std.email.matches(regex);
        if(result) {
            return true;
        }

        return false;
    }
    public boolean validatephone(student std){

        String regex = "^\\d{10}$";

        //Matching the given phone number with regular expression
        boolean result = std.phone.matches(regex);
        if(result) {
            return true;
        }

        return false;
    }

    public String generate_id(student std){
        return studentDao.create_generate_id(std);
    }
}
