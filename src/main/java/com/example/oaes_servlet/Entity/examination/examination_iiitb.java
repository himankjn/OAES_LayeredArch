package com.example.oaes_servlet.Entity.examination;

import com.example.oaes_servlet.dao.ExaminationDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class examination_iiitb extends examination {
    ExaminationDao examDao;
    examination_iiitb(String exam_id){
        this.exam_id=exam_id;
        edata = new eval_data(this.exam_id);
        examDao=new ExaminationDao();
    }

    public ArrayList<ArrayList<String>> get_list_tests() {
        return examDao.get_list_tests();
    }

    public ArrayList<ArrayList<String>> get_questions() {
        String testid=Integer.toString(this.test_id);
        return examDao.get_questions(testid);
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
