<%@ page import="java.sql.*" %>

<%

String paymentID = "";
String studentName = "";
String amount = "";
String status = "";

String id = request.getParameter("id");

if(id != null){

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
			studentName = rs.getString("StudentName");
			amount = rs.getString("Amount");
			status = rs.getString("Status");

		}else{

			out.println(
			"<script>alert('Record ID does not exist');</script>"
			);

		}

		con.close();

	}catch(Exception e){

		out.println(e);

	}
}

%>

<html>

<head>

<title>Delete Payment</title>

<style>

/* 🌈 BACKGROUND ANIMATION FIXED */
body{
margin:0;
padding:0;
font-family:'Segoe UI', sans-serif;
height:100vh;
display:flex;
justify-content:center;
align-items:center;

background: linear-gradient(135deg,
#0a001a,
#3b0066,
#6a0dad,
#ff2e63,
#ff6b6b
);

background-size: 400% 400%;
animation: bgMove 6s ease infinite;
}

@keyframes bgMove {
0% {background-position: 0% 50%;}
50% {background-position: 100% 50%;}
100% {background-position: 0% 50%;}
}

/* BOX */
.box{
background: rgba(255,255,255,0.9);
width:550px;
padding:40px;
border-radius:25px;
text-align:center;
box-shadow:0 15px 40px rgba(0,0,0,0.4);
backdrop-filter: blur(15px);
border:1px solid rgba(255,255,255,0.3);
}

/* TITLE */
h1{
color:#ff2e63;
font-size:45px;
margin-bottom:30px;
}

/* INPUT */
input{
width:100%;
padding:15px;
margin:12px 0;
border-radius:12px;
border:1px solid #ccc;
font-size:17px;
transition:0.3s;
}

input:focus{
border-color:#ff2e63;
box-shadow:0 0 10px rgba(255,46,99,0.4);
outline:none;
}

/* BUTTONS */
.fetchbtn{
background: linear-gradient(135deg,#6a0dad,#ff2e63);
color:white;
padding:14px 30px;
border:none;
border-radius:12px;
font-size:18px;
font-weight:bold;
cursor:pointer;
transition:0.3s;
}

.fetchbtn:hover{
transform:scale(1.05);
}

.deletebtn{
background: linear-gradient(135deg,#ff2e63,#d00000);
color:white;
padding:15px 35px;
border:none;
border-radius:12px;
font-size:18px;
font-weight:bold;
cursor:pointer;
margin-top:20px;
transition:0.3s;
}

.deletebtn:hover{
transform:scale(1.05);
}

/* DETAILS BOX */
.details{
background: #fff;
padding:20px;
border-radius:15px;
margin-top:20px;
text-align:left;
font-size:18px;
line-height:38px;
box-shadow:0 5px 15px rgba(0,0,0,0.1);
border-left:5px solid #6a0dad;
}

/* WARNING */
.warning{
color:#ff2e63;
font-size:20px;
font-weight:bold;
margin-top:25px;
}

/* BACK LINK */
a{
display:block;
margin-top:20px;
text-decoration:none;
font-size:18px;
font-weight:bold;
color:#6a0dad;
transition:0.3s;
}

a:hover{
color:#ff2e63;
}

</style>

</head>

<body>

<div class="box">

<h1>Delete Payment</h1>

<%

if(paymentID.equals("")){

%>

<form method="get" action="feepaymentdelete.jsp">

<input type="number"
name="id"
placeholder="Enter Payment ID"
required>

<button type="submit"
class="fetchbtn">

Delete

</button>

</form>

<%

}

%>

<%

if(!paymentID.equals("")){

%>

<div class="details">

<b>Record ID :</b> <%=paymentID%>

<br>

<b>Student Name :</b> <%=studentName%>

<br>

<b>Amount :</b> Rs. <%=amount%>

<br>

<b>Status :</b> <%=status%>

</div>

<div class="warning">

Are you sure you want to delete this record?

</div>

<form action="DeleteFeePaymentServlet" method="post">

<input type="hidden"
name="paymentID"
value="<%=paymentID%>">

<input type="hidden"
name="studentName"
value="<%=studentName%>">

<button type="submit"
class="deletebtn">

Delete Payment

</button>

</form>

<%

}

%>

<a href="index.jsp">

Back

</a>

</div>

</body>

</html>