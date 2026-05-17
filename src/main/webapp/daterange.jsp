<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Date Range Collection</title>

<style>

body{
margin:0;
padding:0;
font-family:Arial;
background:linear-gradient(135deg,#102b72,#2846a3);
height:100vh;
display:flex;
justify-content:center;
align-items:center;
}

.container{
background:#f2f2f2;
width:500px;
padding:45px;
border-radius:25px;
text-align:center;
box-shadow:0 0 25px rgba(0,0,0,0.3);
}

h1{
color:#1f3fa3;
font-size:50px;
margin-bottom:35px;
}

label{
display:block;
text-align:left;
font-size:20px;
font-weight:bold;
margin-top:15px;
margin-bottom:8px;
color:#102b72;
}

input{
width:100%;
padding:15px;
font-size:18px;
border-radius:10px;
border:1px solid #ccc;
box-sizing:border-box;
}

button{
margin-top:30px;
width:100%;
padding:16px;
font-size:22px;
font-weight:bold;
border:none;
border-radius:12px;
background:#2d56d3;
color:white;
cursor:pointer;
transition:0.3s;
}

button:hover{
background:#1f3fa3;
}

a{
display:inline-block;
margin-top:25px;
text-decoration:none;
font-size:20px;
font-weight:bold;
color:#102b72;
}

</style>

</head>

<body>

<div class="container">

<h1>Date Range Collection</h1>

<form action="ReportServlet" method="get">

<input type="hidden" name="type" value="range">

<label>From Date</label>
<input type="date" name="fromDate" required>

<label>To Date</label>
<input type="date" name="toDate" required>

<button type="submit">
Generate Report
</button>

</form>

<a href="reports.jsp">Back</a>

</div>

</body>
</html>