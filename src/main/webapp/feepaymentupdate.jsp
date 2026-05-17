<%@ page import="java.sql.*" %>

<%
String id = request.getParameter("id");

String paymentID="";
String studentID="";
String studentName="";
String paymentDate="";
String amount="";
String status="Paid";

try{

Class.forName("com.mysql.cj.jdbc.Driver");

Connection con = DriverManager.getConnection(
"jdbc:mysql://localhost:3306/collegefee",
"root",
"password"
);

PreparedStatement ps =
con.prepareStatement(
"select * from feepayments where PaymentID=?"
);

ps.setInt(1,Integer.parseInt(id));

ResultSet rs = ps.executeQuery();

if(rs.next()){

paymentID = rs.getString("PaymentID");
studentID = rs.getString("StudentID");
studentName = rs.getString("StudentName");
paymentDate = rs.getString("PaymentDate");
amount = rs.getString("Amount");
status = rs.getString("Status");

}

con.close();

}catch(Exception e){

out.println(e);

}
%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Update Payment</title>

<style>

/* 🌌 DARK PROFESSIONAL ANIMATED BACKGROUND */
body{
margin:0;
padding:0;
font-family:'Segoe UI', sans-serif;
height:100vh;
display:flex;
justify-content:center;
align-items:center;

background: linear-gradient(120deg,
#0f0c29,
#302b63,
#24243e
);

background-size: 300% 300%;
animation: bgMove 10s ease infinite;
}

@keyframes bgMove {
0% {background-position: 0% 50%;}
50% {background-position: 100% 50%;}
100% {background-position: 0% 50%;}
}

/* CARD STYLE */
.box{
background: rgba(255,255,255,0.97);
width:540px;
padding:45px;
border-radius:18px;
text-align:center;
box-shadow:0 20px 50px rgba(0,0,0,0.5);
border-top:5px solid #6a11cb;
}

/* TITLE */
h1{
color:#302b63;
margin-bottom:25px;
font-size:40px;
letter-spacing:1px;
}

/* INPUT FIELDS */
input,select{
width:100%;
padding:14px;
margin:10px 0;
border-radius:10px;
border:1px solid #ddd;
font-size:16px;
transition:0.3s;
background:#f9f9f9;
}

input:focus,select:focus{
border-color:#6a11cb;
box-shadow:0 0 8px rgba(106,17,203,0.3);
outline:none;
background:white;
}

/* READONLY BOX */
.idbox{
background:#e8e8e8;
font-weight:bold;
color:#333;
}

/* BUTTON */
button{
background: linear-gradient(135deg,#6a11cb,#2575fc);
color:white;
padding:14px 30px;
border:none;
border-radius:12px;
font-size:18px;
cursor:pointer;
font-weight:bold;
transition:0.3s;
box-shadow:0 8px 20px rgba(0,0,0,0.2);
}

button:hover{
transform:scale(1.05);
}

/* BACK LINK */
a{
display:inline-block;
margin-top:18px;
text-decoration:none;
font-weight:bold;
font-size:17px;
color:#6a11cb;
transition:0.3s;
}

a:hover{
color:#2575fc;
}

/* PLACEHOLDER STYLE */
input::placeholder{
color:#888;
}

</style>

</head>

<body>

<div class="box">

<h1>Update Payment</h1>

<form action="UpdateFeePaymentServlet" method="post">

<input
type="hidden"
name="paymentID"
value="<%=paymentID%>">

<input
type="text"
value="Payment ID : <%=paymentID%>"
class="idbox"
readonly>

<input
type="number"
name="studentID"
value="<%=studentID%>"
placeholder="Student ID"
required>

<input
type="text"
name="studentName"
value="<%=studentName%>"
placeholder="Student Name"
required>

<input
type="date"
name="paymentDate"
value="<%=paymentDate%>"
required>

<input
type="number"
step="0.01"
min="1"
name="amount"
value="<%=amount%>"
placeholder="Amount"
required>

<select name="status">

<option value="Paid"
<%=status.equals("Paid")?"selected":""%>>
Paid
</option>

<option value="Overdue"
<%=status.equals("Overdue")?"selected":""%>>
Overdue
</option>

</select>

<br><br>

<button type="submit">
Update Payment
</button>

</form>

<a href="UpdateListServlet">
Back
</a>

</div>

</body>

</html>