package com.example.oaes_servlet.servlets;

import com.example.oaes_servlet.Entity.examination.examination;
import com.example.oaes_servlet.Entity.examination.examination_factory;
import com.example.oaes_servlet.Entity.student.student_factory;
import com.example.oaes_servlet.service.ExamService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "TakeTest", value = "/take-test")
public class TakeTest extends HttpServlet {

    String e_id = "";
    student_factory stdFactory = null;
    examination_factory examFactory = null;
    ExamService examService=null;

    public void init() {
        stdFactory = new student_factory();
        examFactory = new examination_factory();
        examService= new ExamService();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession(true);
        String examid = (String) session.getAttribute("e_id");
        String student_type="iiitb";
        examination exam = examFactory.create_exam(student_type,examid);
        String testid= (String) request.getParameter("testid");
        exam.test_id=Integer.parseInt(testid);
        ArrayList<ArrayList<String>>questions=examService.get_questions(testid);
        session.setAttribute("questions",questions);
        //System.out.println(questions);
        session.setMaxInactiveInterval(1000);
        response.sendRedirect("test.jsp");
    }

    public void destroy() {
    }

}