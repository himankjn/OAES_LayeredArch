package com.example.oaes_servlet.servlets;

import com.example.oaes_servlet.Entity.examination.examination;
import com.example.oaes_servlet.Entity.examination.examination_factory;
import com.example.oaes_servlet.Entity.student.student;
import com.example.oaes_servlet.Entity.student.student_factory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ConductExam", value = "/conduct-exam")
public class ConductExam extends HttpServlet {
    String e_id="";
    student_factory stdFactory = null;
    examination_factory examFactory = null;

    public void init() {
        stdFactory = new student_factory();
        examFactory = new examination_factory();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session=request.getSession(true);
        String examid=(String)session.getAttribute("e_id");
        System.out.println(examid);
        if(session.getAttribute("e_id")==null){
            String msg="Examination module needs Authentication. Login Please!";
            request.setAttribute("msg",msg);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);
            return;
        }
        else{
            //hardcode student type.
            String student_type="iiitb";
            examination exam = examFactory.create_exam(student_type,examid);
            exam.conduct(request,response);
        }
    }

    public void destroy() {
    }
}
