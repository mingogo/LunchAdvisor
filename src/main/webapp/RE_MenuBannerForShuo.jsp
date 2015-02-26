<!-- 
mteng:
This is the top manu bar for Shuo Zhang since the JSP are stored in the /jsp folder.
-->

<!--   Here are some POJO to read the attributes  -->
<%@ page import="java.util.*"%>
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
			<a class="navbar-brand" href="../login.jsp"> Hello,
				${sessionScope.S_accnt}. </a>
		</div>
		<div class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li class="active"><a href="../index.jsp">Home</a></li>
				<li><a href="../LIST_INSDT_Serv.do"> Incident Management</a></li>
<!-- 				<li><a href="../jsp/IncidentPostmortem.jsp"> Incident Postmortem</a></li> -->
				<li><a href="../jsp/show_Id_for_User.jsp"> Incident Postmortem</a></li>
				<li><a href="../RI_show_Id_for_User.jsp"> Resolve Incident</a></li>
			</ul>
		</div>
		<!--/.nav-collapse -->
	</div>
</div>
