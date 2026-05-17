package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@SuppressWarnings("serial")
@WebServlet("/ReportServlet")
public class ReportServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String type = request.getParameter("type");

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/collegefee",
					"root",
					"password");

			// ================= OVERDUE REPORT =================
			if ("overdue".equals(type)) {

				PreparedStatement ps = con.prepareStatement(
						"SELECT * FROM feepayments WHERE Status='Overdue'");

				ResultSet rs = ps.executeQuery();

				out.println("<html>");
				out.println("<head>");
				out.println("<title>Overdue Report</title>");

				out.println("<style>");
				out.println("body{margin:0;font-family:Arial;background:#102b72;padding:40px;color:white;}");
				out.println("h1{text-align:center;margin-bottom:30px;}");
				out.println("table{width:100%;border-collapse:collapse;background:white;color:black;border-radius:10px;overflow:hidden;}");
				out.println("th{background:#d62828;color:white;padding:15px;}");
				out.println("td{padding:12px;text-align:center;border-bottom:1px solid #ccc;}");
				out.println("tr:hover{background:#f2f2f2;}");
				out.println(".btn{display:inline-block;margin-top:25px;background:#2952cc;color:white;padding:12px 25px;text-decoration:none;border-radius:10px;font-weight:bold;}");
				out.println("</style>");

				out.println("</head>");
				out.println("<body>");

				out.println("<h1>Overdue Students Report</h1>");

				out.println("<table>");

				out.println("<tr>");
				out.println("<th>ID</th>");
				out.println("<th>Name</th>");
				out.println("<th>Date</th>");
				out.println("<th>Amount</th>");
				out.println("<th>Status</th>");
				out.println("</tr>");

				while(rs.next()) {

					out.println("<tr>");
					out.println("<td>"+rs.getInt("PaymentID")+"</td>");
					out.println("<td>"+rs.getString("StudentName")+"</td>");
					out.println("<td>"+rs.getString("PaymentDate")+"</td>");
					out.println("<td>Rs. "+rs.getDouble("Amount")+"</td>");
					out.println("<td>"+rs.getString("Status")+"</td>");
					out.println("</tr>");
				}

				out.println("</table>");

				out.println("<center>");
				out.println("<a class='btn' href='reports.jsp'>Back</a>");
				out.println("</center>");

				out.println("</body>");
				out.println("</html>");
			}

			// ================= PAID REPORT =================
			else if ("paid".equals(type)) {

				PreparedStatement ps = con.prepareStatement(
						"SELECT * FROM feepayments WHERE Status='Paid'");

				ResultSet rs = ps.executeQuery();

				out.println("<html>");
				out.println("<head>");
				out.println("<title>Paid Students Report</title>");

				out.println("<style>");
				out.println("body{margin:0;font-family:Arial;background:#102b72;padding:40px;color:white;}");
				out.println("h1{text-align:center;margin-bottom:30px;}");
				out.println("table{width:100%;border-collapse:collapse;background:white;color:black;border-radius:10px;overflow:hidden;}");
				out.println("th{background:#28a745;color:white;padding:15px;}");
				out.println("td{padding:12px;text-align:center;border-bottom:1px solid #ccc;}");
				out.println("tr:hover{background:#f2f2f2;}");
				out.println(".btn{display:inline-block;margin-top:25px;background:#2952cc;color:white;padding:12px 25px;text-decoration:none;border-radius:10px;font-weight:bold;}");
				out.println("</style>");

				out.println("</head>");
				out.println("<body>");

				out.println("<h1>Paid Students Report</h1>");

				out.println("<table>");

				out.println("<tr>");
				out.println("<th>ID</th>");
				out.println("<th>Name</th>");
				out.println("<th>Date</th>");
				out.println("<th>Amount</th>");
				out.println("<th>Status</th>");
				out.println("</tr>");

				while(rs.next()) {

					out.println("<tr>");
					out.println("<td>"+rs.getInt("PaymentID")+"</td>");
					out.println("<td>"+rs.getString("StudentName")+"</td>");
					out.println("<td>"+rs.getString("PaymentDate")+"</td>");
					out.println("<td>Rs. "+rs.getDouble("Amount")+"</td>");
					out.println("<td>"+rs.getString("Status")+"</td>");
					out.println("</tr>");
				}

				out.println("</table>");

				out.println("<center>");
				out.println("<a class='btn' href='reports.jsp'>Back</a>");
				out.println("</center>");

				out.println("</body>");
				out.println("</html>");
			}

			// ================= DATE RANGE REPORT =================
			else if ("range".equals(type)) {

				String fromDate = request.getParameter("fromDate");
				String toDate = request.getParameter("toDate");

				PreparedStatement ps = con.prepareStatement(
						"SELECT SUM(Amount) FROM feepayments WHERE PaymentDate BETWEEN ? AND ?");

				ps.setString(1, fromDate);
				ps.setString(2, toDate);

				ResultSet rs = ps.executeQuery();

				double total = 0;

				if(rs.next()) {
					total = rs.getDouble(1);
				}

				out.println("<html>");
				out.println("<head>");
				out.println("<title>Collection Report</title>");

				out.println("<style>");

				out.println("body{");
				out.println("margin:0;");
				out.println("font-family:Arial;");
				out.println("background:#102b72;");
				out.println("display:flex;");
				out.println("justify-content:center;");
				out.println("align-items:center;");
				out.println("height:100vh;");
				out.println("}");

				out.println(".box{");
				out.println("background:#f2f2f2;");
				out.println("width:500px;");
				out.println("padding:50px;");
				out.println("border-radius:20px;");
				out.println("text-align:center;");
				out.println("box-shadow:0 0 20px rgba(0,0,0,0.3);");
				out.println("}");

				out.println("h1{");
				out.println("color:#102b72;");
				out.println("margin-bottom:25px;");
				out.println("font-size:50px;");
				out.println("}");

				out.println("h2{");
				out.println("font-size:28px;");
				out.println("margin-bottom:15px;");
				out.println("}");

				out.println(".amount{");
				out.println("font-size:55px;");
				out.println("font-weight:bold;");
				out.println("color:green;");
				out.println("margin:25px 0;");
				out.println("}");

				out.println(".date{");
				out.println("font-size:22px;");
				out.println("margin:15px 0;");
				out.println("}");

				out.println(".btn{");
				out.println("display:inline-block;");
				out.println("margin-top:25px;");
				out.println("padding:14px 30px;");
				out.println("background:#2d56d3;");
				out.println("color:white;");
				out.println("text-decoration:none;");
				out.println("border-radius:12px;");
				out.println("font-size:20px;");
				out.println("font-weight:bold;");
				out.println("}");

				out.println("</style>");
				out.println("</head>");

				out.println("<body>");

				out.println("<div class='box'>");

				out.println("<h1>Collection Report</h1>");

				out.println("<h2>Total Collection</h2>");

				out.println("<div class='amount'>Rs. " + total + "</div>");

				out.println("<div class='date'>");
				out.println("From : <b>" + fromDate + "</b>");
				out.println("</div>");

				out.println("<div class='date'>");
				out.println("To : <b>" + toDate + "</b>");
				out.println("</div>");

				out.println("<a href='reports.jsp' class='btn'>Back</a>");

				out.println("</div>");

				out.println("</body>");
				out.println("</html>");
			}

			con.close();

		} catch (Exception e) {
			out.println(e);
		}
	}
}