package com.example.oaes_servlet.service;

import com.example.oaes_servlet.Entity.examination.examination;
import com.example.oaes_servlet.dao.ExaminationDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class ExamService {
    ExaminationDao examDao;

    public ExamService(){
        examDao= new ExaminationDao();
    }
    public ArrayList<ArrayList<String>> gettests() throws IOException {
        ArrayList<ArrayList<String>>tests=examDao.get_list_tests();
        return tests;
    }

    public ArrayList<ArrayList<String>> get_questions(String testid) {
        return examDao.get_questions(testid);
    }
}
