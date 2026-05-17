package servlet;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/UpdateListServlet")
public class UpdatedListServlet extends HttpServlet {

protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {

response.setContentType("text/html");
PrintWriter out = response.getWriter();

try {

Class.forName("com.mysql.cj.jdbc.Driver");

Connection con = DriverManager.getConnection(
"jdbc:mysql://localhost:3306/collegefee",
"root",
"password"
);

Statement st = con.createStatement();

ResultSet rs = st.executeQuery("select * from feepayments");

out.println("<html>");
out.println("<head>");
out.println("<title>Update Records</title>");

out.println("<style>");

out.println("body{");
out.println("margin:0;");
out.println("font-family:Arial;");
out.println("background:linear-gradient(135deg,#102b72,#1e3c8f);");
out.println("color:white;");
out.println("}");

out.println(".container{");
out.println("width:90%;");
out.println("margin:auto;");
out.println("padding:40px;");
out.println("}");

out.println("h1{");
out.println("text-align:center;");
out.println("margin-bottom:30px;");
out.println("font-size:45px;");
out.println("}");

out.println("table{");
out.println("width:100%;");
out.println("border-collapse:collapse;");
out.println("background:white;");
out.println("color:black;");
out.println("border-radius:15px;");
out.println("overflow:hidden;");
out.println("box-shadow:0 10px 30px rgba(0,0,0,0.2);");
out.println("}");

out.println("th{");
out.println("background:#2d56d3;");
out.println("color:white;");
out.println("padding:15px;");
out.println("font-size:20px;");
out.println("}");

out.println("td{");
out.println("padding:14px;");
out.println("text-align:center;");
out.println("border-bottom:1px solid #ddd;");
out.println("font-size:18px;");
out.println("}");

out.println("tr:hover{");
out.println("background:#f2f6ff;");
out.println("}");

out.println(".btn{");
out.println("background:#28a745;");
out.println("color:white;");
out.println("padding:10px 18px;");
out.println("text-decoration:none;");
out.println("border-radius:8px;");
out.println("font-weight:bold;");
out.println("}");

out.println(".btn:hover{");
out.println("background:#1e7e34;");
out.println("}");

out.println(".home{");
out.println("display:inline-block;");
out.println("margin-top:25px;");
out.println("background:#ff9800;");
out.println("color:white;");
out.println("padding:12px 25px;");
out.println("text-decoration:none;");
out.println("border-radius:10px;");
out.println("font-size:18px;");
out.println("}");

out.println(".home:hover{");
out.println("background:#e68900;");
out.println("}");

out.println("</style>");
out.println("</head>");

out.println("<body>");
out.println("<div class='container'>");

out.println("<h1>Select Record to Update</h1>");

out.println("<table>");
out.println("<tr>");
out.println("<th>ID</th>");
out.println("<th>Name</th>");
out.println("<th>Amount</th>");
out.println("<th>Status</th>");
out.println("<th>Action</th>");
out.println("</tr>");

while(rs.next()) {

out.println("<tr>");

out.println("<td>"+rs.getInt("PaymentID")+"</td>");
out.println("<td>"+rs.getString("StudentName")+"</td>");
out.println("<td>&#8377;  "+rs.getDouble("Amount")+"</td>");
out.println("<td>"+rs.getString("Status")+"</td>");

out.println("<td>");
out.println("<a class='btn' href='feepaymentupdate.jsp?id="
+rs.getInt("PaymentID")+"'>Update</a>");
out.println("</td>");

out.println("</tr>");
}

out.println("</table>");

out.println("<center>");
out.println("<a class='home' href='index.jsp'>Home</a>");
out.println("</center>");

out.println("</div>");
out.println("</body>");
out.println("</html>");

con.close();

} catch(Exception e) {
out.println(e);
}

}
}