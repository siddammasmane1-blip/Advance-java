<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Scan & Pay</title>

<style>

body{
margin:0;
padding:0;
font-family:Arial;

display:flex;
justify-content:center;
align-items:center;

height:100vh;

background:linear-gradient(
135deg,
#141e30,
#243b55
);
}

.container{

background:white;

padding:40px;

border-radius:20px;

text-align:center;

width:420px;

box-shadow:0 0 25px rgba(0,0,0,0.4);
}

h1{
color:#6a0dad;
}

p{

font-size:18px;

color:#444;
}

img{

width:250px;
height:250px;

margin:20px 0;

border-radius:10px;

border:3px solid #6a0dad;
}

button{

padding:15px 30px;

background:#4CAF50;

color:white;

border:none;

border-radius:10px;

font-size:18px;

cursor:pointer;

transition:0.3s;
}

button:hover{

background:#388E3C;

transform:scale(1.05);
}

</style>

</head>

<body>

<div class="container">

<h1>Scan & Pay</h1>

<p>
Scan this QR using PhonePe / GPay / Paytm
</p>

<img src="image/qr.png">

<form action="receipt.jsp" method="post">

<input type="hidden"
name="studentID"
value="<%=request.getParameter("studentID")%>">

<input type="hidden"
name="studentName"
value="<%=request.getParameter("studentName")%>">

<input type="hidden"
name="amount"
value="<%=request.getParameter("amount")%>">

<input type="hidden"
name="paymentDate"
value="<%=request.getParameter("paymentDate")%>">

<input type="hidden"
name="status"
value="Paid">

<button type="submit">

Payment Done

</button>

</form>

</div>

</body>

</html>