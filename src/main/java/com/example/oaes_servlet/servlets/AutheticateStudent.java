package com.example.oaes_servlet.servlets;

import com.example.oaes_servlet.Entity.examination.examination;
import com.example.oaes_servlet.Entity.examination.examination_factory;
import com.example.oaes_servlet.Entity.student.student;
import com.example.oaes_servlet.Entity.student.student_factory;
import com.example.oaes_servlet.service.StudentAuthService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "authstudent", value = "/auth-student")
public class AutheticateStudent extends HttpServlet {
    String e_id="";
    student_factory stdFactory = null;
    examination_factory examFactory = null;
    StudentAuthService authserv=null;
    public void init() {
        stdFactory = new student_factory();
        examFactory = new examination_factory();
        authserv=new StudentAuthService();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String msg="";
        String email=request.getParameter("studentemail");
        String phone=request.getParameter("studentphone");
        String pass = request.getParameter("studentpassword");
        String exam_id=request.getParameter("examid");
        String flag=request.getParameter("e");
        boolean e=true;
        if(flag=="0"){
            e=false;
        }

        //hardcode student type to iiitb
        String student_type="iiitb";
        student std = stdFactory.create_student(student_type);
        boolean validate_std=authserv.validatestd(email, phone, pass, e);

        if(validate_std){
            this.e_id=exam_id;
            HttpSession session = request.getSession(true);
            session.setAttribute("e_id",exam_id);
            session.setMaxInactiveInterval(1000);
            response.sendRedirect("index.jsp");
            return;

        } else {
            msg="Authentication failure! Invalid email/phone or password";
            request.setAttribute("msg",msg);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);
            return;
        }
    }

    public void destroy() {
    }
}