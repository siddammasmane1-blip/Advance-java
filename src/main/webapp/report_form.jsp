<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Select Date Range</title>

<style>
body{
margin:0;
font-family:Arial,sans-serif;
background:linear-gradient(135deg,#0b1d51,#27408b);
height:100vh;
display:flex;
justify-content:center;
align-items:center;
}

.container{
background:white;
padding:40px;
width:500px;
border-radius:25px;
text-align:center;
box-shadow:0 10px 25px rgba(0,0,0,0.3);
}

h1{
color:#1f3fa3;
margin-bottom:25px;
}

input{
width:90%;
padding:12px;
margin:12px;
font-size:16px;
border:1px solid #ccc;
border-radius:10px;
}

button{
background:#2952cc;
color:white;
padding:14px 30px;
border:none;
border-radius:12px;
font-size:18px;
cursor:pointer;
font-weight:bold;
}

button:hover{
background:#1f3fa3;
}

a{
display:block;
margin-top:20px;
text-decoration:none;
font-weight:bold;
color:#1f3fa3;
}
</style>

</head>

<body>

<div class="container">

<%
String type = request.getParameter("type");
if(type == null){
	type = "range";
}
%>

<h1>Select Date Range</h1>

<form action="ReportCriteriaServlet" method="get">

<input type="hidden" name="type" value="<%=type%>">

<input type="date" name="fromDate" required>

<input type="date" name="toDate" required>

<br><br>

<button type="submit">Generate Report</button>

</form>

<a href="reports.jsp">Back</a>

</div>

</body>
</html>