    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<h1>Employees List</h1>
	<table border="2" width="70%" cellpadding="2" >
	<tr><th>Id</th><th>Name</th><th>Edit</th><th>Delete</th></tr>
    <c:forEach var="emp" items="${list}"> 
    <tr>
    <td>${emp.employeeId}</td>
    <td>${emp.firstName}</td>
    <td><a href="editemp/${emp.employeeId}">Edit</a></td>
    <td><a href="deleteemp/${emp.employeeId}">Delete</a></td>
    </tr>
    </c:forEach>
    </table>
    <br/>
    <a href="empform">Add New Employee</a>