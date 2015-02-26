<!-- 
mteng:
The page to fetch the user entries and send the attributes to the servlet (url: Prio_Serv.do), 
in which it receive the attributes and update the team database.
-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<c:import url = "RE_Header.jsp"/>
<!-- Custom styles for this template -->
<link href="css/dashboard2.css" rel="stylesheet">

</head>
<body>
	<c:import url = "RE_MenuBanner.jsp"/>

	<!-- Determine if you are a Manager or User and displaying different side bar.-->
	<c:if test="${Type == 'Manager'}">
		<jsp:include page="RE_sidebar.jsp"></jsp:include>
	</c:if>
	<c:if test="${Type != 'Manager'}">
		<jsp:include page="RE_UserSideBar.jsp"></jsp:include>
	</c:if>


	<center>
		<h2>Prioritize incident entry:</h2>
	</center>

	<center>
		<form class="" action="Prio_Serv.do">
			<!-- systemname_Attrb -->
			<div class="input-group input-group-lg" style="width: 500pt;">
				<span class="input-group-addon"></span> <input type="text"
					class="form-control" name="IncidentId"
					placeholder="Incident id" required>
			</div>
			<!-- End of the container -->
			<br>
			<!-- desc_Attrb -->
			<div class="input-group input-group-lg" style="width: 500pt;">
				<span class="input-group-addon"></span> <input type="text"
					class="form-control" style="height: 50pt;" name="Manager_Comments"
					placeholder="Manager Comments" required>
			</div>
			<!-- End of the container -->
			<br>
			<!-- systemname_Attrb -->
			<div class="input-group input-group-lg" style="width: 500pt;">
				<span class="input-group-addon"></span> <input type="text"
					class="form-control" name="New_Priority"
					placeholder="New Priority " required>
			</div>
			<!-- End of the container -->
			<br>

			<button class="btn btn-lg btn-primary btn-block"
				style="width: 500pt;" type="submit">Update</button>
			<br> <br> <br> <br>
		</form>
	</center>

</body>
</html>