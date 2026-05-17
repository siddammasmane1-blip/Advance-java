package dao;

import java.sql.*;

import model.FeePayment;


public class FeePaymentDAO {

	Connection con;

	public FeePaymentDAO() {

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/collegefee",
					"root",
					"password");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 🔥 CHECK DUPLICATE STUDENT ID
	public boolean isStudentExists(int studentID) {

		try {

			PreparedStatement ps = con.prepareStatement(
				"SELECT 1 FROM feepayments WHERE StudentID=?"
			);

			ps.setInt(1, studentID);

			ResultSet rs = ps.executeQuery();

			return rs.next();

		} catch(Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	// ADD
	public boolean addPayment(FeePayment f) {

		try {

			// ❌ DUPLICATE CHECK
			if(isStudentExists(f.getStudentID())) {
				return false;
			}

			PreparedStatement ps = con.prepareStatement(
			"INSERT INTO feepayments(StudentID, StudentName, PaymentDate, Amount, Status) VALUES(?,?,?,?,?)");

			ps.setInt(1, f.getStudentID());
			ps.setString(2, f.getStudentName());
			ps.setString(3, f.getPaymentDate());
			ps.setDouble(4, f.getAmount());
			ps.setString(5, f.getStatus());

			ps.executeUpdate();

			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	// UPDATE
	public void updatePayment(FeePayment f) {

		try {

			PreparedStatement ps = con.prepareStatement(
			"UPDATE feepayments SET StudentID=?, StudentName=?, PaymentDate=?, Amount=?, Status=? WHERE PaymentID=?");

			ps.setInt(1, f.getStudentID());
			ps.setString(2, f.getStudentName());
			ps.setString(3, f.getPaymentDate());
			ps.setDouble(4, f.getAmount());
			ps.setString(5, f.getStatus());
			ps.setInt(6, f.getPaymentID());

			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// DELETE
	public void deletePayment(int id) {

		try {

			PreparedStatement ps = con.prepareStatement(
			"DELETE FROM feepayments WHERE PaymentID=?");

			ps.setInt(1, id);

			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}