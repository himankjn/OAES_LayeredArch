package com.example.oaes_servlet.servlets;

import com.example.oaes_servlet.Entity.examination.examination_factory;
import com.example.oaes_servlet.Entity.student.student;
import com.example.oaes_servlet.Entity.student.student_factory;

import java.io.*;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "registerstudent", value = "/register-student")
public class RegisterStudent extends HttpServlet {
    String e_id="";
    student_factory stdFactory = null;
    examination_factory examFactory = null;

    public void init() {
        stdFactory = new student_factory();
        examFactory = new examination_factory();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String msg="";

        //System.out.println("In the register Servlet");
        String confirm=request.getParameter("studentconfpass");
        String pass=request.getParameter("studentpass");

        if(!confirm.equals(pass)){
            msg="Password Mismatch. Registration Fail. Try again!";
            //System.out.println(msg);
            request.setAttribute("msg",msg);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/register.jsp");
            dispatcher.forward(request, response);
            return;
        }


        //Map<String,String[]> mp=request.getParameterMap();
        //mp.get("studentname")
        //hardcoding student type

        String student_type="iiitb";

        student std = stdFactory.create_student(student_type);
        std.name = request.getParameter("studentname");
        std.email = request.getParameter("studentemail");
        std.phone = request.getParameter("studentphone");
        std.uname = request.getParameter("studentusername");
        std.roll_number = request.getParameter("roll");
        std.passwd = request.getParameter("studentpass");
        std.exam_id = student_type+"-"+std.roll_number;
        if(!std.validate_email()) {
            msg="Email validation fail.Try again!";
            //System.out.println(msg);
            request.setAttribute("msg",msg);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/register.jsp");
            dispatcher.forward(request, response);
            return;
        }
        if(!std.validate_phone()){
            msg="Phone validation fail. Try again!";
            //System.out.println(msg);
            request.setAttribute("msg",msg);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/register.jsp");
            dispatcher.forward(request, response);
            return;
        }

        String exam_id = std.generate_id();

        if(exam_id.equals("")) {
            msg="Error while generating exam ID";
            //System.out.println(msg);
            request.setAttribute("msg",msg);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
            return;
        }
        else{
            msg="Registration successful, your exam ID:" +exam_id;
            //System.out.println(msg);
            request.setAttribute("msg",msg);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
            return;
        }
    }

    public void destroy() {
    }
}