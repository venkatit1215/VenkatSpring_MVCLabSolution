<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student management Page</title>
</head>
<body>
    <div align="center">
        <h1>Student List</h1>
        <h3>
            <a href="newStudente">New Student</a>
        </h3>
        <table border="1">
 			<th>Student Id</th>
            <th>Name</th>
            <th>Department</th>
            <th>Country</th>
            <th>Action</th>
 
            <c:forEach var="student" items="${studentes}">
                <tr>
 					<td>${student.studentId}</td>
                    <td>${student.name}</td>
                    <td>${student.department}</td>
                    <td>${student.country}</td>
                    <td><a href="editStudent?id=${student.id}">Edit</a>
                             <a
                        href="deleteStudent?id=${student.id}">Delete</a></td>
 
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>