package com.example.oaes_servlet.Entity.examination;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class examination_iiitb extends examination {
    examination_iiitb(String exam_id){
        this.exam_id=exam_id;
        edata = new eval_data(this.exam_id);
    }

    public boolean get_list_tests() {
        ResultSet rs=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/oaes_lite","root","password");

            Statement stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM tests");
        } catch (Exception err){
            System.out.println("Error while connecting with SQL server to get the list of tests "+err);
            return false;
        }

        System.out.println("  id    course      date     status");

        try{
            if(rs!=null){
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String course = rs.getString("course");
                    String date = rs.getString("date");
                    String status=rs.getString("status");

                    String to_print = String.format("%4d  %8s  %8s   %8s", id, course, date, status);
                    System.out.println(to_print);
                }
            } else {
                System.out.println("No active tests to display");
                return false;
            }
        } catch (Exception err){
            System.out.println("Error while getting list of tests "+err);
            return false;
        }


        Scanner sc_exam = new Scanner(System.in);
        System.out.println("Enter the test ID: ");
        this.test_id = sc_exam.nextInt();
        return true;
    }

    public boolean get_questions() {
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oaes_lite", "root", "password");
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM question_bank where test_id=" + this.test_id);
        } catch (Exception e){
            System.out.println("Error while connecting with SQL server to get the list of questions "+e);
            return false;
        }

        Scanner sc_exam = new Scanner(System.in);

        System.out.println("\n####### Welcome to Online Assessment #######");
        try{
            while (rs.next()) {
                int id = rs.getInt("id");
                String question = rs.getString("statement");
                String marks = rs.getString("marks");
                String a = rs.getString("option A");
                String b=rs.getString("option B");
                String c=rs.getString("option C");
                String d=rs.getString("option D");

                System.out.println("\n"+id+"> "+question+" (marks: "+marks+")");
                System.out.println("a) "+a+"   b)"+b+"   c)"+c+"   d)"+d);
                System.out.println("\nEnter your option: ");

                String ans = sc_exam.nextLine();

                answer adata = new answer(this.test_id, id, ans);
                edata.answers.add(adata);
            }
        } catch (Exception err){
            System.out.println("Error while getting questions "+err);
            return false;
        }

        return true;
    }

    public void submit_for_eval() {
        System.out.println("\n\nAnswers for review");

        System.out.println("Your examination ID: "+this.exam_id);
        System.out.println("testid   queid   answer");
        for(answer ans: this.edata.answers){
            String to_print = String.format("%6s   %5s   %6s", ans.test_id, ans.que_id, ans.answer);
            System.out.println(to_print);
        }
    }
}
