<%@ page import="java.sql.*" %>

<%
String sid = request.getParameter("studentID");

String result = "";

try {

Class.forName("com.mysql.cj.jdbc.Driver");

Connection con = DriverManager.getConnection(
"jdbc:mysql://localhost:3306/collegefee",
"root",
"password"
);

PreparedStatement ps = con.prepareStatement(
"SELECT StudentName FROM feepayments WHERE StudentID=?"
);

ps.setInt(1, Integer.parseInt(sid));

ResultSet rs = ps.executeQuery();

if(rs.next()){
result = rs.getString("StudentName");
}else{
result = "Not exist";
}

con.close();

}catch(Exception e){
result = "Not exist";
}

out.print(result);
%>