<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Lists</title>
</head>
<body>
	<form method = "post" action = "listnavigationServlet">
	<table>
	<c:forEach items="${requestScope.allLists}" var="currentlist">
	<tr>
		<td><input type="radio" name="id" value="${currentlist.id}"></td>
		<td><h2>${currentlist.listName}</h2></td></tr>
		<tr><td colspan="3">Trip Date: ${currentlist.tripDate}</td></tr>
		<tr><td colspan="3">Teacher: ${currentlist.teacher.teacherName}</td></tr>
		<c:forEach var = "listVal" items = "${currentlist.listOfStudents}">
			<tr><td></td><td colspan="3">
				${listVal.name}, ${listVal.age}
				</td>
			</tr>
		</c:forEach>
	</c:forEach>
	</table>
	<input type = "submit" value = "edit" name="doThisList">
	<input type = "submit" value = "delete" name="doThisList">
	<input type = "submit" value = "add" name = "doThisList">
	</form>
	<a href="addStudentsForListServlet">Create a new List</a>
	<a href="index.html">Insert a new Student</a>
</body>
</html>