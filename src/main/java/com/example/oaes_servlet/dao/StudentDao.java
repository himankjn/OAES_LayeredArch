package com.example.oaes_servlet.dao;

import com.example.oaes_servlet.Entity.student.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDao {
    public String create_generate_id(student st){
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
