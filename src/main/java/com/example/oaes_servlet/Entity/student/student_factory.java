package com.example.oaes_servlet.Entity.student;

public class student_factory {
    public student create_student(String type){
        student std = null;
        if(type=="iiitb"){
            std = new student_iiitb();
        }
        return std;
    }
}
