package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/DeleteFeePaymentServlet")

public class DeleteFeePaymentServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		try {

			int paymentID =
			Integer.parseInt(
			request.getParameter("paymentID"));

			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/collegefee",
					"root",
					"password");

			// ===== GET RECORD DETAILS BEFORE DELETE =====

			PreparedStatement getps =
			con.prepareStatement(
			"select StudentName,Amount from feepayments where PaymentID=?"
			);

			getps.setInt(1,paymentID);

			ResultSet rs = getps.executeQuery();

			String studentName="";
			double amount=0;

			if(rs.next()){

				studentName = rs.getString("StudentName");
				amount = rs.getDouble("Amount");

			}

			// ===== DELETE RECORD =====

			PreparedStatement ps =
			con.prepareStatement(
			"delete from feepayments where PaymentID=?"
			);

			ps.setInt(1,paymentID);

			ps.executeUpdate();

			// ===== SUCCESS PAGE =====

			out.println("<html>");

			out.println("<head>");

			out.println("<style>");

			out.println("body{");
			out.println("margin:0;");
			out.println("font-family:Arial;");
			out.println("background:linear-gradient(135deg,#102b72,#1e3c8f);");
			out.println("display:flex;");
			out.println("justify-content:center;");
			out.println("align-items:center;");
			out.println("height:100vh;");
			out.println("}");

			out.println(".card{");
			out.println("background:white;");
			out.println("padding:40px;");
			out.println("width:500px;");
			out.println("border-radius:20px;");
			out.println("text-align:center;");
			out.println("box-shadow:0 10px 25px rgba(0,0,0,0.3);");
			out.println("}");

			out.println("h1{");
			out.println("color:#d62828;");
			out.println("margin-bottom:25px;");
			out.println("}");

			out.println("p{");
			out.println("font-size:20px;");
			out.println("line-height:35px;");
			out.println("}");

			out.println("a{");
			out.println("display:inline-block;");
			out.println("margin-top:20px;");
			out.println("background:#2952cc;");
			out.println("color:white;");
			out.println("padding:14px 30px;");
			out.println("border-radius:12px;");
			out.println("text-decoration:none;");
			out.println("font-weight:bold;");
			out.println("}");

			out.println("</style>");

			out.println("</head>");

			out.println("<body>");

			out.println("<div class='card'>");

			out.println("<h1>Payment Deleted Successfully</h1>");

			out.println("<p>");

			out.println("Deleted Record<br><br>");

			out.println("Payment ID : <b>"+paymentID+"</b><br><br>");

			out.println("Student Name : <b>"+studentName+"</b><br><br>");

			out.println("Amount : <b>&#8377; "+amount+"</b>");

			out.println("</p>");

			out.println("<a href='index.jsp'>Home</a>");

			out.println("</div>");

			out.println("</body>");

			out.println("</html>");

			con.close();

		} catch(Exception e) {

			out.println(e);

		}
	}
}