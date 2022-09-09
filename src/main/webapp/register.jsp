<%--
  Created by IntelliJ IDEA.
  User: himank
  Date: 09/09/22
  Time: 9:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Registration</title>
</head>
<body>
    <h1>Student Registration</h1>
    <p><mark>${msg}</mark></p>
    <p>Please enter student details for registration.</p>
    <form action="register-student" method="get">

        <label for="studentname">Name:</label><br>
        <input type="text" id="studentname" name="studentname"><br>
        <label for="studentusername">User name:</label><br>
        <input type="text" id="studentusername" name="studentusername"><br>
        <label for="roll">Roll:</label><br>
        <input type="text" id="roll" name="roll"><br>
        <label for="studentemail">Email Id:</label><br>
        <input type="email" id="studentemail" name="studentemail"><br>
        <label for="studentphone">Phone No:</label><br>
        <input type="text" id="studentphone" name="studentphone"><br>
        <label for="studentpass">Password:</label><br>
        <input type="password" id="studentpass" name="studentpass"><br>
        <label for="studentconfpass">Confirm Password:</label><br>
        <input type="password" id="studentconfpass" name="studentconfpass"><br>

        <input type="submit" value="Submit">
    </form>
</body>
</html>
