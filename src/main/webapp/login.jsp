<%--
  Created by IntelliJ IDEA.
  User: himank
  Date: 10/09/22
  Time: 5:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Login</title>
</head>
<body>
    <h1>Student Login</h1>
    <p><mark>${msg}</mark></p>

    <script type="text/javascript">
        function displayForm(c) {
            if (c.value == "1") {
                document.getElementById("username-form-container").style.visibility = 'visible';
                document.getElementById("phone-form-container").style.visibility = 'hidden';
            } else if (c.value == "2") {
                document.getElementById("username-form-container").style.visibility = 'hidden';
                document.getElementById("phone-form-container").style.visibility = 'visible';
            } else {}
        }

    </script>


    <form>
        <input value="1" type="radio" name="formselector" onClick="displayForm(this)"></input>Email Login
        <br>
        <input value="2" type="radio" name="formselector" onClick="displayForm(this)"></input>Phone Login
    </form>

    <div style="visibility:hidden; position:relative" id="username-form-container">
        <form id="usernameform" action="auth-student" method="get">>
            <label for="examid1">Exam ID:</label><br>
            <input type="text" id="examid1" name="examid"><br>
            <input type="hidden" name="e" value="1"><br>
            <label for="useremail">Useremail:</label><br>
            <input type="text" id="useremail" name="studentemail"><br>
            <label for="password">Password:</label><br>
            <input type="password" id="password" name="studentpassword"><br>
            <input type="submit" name="submit" value="Login">
        </form>
    </div>

    <div style="visibility:hidden;position:relative" id="phone-form-container">
        <form id="phoneform" action="auth-student" method="get">>
            <label for="examid2">Exam ID:</label><br>
            <input type="text" id="examid2" name="examid"><br>
            <input type="hidden" name="e" value="0">
            <label for="phone">Username:</label><br>
            <input type="text" id="phone" name="studentphone"><br>
            <label for="password2">Password:</label><br>
            <input type="password" id="password2" name="studentpassword"><br>
            <input type="submit" name="submit" value="Login">
        </form>
    </div>



</body>
</html>
