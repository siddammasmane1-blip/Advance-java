package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@SuppressWarnings("serial")
@WebServlet("/DisplayFeePaymentsServlet")
public class DisplayFeePaymentServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		out.println("<html><body style='margin:0;font-family:Arial;background:#102b72;color:white;padding:40px;'>");

		out.println("<h1 style='text-align:center;'>All Fee Payments</h1>");

		out.println("<table border='1' cellpadding='10' cellspacing='0' style='margin:auto;background:white;color:black;border-collapse:collapse;width:90%;'>");

		out.println("<tr style='background:#2952cc;color:white;'>");

		out.println("<th>Payment ID</th>");
		out.println("<th>Student ID</th>");
		out.println("<th>Name</th>");
		out.println("<th>Date</th>");
		out.println("<th>Amount</th>");
		out.println("<th>Status</th>");

		out.println("</tr>");

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/collegefee",
			"root",
			"password");

			Statement st = con.createStatement();

			ResultSet rs =
			st.executeQuery("SELECT * FROM feepayments");

			while(rs.next()) {

				out.println("<tr>");

				out.println("<td>"+rs.getInt("PaymentID")+"</td>");

				out.println("<td>"+rs.getInt("StudentID")+"</td>");

				out.println("<td>"+rs.getString("StudentName")+"</td>");

				out.println("<td>"+rs.getString("PaymentDate")+"</td>");

				out.println("<td>"+rs.getDouble("Amount")+"</td>");

				out.println("<td>"+rs.getString("Status")+"</td>");

				out.println("</tr>");
			}

			con.close();

		} catch(Exception e) {

			out.println("<tr><td colspan='6'>"+e+"</td></tr>");
		}

		out.println("</table>");

		out.println("<div style='text-align:center;margin-top:30px;'>");

		out.println("<a href='index.jsp' style='text-decoration:none;background:white;color:#2952cc;padding:14px 30px;border-radius:12px;font-weight:bold;'>Home</a>");

		out.println("</div>");

		out.println("</body></html>");
	}
}