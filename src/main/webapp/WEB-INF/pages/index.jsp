<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:import url="RE_Header.jsp" />
</head>
<body>
 	<c:import url="RE_MenuBanner.jsp" />
	<%--<c:import url="RE_MenuBannerForGuest.jsp" />--%>

	<br>
	<center>
		<div class="jumbotron">
			<h1>LunchAdvisor@RSC </h1>
			<p class="lead">Strive for your lunch need.</p>
			<p>
				<a class="btn btn-primary btn-lg" href="lunch" role="button">I am feeling lucky today</a>
			</p>
		</div>
	</center>

	<c:import url="RE_FooterForLoadFaster.jsp" />
</body>
</html>
