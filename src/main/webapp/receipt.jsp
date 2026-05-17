<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%

String studentID =
request.getParameter("studentID");

String studentName =
request.getParameter("studentName");

String amount =
request.getParameter("amount");

String paymentDate =
request.getParameter("paymentDate");

String status =
request.getParameter("status");

// DATABASE INSERT

try{

Class.forName("com.mysql.cj.jdbc.Driver");

Connection con =
DriverManager.getConnection(

"jdbc:mysql://localhost:3306/collegefee",
"root",
"password"
);

PreparedStatement ps =
con.prepareStatement(

"INSERT INTO feepayments(StudentID,StudentName,PaymentDate,Amount,Status) VALUES(?,?,?,?,?)"
);

ps.setInt(1,Integer.parseInt(studentID));

ps.setString(2,studentName);

ps.setString(3,paymentDate);

ps.setDouble(4,Double.parseDouble(amount));

ps.setString(5,status);

ps.executeUpdate();

con.close();

}catch(Exception e){

out.println(e);
}
%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Payment Receipt</title>

<style>

body{

margin:0;
padding:0;

font-family:Arial;

background:#f4f4f4;

display:flex;
justify-content:center;
align-items:center;

height:100vh;
}

.receipt{

width:450px;

background:white;

padding:35px;

border-radius:20px;

box-shadow:0 0 20px rgba(0,0,0,0.3);
}

h1{

text-align:center;

color:green;
}

.line{

margin:15px 0;

font-size:18px;
}

strong{

color:#333;
}

button{

width:100%;

padding:15px;

margin-top:25px;

background:#4CAF50;

color:white;

border:none;

border-radius:10px;

font-size:18px;

cursor:pointer;
}

button:hover{

background:#388E3C;
}

.back{

display:block;

text-align:center;

margin-top:20px;

text-decoration:none;

font-size:18px;

font-weight:bold;

color:#6a0dad;
}

</style>

<script>

function printReceipt(){

window.print();
}

</script>

</head>

<body>

<div class="receipt">

<h1>Payment Successful</h1>

<hr>

<div class="line">

<strong>Student ID :</strong>

<%=studentID%>

</div>

<div class="line">

<strong>Student Name :</strong>

<%=studentName%>

</div>

<div class="line">

<strong>Amount Paid :</strong>

₹ <%=amount%>

</div>

<div class="line">

<strong>Payment Date :</strong>

<%=paymentDate%>

</div>

<div class="line">

<strong>Status :</strong>

<%=status%>

</div>

<button onclick="printReceipt()">

Print Receipt

</button>

<a href="index.jsp" class="back">

Back To Dashboard

</a>

</div>

</body>

</html>