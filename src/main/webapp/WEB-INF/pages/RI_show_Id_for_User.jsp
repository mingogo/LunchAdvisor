<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.*"%>
<%@page import="smartworks.sz.postmortem.factory.DAOFactory"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:import url="RE_Header.jsp"/>

<!-- Bootstrap core CSS -->
<link href="../../css/bootstrap.min.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="../../css/starter-template.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="../../css/dashboard.css" rel="stylesheet">

<!-- Custom styles for this template and this is for the side bar-->
<link href="../../css/dashboard2.css" rel="stylesheet">

<c:import url="RE_MenuBanner.jsp"/>

<title>Insert title here</title>
</head>
<body>
	<jsp:include page="RE_SideBarForShuoC.jsp"></jsp:include>
	<center>
	<table>
		<tr>
			<td>Incident ID</td>
			<td></td>
			<td></td>
		</tr>
		<%
		String IncidentId = null;
		ArrayList<Integer> arrayList=null;
		int incidentIdString;
		try {
			arrayList=DAOFactory.getInstance().findAllIncident();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Iterator<Integer> iter=arrayList.iterator();
		while (iter.hasNext()) {
			IncidentId=String.valueOf(iter.next());
			%>
		<tr>
			<td><%=IncidentId%></td>
			<td>
<!-- 				<form action="IncidentPostmortem.jsp" method="post"> -->
				<form action="resolve_incident.jsp" method="post">
					<input type="hidden" name="IncidentId" value=<%=IncidentId%>>
					<input type="submit" value="incident_postmortem">
				</form>
			</td>
		</tr>
		<%
		}			
		%>

	</table> <!-- The end of the table -->
	</center>
</body>
</html>