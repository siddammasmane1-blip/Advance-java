<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>College Fee System</title>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">

<style>

/* RESET */
body{
margin:0;
font-family:'Segoe UI', sans-serif;
background:#f4f6ff;
}

/* SIDEBAR */
.sidebar{
width:250px;
height:100vh;
background:linear-gradient(180deg,#6a11cb,#ff4ecd);
position:fixed;
left:0;
top:0;
color:white;
padding-top:30px;
}

.sidebar h2{
text-align:center;
margin-bottom:40px;
font-size:22px;
}

.sidebar a{
display:block;
padding:15px 25px;
color:white;
text-decoration:none;
font-size:16px;
transition:0.3s;
}

.sidebar a:hover{
background:rgba(255,255,255,0.2);
padding-left:35px;
}

/* MAIN AREA */
.main{
margin-left:250px;
padding:30px;
}

/* HEADER */
.header{
background:white;
padding:20px;
border-radius:15px;
box-shadow:0 5px 15px rgba(0,0,0,0.1);
margin-bottom:25px;
}

.header h1{
margin:0;
color:#333;
}

/* DASHBOARD CARDS */
.cards{
display:grid;
grid-template-columns:repeat(3,1fr);
gap:20px;
}

.card{
background:white;
padding:25px;
border-radius:15px;
box-shadow:0 5px 15px rgba(0,0,0,0.08);
transition:0.3s;
text-align:center;
}

.card:hover{
transform:translateY(-6px);
box-shadow:0 10px 25px rgba(0,0,0,0.15);
}

.card i{
font-size:32px;
margin-bottom:10px;
color:#6a11cb;
}

/* BUTTON */
.card a{
display:inline-block;
margin-top:10px;
padding:10px 18px;
border-radius:10px;
background:linear-gradient(135deg,#6a11cb,#ff4ecd);
color:white;
text-decoration:none;
font-size:14px;
transition:0.3s;
}

.card a:hover{
opacity:0.9;
transform:scale(1.05);
}

p{
color:#666;
font-size:13px;
}

</style>
</head>

<body>

<!-- SIDEBAR -->
<div class="sidebar">
<h2>💳 Fee System</h2>

<a href="index.jsp"><i class="fa fa-house"></i> Dashboard</a>
<a href="feepaymentadd.jsp"><i class="fa fa-circle-plus"></i> Add Fee</a>
<a href="DisplayFeePaymentsServlet"><i class="fa fa-table-list"></i> View Records</a>
<a href="UpdateListServlet"><i class="fa fa-pen-to-square"></i> Update Fee</a>
<a href="feepaymentdelete.jsp"><i class="fa fa-trash-can"></i> Delete Fee</a>
<a href="reports.jsp"><i class="fa fa-chart-line"></i> Reports</a>

</div>

<!-- MAIN -->
<div class="main">

<div class="header">
<h1>College Fee System</h1>
</div>

<div class="cards">

<div class="card">
<i class="fa fa-circle-plus"></i>
<h3>Add Fee</h3>
<p>Insert new payment details</p>
<a href="feepaymentadd.jsp">Open</a>
</div>

<div class="card">
<i class="fa fa-eye"></i>
<h3>View Records</h3>
<p>Check all payments</p>
<a href="DisplayFeePaymentsServlet">Open</a>
</div>

<div class="card">
<i class="fa fa-pen-to-square"></i>
<h3>Update Fee</h3>
<p>Edit existing records</p>
<a href="UpdateListServlet">Open</a>
</div>

<div class="card">
<i class="fa fa-trash-can"></i>
<h3>Delete Fee</h3>
<p>Remove incorrect entries</p>
<a href="feepaymentdelete.jsp">Open</a>
</div>

<div class="card">
<i class="fa fa-file-lines"></i>
<h3>Reports</h3>
<p>Analytics & summary</p>
<a href="reports.jsp">Open</a>
</div>

</div>

</div>

</body>
</html>