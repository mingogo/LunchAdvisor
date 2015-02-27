<!-- 
mteng:
This is a JSP page to review all incidents in the team data base.
-->
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<c:import url="RE_Header.jsp" />
<!-- Custom styles for this template -->
<link href="../../css/dashboard2.css" rel="stylesheet">

</head>
<body>
	<c:import url="RE_MenuBanner.jsp" />

	<!-- EL way to connect to the databases -->
	<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
		url="jdbc:mysql://localhost/team" user="root" password="" />

	<!-- EL way to do SQL queries -->
	<sql:query dataSource="${snapshot}" var="result">
		SELECT * from incident;
	</sql:query>

	<!-- EL: Determine if you are manager or user to display different sidebar -->
	<c:if test="${Type == 'Manager'}">
		<jsp:include page="RE_sidebar.jsp"></jsp:include>
	</c:if>
	<c:if test="${Type != 'Manager'}">
		<jsp:include page="RE_UserSideBar.jsp"></jsp:include>
	</c:if>

	<!-- Grab the response attributes sent from the sevlet and displaying the entries exported -->
	<center>
		<h1>${insdt_count} of ${insdt_count} entries retrieved. </h1>
	</center>

	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<div class="table-responsive">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>#</th>
						<th>Date</th>
						<th>Title</th>
						<th>Description</th>
						<th>System Name</th>
						<th>Affected System</th>
						<th>Notified Users</th>
						<th>Screen shots/Attachments</th>
						<th>Priority</th>
						<th>Business Units</th>
						<th>Affected Users (#)</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="row" items="${result.rows}">
						<tr>
							<td><c:out value="${row.incidentId}" /></td>
							<td><c:out value="${row.IncidentDate}" /></td>
							<td><c:out value="${row.Title}" /></td>
							<td><c:out value="${row.Description}" /></td>
							<td><c:out value="${row.SystemName}" /></td>
							<td><c:out value="${row.AffectedSystems}" /></td>
							<td><c:out value="${row.NotifiedUsers}" /></td>
							<td><c:out value="${row.Attachments}" /></td>
							<td><c:out value="${row.Priority}" /></td>
							<td><c:out value="${row.BusinessUnit}" /></td>
							<td><c:out value="${row.AffectedUsers}" /></td>
							<td><c:out value="${row.Actions}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<c:import url="RE_FooterForLoadFaster.jsp" />
</body>
</html>
