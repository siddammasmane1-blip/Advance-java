<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Reports</title>

<style>

body{
margin:0;
padding:0;
font-family:Arial,sans-serif;

background:linear-gradient(
135deg,
#0f2027,
#203a43,
#2c5364
);

height:100vh;

display:flex;
justify-content:center;
align-items:center;
}

/* MAIN BOX */

.container{

background:rgba(255,255,255,0.95);

width:550px;

padding:50px;

border-radius:30px;

text-align:center;

box-shadow:0 0 35px rgba(0,0,0,0.4);

backdrop-filter:blur(8px);
}

/* TITLE */

h1{

color:#6a11cb;

font-size:65px;

margin-bottom:40px;

text-shadow:2px 2px 8px rgba(0,0,0,0.2);
}

/* BUTTON COMMON */

.btn{

display:block;

width:100%;

padding:18px;

margin:18px 0;

font-size:22px;

font-weight:bold;

border:none;

border-radius:18px;

cursor:pointer;

text-decoration:none;

color:white;

transition:0.4s;

box-sizing:border-box;

letter-spacing:1px;
}

/* OVERDUE BUTTON */

a[href*="overdue"]{

background:linear-gradient(
135deg,
#ff416c,
#ff4b2b
);
}

a[href*="overdue"]:hover{

transform:scale(1.05);

box-shadow:0 0 20px rgba(255,75,43,0.6);
}

/* DATE RANGE BUTTON */

a[href="daterange.jsp"]{

background:linear-gradient(
135deg,
#11998e,
#38ef7d
);
}

a[href="daterange.jsp"]:hover{

transform:scale(1.05);

box-shadow:0 0 20px rgba(56,239,125,0.6);
}

/* PAID BUTTON */

a[href*="paid"]{

background:linear-gradient(
135deg,
#396afc,
#2948ff
);
}

a[href*="paid"]:hover{

transform:scale(1.05);

box-shadow:0 0 20px rgba(41,72,255,0.6);
}

/* HOME BUTTON */

.home{

background:linear-gradient(
135deg,
#f7971e,
#ffd200
);

color:#333;
}

.home:hover{

transform:scale(1.05);

box-shadow:0 0 20px rgba(255,210,0,0.6);
}

</style>

</head>

<body>

<div class="container">

<h1>Reports</h1>

<a href="ReportServlet?type=overdue" class="btn">
Overdue Students
</a>

<a href="daterange.jsp" class="btn">
Date Range Collection
</a>

<a href="ReportServlet?type=paid" class="btn">
Paid Students
</a>

<a href="index.jsp" class="btn home">
Home
</a>

</div>

</body>

</html>