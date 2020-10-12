<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Users</title>
    <style>
        table, th, td
        {
            border: 1px solid black;
        }
        table
        {
            width: 40%;
            border-collapse: collapse;
        }
        th, td
        {
            height: 40px;
            text-align: center;
            font-size: 1.5rem;
        }
    </style>
</head>
<body>
<h1>Users</h1>

<br/>

<div>
    <table >
        <tr>
            <th>id</th>
            <th>username</th>
        </tr>
        <jsp:useBean id="userlist" scope="request" type="java.util.List"/>
        <c:forEach  items="${userlist}" var ="userlist">
            <tr>
                <td>${userlist.id}</td>
                <td>${userlist.username}</td>

                    <%--                <td><a href="/books/${book.id}"></a></td>--%>

                <td><a href="/admin/users/delete/${userlist.id}">Delete user</a>

            </tr>
        </c:forEach>
    </table>
</div>


</body>
</html>