        <%@ page import="java.util.ArrayList" %><%--

  Created by IntelliJ IDEA.
  User: himank
  Date: 10/09/22
  Time: 6:41 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Examination</title>
</head>
<body>
    <h1>Examination</h1>

<%--    <%--%>
<%--        String examid = request.getParameter("e_id");--%>
<%--        if ( examid == null || examid=="") {--%>
<%--            String redirectURL = "login.jsp";--%>
<%--            response.sendRedirect(redirectURL);--%>
<%--        }--%>
<%--        else{--%>

<%--        }--%>
<%--    %>--%>

    <%
        ArrayList<ArrayList<String>> tests = null;
        if (session != null) {
            tests = (ArrayList<ArrayList<String>>) session.getAttribute("tests");
        }
    %>

    <h1> Welcome To Examination!</h1>

<%--    <tr>name="<%= request.getAttribute("Name") %>"</tr>--%>

<%--    <tr>name="<%= request.getAttribute("Name") %>"</tr>--%>
<%--    <tr>secn="<%= request.getAttribute("SECN") %>"</tr>--%>
<%--    <tr>title="<%= request.getAttribute("TITLE") %>"</tr>--%>
    <p> The number of tests are :"<%=tests.size()%>"</p>


    <table>
        <tr>
            <th>Id</th>
            <th>Course</th>
            <th>Date</th>
            <th>Status</th>
        </tr>
        <c:forEach items="${tests}" var="item">
            <tr>
                <td><c:out value="${item[0]}" /></td>
                <td><c:out value="${item[1]}" /></td>
                <td><c:out value="${item[2]}" /></td>
                <td><c:out value="${item[3]}" /></td>
            </tr>
        </c:forEach>

    </table>

</body>
</html>
