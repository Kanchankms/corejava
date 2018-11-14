<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="for" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<for:form method="post" action="insertdata" modelAttribute="my">
<table>
<%-- <tr>
<td>Employee Id</td>
<td><for:input path="empId"/></td>
</tr> --%>

<tr>
<td>Employee Name</td>
<td><for:input path="empName"/></td>
<td><for:errors path="empName"></for:errors></td>
</tr>

<tr>
<td>Employee Salary</td>
<td><for:input path="empSalary"/></td>
<td><for:errors path="empSalary"></for:errors>
</tr>

<tr>
<td>Employee Designation</td>
<td><for:select path="empDesignation" items="${deg}"/></td>
</tr>

<tr>
<td>Employee Gender</td>
<td><for:radiobutton path="empGender" value="male"/>Male</td>
<td><for:radiobutton path="empGender" value="female"/>FeMale</td>
</tr>
<tr>
<td><input type="submit" value="Add Employee"></input></td>
</tr>
</table>

</for:form>
</body>
</html>