package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateFeePaymentServlet")

public class UpdatedFeePaymentServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request,
	HttpServletResponse response)

	throws ServletException, IOException {

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		int paymentID =
		Integer.parseInt(request.getParameter("paymentID"));

		int studentID =
		Integer.parseInt(request.getParameter("studentID"));

		String newName =
		request.getParameter("studentName");

		String paymentDate =
		request.getParameter("paymentDate");

		double newAmount =
		Double.parseDouble(request.getParameter("amount"));

		String status =
		request.getParameter("status");

		String oldName = "";

		double oldAmount = 0;

		try{

			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection(

			"jdbc:mysql://localhost:3306/collegefee",

			"root",

			"password"

			);

			PreparedStatement oldps =
			con.prepareStatement(

			"select * from feepayments where PaymentID=?"

			);

			oldps.setInt(1,paymentID);

			ResultSet rs = oldps.executeQuery();

			if(rs.next()){

				oldName = rs.getString("StudentName");

				oldAmount = rs.getDouble("Amount");

			}

			PreparedStatement ps =
			con.prepareStatement(

			"update feepayments set StudentID=?, StudentName=?, PaymentDate=?, Amount=?, Status=? where PaymentID=?"

			);

			ps.setInt(1,studentID);

			ps.setString(2,newName);

			ps.setString(3,paymentDate);

			ps.setDouble(4,newAmount);

			ps.setString(5,status);

			ps.setInt(6,paymentID);

			ps.executeUpdate();

			out.println("<html>");

			out.println("<head>");

			out.println("<title>Updated</title>");

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
			out.println("padding:50px;");
			out.println("width:500px;");
			out.println("border-radius:20px;");
			out.println("text-align:center;");
			out.println("}");

			out.println("h1{");
			out.println("color:green;");
			out.println("font-size:50px;");
			out.println("}");

			out.println("h2{");
			out.println("margin:15px;");
			out.println("}");

			out.println("a{");
			out.println("text-decoration:none;");
			out.println("background:#2d56d3;");
			out.println("color:white;");
			out.println("padding:15px 30px;");
			out.println("border-radius:10px;");
			out.println("font-size:18px;");
			out.println("}");

			out.println("</style>");

			out.println("</head>");

			out.println("<body>");

			out.println("<div class='box'>");

			out.println("<h1>Updated Successfully</h1>");

			out.println("<h2>Record ID : "
			+ paymentID +
			"</h2>");

			out.println("<h2>Name Updated</h2>");

			out.println("<h2>"
			+ oldName +
			" to "
			+ newName +
			"</h2>");

			out.println("<h2>Amount Updated</h2>");

			out.println("<h2>Rs."
			+ oldAmount +
			" to Rs."
			+ newAmount +
			"</h2>");

			out.println("<br><br>");

			out.println("<a href='UpdateListServlet'>Back</a>");

			out.println("</div>");

			out.println("</body>");

			out.println("</html>");

			con.close();

		}

		catch(Exception e){

			out.println(e);

		}

	}

}