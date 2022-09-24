package com.example.oaes_servlet.Entity.examination;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

abstract public class examination {
    public int test_id=0;
    String exam_id="";
    eval_data edata=null;

//    abstract boolean get_list_tests();
    abstract ArrayList<ArrayList<String>> get_list_tests();
    abstract ArrayList<ArrayList<String>> get_questions();
    abstract void submit_for_eval();

    //template method
    public void conduct(HttpServletRequest request, HttpServletResponse response) throws IOException {

        HttpSession session=request.getSession(true);
        ArrayList<ArrayList<String>>tests=get_list_tests();
        session.setAttribute("tests",tests);
        session.setMaxInactiveInterval(1000);
        response.sendRedirect("exam.jsp");
        return;
//        if(!get_questions()) return false;
//        submit_for_eval();
    }

    public void taketest(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String testid= (String) request.getParameter("testid");
        this.test_id=Integer.parseInt(testid);
        HttpSession session=request.getSession(true);
        ArrayList<ArrayList<String>>questions=get_questions();
        System.out.println("Entering test"+testid);
        for(ArrayList<String>q:questions){
            for(String s:q){
                System.out.print(s+" ");
            }
            System.out.println();
        }
        session.setAttribute("questions",questions);
        System.out.println(questions);
        session.setMaxInactiveInterval(1000);
        response.sendRedirect("test.jsp");
        return;
    }
}
