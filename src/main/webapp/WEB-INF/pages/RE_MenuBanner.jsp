<!--
mteng:
This is the menu banner that you can see of the top of every page for better navigation.
-->
<!--   Here are some POJO to read the attributes  -->
<%@ page import="java.util.*"%>

<!-- Here the POJO take session attribute to display the welcome message to the user. -->
<!-- Plan to replace it using JSTL. -->
<% 
  	String usr_NM_jsp = (String)session.getAttribute("S_accnt");
  	if (usr_NM_jsp == null){
  		session.setAttribute("S_accnt", "Guest");
  	}
  	System.out.println("#####Session User:" +usr_NM_jsp);
  %>
<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="index"> Hello, Guest. </a>
		</div>
		<div class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li class="active"><a href="index">Home</a></li>
				<%--<li><a href=""> Incident Management</a></li>--%>
<!-- 				<li><a href="jsp/IncidentPostmortem.jsp"> Incident Postmortem</a></li> -->
				<%--<li><a href=""> Incident Postmortem</a></li>--%>
				<%--<li><a href=""> Resolve Incident</a></li>--%>
			</ul>
		</div>
		<!--/.nav-collapse -->
	</div>
</div>
