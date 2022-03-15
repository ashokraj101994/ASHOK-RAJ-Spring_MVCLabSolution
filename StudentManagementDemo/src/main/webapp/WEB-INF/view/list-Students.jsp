<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<title>Student Management DEMO</title>
</head>

<body>

	<div class="container">

		<h3>STUDENT MANAGEMENT SYSTEM</h3>
		<hr>

		<p class="h4 mb-4">STUDENT LIST</p>
		
			<a href="/StudentManagementDemo/student/showFormForAdd"
				class="btn btn-primary btn-sm mb-3"> Add Student </a> 

		<table class="table table-bordered table-striped">
			<thead class="thead-dark">
				<tr>
				    <th>ID</th>
					<th>Name</th>
					<th>Department</th>
					<th>Country</th>
					<th>Action</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${Student}" var="tempStd">
					<tr>
					    <td><c:out value="${tempStd.id}" /></td>
						<td><c:out value="${tempStd.name}" /></td>
						<td><c:out value="${tempStd.department}" /></td>
						<td><c:out value="${tempStd.country}" /></td>
						<td>
							<!-- Add "update" button/link --> <a
							href="/StudentManagementDemo/student/showFormForUpdate?stdId=${tempStd.id}"
							class="btn btn-info btn-sm"> Update </a> <!-- Add "delete" button/link -->
							<a href="/StudentManagementDemo/student/delete?stdId=${tempStd.id}"
							class="btn btn-danger btn-sm"
							onclick="if (!(confirm('Are you sure you want to delete?'))) return false">
								Delete </a>

						</td>

					</tr>
				</c:forEach>

			</tbody>
		</table>

	</div>

</body>
</html>