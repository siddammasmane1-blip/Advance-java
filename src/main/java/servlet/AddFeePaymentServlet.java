package servlet;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import dao.FeePaymentDAO;
import model.FeePayment;

@WebServlet("/AddFeePaymentServlet")
public class AddFeePaymentServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int studentID = Integer.parseInt(request.getParameter("studentID"));
		String studentName = request.getParameter("studentName");
		String paymentDate = request.getParameter("paymentDate");
		double amount = Double.parseDouble(request.getParameter("amount"));
		String status = request.getParameter("status");

		FeePayment f = new FeePayment();

		f.setStudentID(studentID);
		f.setStudentName(studentName);
		f.setPaymentDate(paymentDate);
		f.setAmount(amount);
		f.setStatus(status);

		FeePaymentDAO dao = new FeePaymentDAO();
		dao.addPayment(f);

		response.getWriter().println(
		"<html><body style='margin:0;font-family:Arial;background:#102b72;color:white;text-align:center;padding-top:120px;'>" +

		"<div style='background:white;color:black;width:500px;margin:auto;padding:40px;border-radius:20px;box-shadow:0 0 20px rgba(0,0,0,0.3);'>" +

		"<h1 style='color:green;'>Payment Added Successfully</h1><hr>" +

		"<h3>Payment Details</h3>" +

		"<p><b>Student ID:</b> " + studentID + "</p>" +
		"<p><b>Student Name:</b> " + studentName + "</p>" +
		"<p><b>Payment Date:</b> " + paymentDate + "</p>" +
		"<p><b>Amount:</b> ₹" + amount + "</p>" +
		"<p><b>Status:</b> " + status + "</p>" +

		"<br><a href='index.jsp' style='text-decoration:none;background:#2952cc;color:white;padding:12px 25px;border-radius:10px;font-weight:bold;'>Home</a>" +

		"</div></body></html>");
	}
}