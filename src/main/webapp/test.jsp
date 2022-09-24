<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: himank
  Date: 13/09/22
  Time: 1:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test</title>
</head>
<body>


    <%
        ArrayList<ArrayList<String>> questions = null;
        if (session != null) {
            questions= (ArrayList<ArrayList<String>>) session.getAttribute("questions");
        }
    %>

    <h1> Welcome To the test!</h1>

    <%--    <tr>name="<%= request.getAttribute("Name") %>"</tr>--%>

    <%--    <tr>name="<%= request.getAttribute("Name") %>"</tr>--%>
    <%--    <tr>secn="<%= request.getAttribute("SECN") %>"</tr>--%>
    <%--    <tr>title="<%= request.getAttribute("TITLE") %>"</tr>--%>
    <p> The number of questions are :"<%=questions.size()%>"</p>


    <table>
        <tr>
            <th>Statement</th>
            <th>Test Id</th>
            <th>A</th>
            <th>B</th>
            <th>C</th>
            <th>D</th>

        </tr>
        <c:forEach items="${questions}" var="item">
            <tr>
                <td><c:out value="${item[0]}" /></td>
                <td><c:out value="${item[1]}" /></td>
                <td><c:out value="${item[2]}" /></td>
                <td><c:out value="${item[3]}" /></td>
                <td><c:out value="${item[4]}" /></td>
                <td><c:out value="${item[5]}" /></td>

            </tr>
        </c:forEach>
    </table>

<%--    <form action="index.jsp" method="get">--%>
<%--        <input type="submit" value= "Logout">--%>
<%--    </form>--%>

<%--    <form action="take-test" method="get">--%>
<%--        <label for="testid">Select the test you wish to take: </label>--%>
<%--        <input type="text" id="testid" name="testid">--%>
<%--        <input type="submit" value="Submit">--%>
<%--    </form>--%>

</body>
</html>
