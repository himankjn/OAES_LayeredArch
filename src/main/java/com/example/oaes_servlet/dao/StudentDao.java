package com.example.oaes_servlet.dao;

import com.example.oaes_servlet.Entity.student.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class StudentDao {

    public static String create_generate_id(student st){
        System.out.println("reached create generate id");
        String query = "insert into Student (exam_id, roll_number, name, email, username, password, phone) values ('"+st.exam_id+"','"+st.roll_number+"','"+st.name+"','"+st.email+"','"+st.uname+"','"+st.passwd+"','"+st.phone+"')";
        System.out.println(query);

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/oaes_lite?createDatabaseIfNotExist=true","root","password");
            Statement stmt=con.createStatement();
            int rs=stmt.executeUpdate(query);
        } catch (Exception e){
            System.out.println("Error while connecting with SQL server "+e);
            return "";
        }

        return st.exam_id;
    }
}
