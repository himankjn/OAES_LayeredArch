package com.example.oaes_servlet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class ExaminationDao {

    public ArrayList<ArrayList<String>> get_list_tests() {
        ResultSet rs=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/oaes_lite","root","password");

            Statement stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM tests");
        } catch (Exception err){
            System.out.println("Error while connecting with SQL server to get the list of tests "+err);
        }

        System.out.println("  id    course      date     status");
        ArrayList<ArrayList<String>>L=new ArrayList<ArrayList<String>>();
        try{
            if(rs!=null){
                while (rs.next()) {

                    ArrayList<String> s= new ArrayList<String>();
                    int id = rs.getInt("id");
                    String course = rs.getString("course");
                    String date = rs.getString("date");
                    String status=rs.getString("status");
                    s.add(String.valueOf(id));
                    s.add(course);
                    s.add(date);
                    s.add(status);
                    L.add(s);
                    String to_print = String.format("%4d  %8s  %8s   %8s", id, course, date, status);
                    System.out.println(to_print);
                }
            } else {
                System.out.println("No active tests to display");
            }
        } catch (Exception err){
            System.out.println("Error while getting list of tests "+err);
        }

        return L;
    }
    public ArrayList<ArrayList<String>> get_questions(String testid) {

        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oaes_lite", "root", "password");
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM question_bank where test_id=" + testid);
        } catch (Exception e) {
            System.out.println("Error while connecting with SQL server to get the list of questions " + e);
            return null;
        }

        ArrayList<ArrayList<String>> Q = new ArrayList<ArrayList<String>>();
        try {
            while (rs.next()) {
                ArrayList<String> s = new ArrayList<String>();
                int id = rs.getInt("id");
                String question = rs.getString("statement");
                String marks = rs.getString("marks");
                String a = rs.getString("option A");
                String b = rs.getString("option B");
                String c = rs.getString("option C");
                String d = rs.getString("option D");

                s.add(question);
                s.add(marks);
                s.add(a);
                s.add(b);
                s.add(c);
                s.add(d);
                Q.add(s);

            }
        } catch (Exception err) {
            System.out.println("Error while getting questions " + err);
            return null;
        }

        return Q;
    }
}



