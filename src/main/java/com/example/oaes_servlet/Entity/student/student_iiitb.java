package com.example.oaes_servlet.Entity.student;

import com.example.oaes_servlet.dao.StudentDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class student_iiitb extends student{

    StudentDao studentDao;
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
        String q="";
        if(e){
            q = "SELECT password from Student where email='"+email+"'";
        } else {
            q = "SELECT password from Student where phone='"+phone+"'";
        }

        System.out.println(q);
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/oaes_lite","root","password");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(q);

            while (rs.next()){
                String passwd = rs.getString("password");

                if(passwd.equals(pass)){
                    return true;
                }
            }
        } catch (Exception err){
            System.out.println(err);
        }

        return false;
    }
}
