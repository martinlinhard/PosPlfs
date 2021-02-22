<%-- 
    Document   : index
    Created on : Feb 21, 2021, 1:19:33 PM
    Author     : martin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>
                        Id
                    </th>
                    <th>
                        Name
                    </th>
                    <th>
                        Birthday
                    </th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${users}" var="user">
                    <tr>
                        <td>
                            ${user.id}
                        </td>
                        <td>
                            ${user.name}
                        </td>
                        <td>
                            ${user.birthday}
                        </td>
                        <td>
                            <form method="POST">
                                <input name="deleteId" type="hidden" value="${user.id}"/>
                                <input type="submit" value="Delete"/>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
