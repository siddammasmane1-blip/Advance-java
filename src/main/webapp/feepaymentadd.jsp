<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%
// ================= AJAX BACKEND (same page) =================
String ajaxID = request.getParameter("studentID_ajax");

if(ajaxID != null){

String result = "Not exist";

try{

Class.forName("com.mysql.cj.jdbc.Driver");

Connection con = DriverManager.getConnection(
"jdbc:mysql://localhost:3306/collegefee",
"root",
"password"
);

PreparedStatement ps = con.prepareStatement(
"SELECT StudentName FROM feepayments WHERE StudentID=?"
);

ps.setInt(1, Integer.parseInt(ajaxID));

ResultSet rs = ps.executeQuery();

if(rs.next()){
result = rs.getString("StudentName");
}

con.close();

}catch(Exception e){
result = "Not exist";
}

out.print(result);
return;
}

// ================= PAYMENT ID GENERATION =================
int nextID = 1;

try{

Class.forName("com.mysql.cj.jdbc.Driver");

Connection con = DriverManager.getConnection(
"jdbc:mysql://localhost:3306/collegefee",
"root",
"password"
);

Statement st = con.createStatement();

ResultSet rs = st.executeQuery(
"SELECT MAX(PaymentID)+1 FROM feepayments"
);

if(rs.next()){

nextID = rs.getInt(1);
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

<title>Add Payment</title>

<style>

body{
margin:0;
padding:0;
font-family:Arial,sans-serif;
height:100vh;
display:flex;
justify-content:center;
align-items:center;
overflow:hidden;

background: linear-gradient(
120deg,
#0f0c29,
#302b63,
#24243e,
#ff2e63,
#6a0dad
);

background-size: 400% 400%;

animation: bgMove 10s ease infinite;
}

@keyframes bgMove {

0% {
background-position: 0% 50%;
}

50% {
background-position: 100% 50%;
}

100% {
background-position: 0% 50%;
}
}

.container{

background: rgba(255,255,255,0.92);

width:520px;

padding:40px;

border-radius:25px;

box-shadow:0 0 30px rgba(0,0,0,0.4);

text-align:center;
}

h1{

color:#6a0dad;

font-size:50px;
}

input,
select{

width:100%;

padding:16px;

margin:12px 0;

font-size:17px;

border-radius:12px;

border:1px solid #ccc;

box-sizing:border-box;
}

.readonly{

background:#ececec;

font-weight:bold;
}

button{

background: linear-gradient(
135deg,
#6a0dad,
#ff4ecd
);

color:white;

padding:15px 35px;

border:none;

border-radius:12px;

font-size:20px;

cursor:pointer;
}

button:hover{

opacity:0.9;
}

a{

display:block;

margin-top:25px;

text-decoration:none;

font-size:20px;

font-weight:bold;

color:#6a0dad;
}

</style>

<script>

function fetchName(){

var sid =
document.getElementById("studentID").value;

if(sid === ""){

document.getElementById("studentName").value="";

return;
}

var xhttp = new XMLHttpRequest();

xhttp.onreadystatechange = function(){

if(this.readyState == 4 && this.status == 200){

let name = this.responseText.trim();

if(name === "Not exist"){

document.getElementById("studentName").value = "";

document.getElementById("studentName").placeholder =
"Student Not Found";

}else{

document.getElementById("studentName").value = name;
}
}
};

xhttp.open(

"GET",

"feepaymentadd.jsp?studentID_ajax="
+sid+
"&t="+new Date().getTime(),

true
);

xhttp.send();
}

</script>

</head>

<body>

<div class="container">

<h1>Add Payment</h1>

<form action="paymentscanner.jsp" method="post">

<input type="text"
value="Payment ID : <%=nextID%>"
class="readonly"
readonly>

<!-- STUDENT ID -->

<div style="text-align:left;font-weight:bold;margin-top:10px;">

Student ID

</div>

<input type="number"
name="studentID"
id="studentID"
placeholder="Enter Student ID"
required
oninput="fetchName()">

<!-- STUDENT NAME -->

<div style="text-align:left;font-weight:bold;margin-top:10px;">

Student Name

</div>

<input type="text"
name="studentName"
id="studentName"
placeholder="Enter the student name"
required>

<!-- AMOUNT -->

<div style="text-align:left;font-weight:bold;margin-top:10px;">

Amount

</div>

<input type="number"
step="0.01"
name="amount"
placeholder="Enter Amount"
required>

<!-- PAYMENT DATE -->

<input type="hidden"
name="paymentDate"
value="<%= new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()) %>">

<!-- STATUS -->

<div style="text-align:left;font-weight:bold;margin-top:10px;">

Status

</div>

<select name="status">

<option value="Paid">

Paid

</option>

<option value="Overdue">

Overdue

</option>

</select>

<button type="submit">

Add Payment

</button>

</form>

<a href="index.jsp">

Back

</a>

</div>

</body>

</html>