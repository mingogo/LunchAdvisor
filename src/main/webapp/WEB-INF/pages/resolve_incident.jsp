<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="java.util.*,java.sql.*;" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:import url="RE_Header.jsp" />

<!-- Custom styles for this template and this is for the side bar-->
<link href="css/dashboard2.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Resolve Incident</title>

<style type="text/css">
/* .div1 {
	width: 50%;
	overflow: hidden;
	float: left;
}

.div {
	width: 1300px;
}

.td_words {
	width: 120px
} */

#absolute {
position: absolute;
/* top: 50px;
left: 50%; */
margin-left:300px;
/* width: 700px;  */
}
</style>

<script language="javascript">
	function MoveOption(s1, s2) {
		for (var i = 0; i < s1.options.length; i++) {
			if (s1.options[i].selected) {
				var s = s1.options[i];
				s2.options.add(new Option(s.text, s.value));
				s1.remove(i);
			}
		}
	}

	function OptionSelect(s) {
		for (var i = 0; i < s.options.length; i++) {
			s.options[i].selected = true;
		}
	}

	function sub() {
		document.myform.submit();
	}
</script>

</head>
<body bgcolor="#C0C0C0">
	<c:import url="RE_MenuBanner.jsp" />
	<c:import url="RE_SideBarForShuoC.jsp" />

	<%
		String id = request.getParameter("IncidentId");
		Connection conn = null;
		PreparedStatement statement1 = null;
		PreparedStatement statement2 = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		String IncidentDate = new String();
		String HSComment[] = null;
		String Comment = new String();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
/* 					"jdbc:mysql://localhost:3306/team", "root", "cs1saboy"); */
					"jdbc:mysql://localhost:3306/team", "root", "");

			statement1 = conn
					.prepareStatement("select IncidentDate from incident where IncidentId=?");
			statement1.setObject(1, id);
			rs1 = statement1.executeQuery();
			while (rs1.next()) {
				IncidentDate = rs1.getString("IncidentDate");
			}
			statement2 = conn
					.prepareStatement("select Comment from Comment where IncidentId=?");
			statement2.setObject(1, id);
			rs2 = statement2.executeQuery();

			rs2.last();
			int size = rs2.getRow();
			rs2.beforeFirst();
			HSComment = new String[size];
			int n = 0;
			while (rs2.next()) {
				HSComment[n] = rs2.getString("Comment");
				n++;
			}
			if (HSComment == null || HSComment.length == 0) {
				HSComment[0] = "null";
			} else {
				Comment = "";
				for (int i = 0; i < HSComment.length; i++) {
					Comment = Comment + HSComment[i] + "\n";
				}
			}

			statement1.close();
			statement2.close();
			rs1.close();
			rs2.close();
			conn.close();
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
		}
	%>

<center>
<h1>Resolve Incident</h1>
</center>
<br>
<br>
<br>

<%-- <center> --%>
<div id="absolute">
<!-- 	<form name="myform" id="myform" style="width: 50px%" method="post" action="resolve_incident.do"> -->
	<form name="myform" id="myform" method="post" action="resolve_incident.do">
		<div class="div">
			<div class="div1">
				<table>
					<tr>
						<td class="td_words">Incident Id</td>
						<td><input type="text" name="Incident_Id" id="Incident_Id"
<%-- 							value=<%=id%> style="background-color: #F0F0F0; width: 200px" --%>
							value=<%=id%> style="background-color: #F0F0F0; "
							readonly></td>
					</tr>
				</table>
			</div>
			<div class="div1">
				<table>
					<tr>
						<td class="td_words">Incident Data</td>
						<td><input type="text" name="Incident_Date"
<%-- 							id="Incident_Date" value=<%=IncidentDate%> --%>
							id="Incident_Date"
							style="background-color: #F0F0F0; width: 200px" readonly>
							</td>
					</tr>
				</table>
			</div>
		</div>
		<div class="div">
			<br></br>
			<table>
				<tr>
					<td class="td_words" rowspan="2">Comments History</td>
					<td rowspan="2"><textarea name="Comments_History"
							id="Comments_History"
							style="width: 750px; height: 60px; background-color: #F0F0F0"
							readonly><%=Comment%></textarea></td>
				</tr>
			</table>
		</div>
		<br></br>
		<div class="div">
			<div class="div1">
				<table>
					<tr>
						<td class="td_words">Comments</td>
						<td colspan="3"><textarea name="Comments" id="Comments"
								style="height: 40px; width: 350px"></textarea></td>
					</tr>
					<tr>
						<td class="td_words">System Name</td>
						<td colspan="3"><input type="text" name="System_Name"
							id="System_Name" style="width: 350px"></td>
					</tr>

					<tr>
						<td class="td_words" rowspan="2">Affected Systems</td>
						<td rowspan="3"><select name="Affected_Systems1"
							id="Affected_Systems1" multiple size=10 style="width: 160px;">
								<option value="left test system1">left test system1</option>
								<option value="left test system2">left test system2</option>
								<option value="left test system3">left test system3</option>
								<option value="left test system4">left test system4</option>
								<option value="left test system5">left test system5</option>
						</select></td>
						<td></td>
						<td rowspan="3"><select name="Affected_Systems2"
							id="Affected_Systems2" multiple size=10 style="width: 160px">
						</select></td>
					</tr>
					<tr>
						<td><input type="button" name="button1" id="button1"
							value=">"
							onclick="MoveOption(document.myform.Affected_Systems1,document.myform.Affected_Systems2)"></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="button" name="button2" id="button2"
							value="<" onclick="MoveOption(document.myform.Affected_Systems2,document.myform.Affected_Systems1)"></td>
					</tr>
					<tr>
						<td height="20"></td>
						<td height="20"></td>
						<td height="20"></td>
						<td height="20"></td>
					</tr>
					<tr>
						<td class="td_words">Notify Users</td>
						<td colspan="3"><input type="text" name="Notify_Users"
							id="Notify_Users" style="width: 200px"></td>
					</tr>
					<tr>
						<td class="td_words">Screen shots<br>/Attachments
						</td>
						<td colspan="3"><input type="text" name="Attachments"
							id="Attachments" style="width: 200px"></td>
					</tr>
				</table>
			</div>
			<div class="div1">
				<table>
					<tr>
						<td>Priority</td>
						<td><select name="Priority" id="Priority">
								<option value="HIGH">HIGH</option>
								<option value="MEDIUM">MEDIUM</option>
								<option value="LOW">LOW</option>
						</select></td>
					</tr>
					<tr>
						<td class="td_words">Business Unit</td>
						<td><input type="text" name="Business_Unit"
							id="Business_Unit" style="width: 200px"></td>
					</tr>
					<tr>
						<td class="td_words">Affected Number of Users</td>
						<td><input type="text" name="Affected_Users"
							id="Affected_Users" style="width: 200px"></td>
					</tr>
					<tr>
						<td class="td_words">Actions Taken</td>
						<td rowspan="3"><input type="text" name="Actions_Taken"
							id="Actions_Taken" style="height: 180px; width: 200px"></td>
					</tr>
					<tr></tr>
					<tr></tr>
					<tr></tr>
					<tr>
						<td></td>
						<td><input type="button" value="Resolve Incident"
							name="Resolve_Incident" id="Resolve_Incident"
							onclick="OptionSelect(document.myform.Affected_Systems2);sub()"></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="reset" value="Cancel" name="Cancel"
							id="Cancel"></td>
					</tr>
				</table>
			</div>
		</div>
	</form>
	</div>
<%-- </center> --%>

</body>
</html>


