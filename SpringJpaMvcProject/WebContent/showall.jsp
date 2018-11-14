<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib  prefix="a" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
<tr>
<th>Id</th>
<th>Name</th>
<th>Deg</th>
<th>Salary</th>
<th>Gender</th>
</tr>
<a:forEach var="emp" items="${temp}">
<tr>
<td>${emp.empId}</td>
<td>${emp.empName}</td>
<td>${emp.empDesignation}</td>
<td>${emp.empSalary}</td>
<td>${emp.empGender}</td>
</tr>
</a:forEach>

</table>
</body>
</html>