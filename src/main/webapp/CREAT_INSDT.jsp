<!-- 
mteng: 
This is a JSP using a from to save the user entries to the request attributes. 
A servlet (url:AddEntry.do) will be used to fetch the request object from this page 
and create entries to the team databases.
 -->

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<jsp:include page="RE_Header.jsp"></jsp:include>
<!-- Custom styles for this template and this is for the side bar-->
<link href="css/dashboard2.css" rel="stylesheet">
</head>

<body>
	<jsp:include page="RE_MenuBanner.jsp"></jsp:include>

	<!-- Determine which side bar should be used depending on the type of the user -->
	<c:if test="${Type == 'Manager'}">
		<jsp:include page="RE_sidebar.jsp"></jsp:include>
	</c:if>
	<c:if test="${Type != 'Manager'}">
		<jsp:include page="RE_UserSideBar.jsp"></jsp:include>
	</c:if>

	<center>
		<h2>Create an incident...if you dare.</h2>
	</center>
	<center>
		<form class="" action="AddEntry.do">
			<!-- title_Attrb -->
			<div class="input-group input-group-lg" style="width: 500pt;">
				<span class="input-group-addon"></span> <input type="text"
					class="form-control" name="title_Attrb" placeholder="Title" required>
			</div>
			<!-- End of the container -->
			<br>
			<!-- desc_Attrb -->
			<div class="input-group input-group-lg" style="width: 500pt;">
				<span class="input-group-addon"></span> <input type="text"
					class="form-control" style="height: 50pt;" name="desc_Attrb"
					placeholder="Description" required>
			</div>
			<!-- End of the container -->
			<br>
			<!-- systemname_Attrb -->
			<div class="input-group input-group-lg" style="width: 500pt;">
				<span class="input-group-addon"></span> <input type="text"
					class="form-control" name="systemname_Attrb"
					placeholder="System Name">
			</div>
			<!-- End of the container -->
			<br>
			<!-- affectedSystemString_Attrb -->
			<div class="input-group input-group-lg" style="width: 500pt;">
				<span class="input-group-addon"></span> <input type="text"
					class="form-control" name="affectedSystemString_Attrb"
					placeholder="Affected System">
			</div>
			<!-- End of the container -->
			<br>
			<!-- notifiedUsers_Attrb -->
			<div class="input-group input-group-lg" style="width: 500pt;">
				<span class="input-group-addon"></span> <input type="text"
					class="form-control" name="notifiedUsers_Attrb"
					placeholder="Notified Users">
			</div>
			<!-- End of the container -->
			<br>
			<!-- ScnSht_Athmt_Attrb -->
			<div class="input-group input-group-lg" style="width: 500pt;">
				<span class="input-group-addon"></span> <input type="text"
					class="form-control" name="ScnSht_Athmt_Attrb"
					placeholder="Screen shots/Attachments">
			</div>
			<!-- End of the container -->
			<br>
			<!-- priority_Attrb -->
			<!-- This one should be a dropdown box -->
			<div class="input-group input-group-lg" style="width: 500pt;">
				<span class="input-group-addon"></span> <input type="text"
					class="form-control" name="priority_Attrb" placeholder="Priority">
			</div>
			<!-- End of the container -->
			<br>
			<!-- bunits_Attrb -->
			<div class="input-group input-group-lg" style="width: 500pt;">
				<span class="input-group-addon"></span> <input type="text"
					class="form-control" name="bunits_Attrb"
					placeholder="Business Units">
			</div>
			<!-- End of the container -->
			<br>
			<!-- AffectedUsers_Attrb -->
			<div class="input-group input-group-lg" style="width: 500pt;">
				<span class="input-group-addon"></span> <input type="text"
					class="form-control" name="AffectedUsers_Attrb"
					placeholder="Affacted Users (#)" required>
			</div>
			<!-- End of the container -->
			<br>
			<!-- Actions_Attrb -->
			<div class="input-group input-group-lg" style="width: 500pt;">
				<span class="input-group-addon"></span> <input type="text"
					class="form-control" name="Actions_Attrb" placeholder="Actions">
			</div>
			<!-- End of the container -->
			<br>

			<button class="btn btn-lg btn-primary btn-block"
				style="width: 500pt;" type="submit">Submit</button>
			<br> <br> <br> <br>
		</form>
	</center>
	</div>
	<c:import url="RE_FooterForLoadFaster.jsp"/>
</body>
</html>
