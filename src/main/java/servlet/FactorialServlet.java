package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/factorial")
public class FactorialServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    // Show input form when URL is opened directly
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h2>Factorial Calculator</h2>");
        out.println("<form method='post' action='factorial'>");
        out.println("Enter Number: <input type='text' name='num' required>");
        out.println("<br><br><input type='submit' value='Find Factorial'>");
        out.println("</form>");
        out.println("</body></html>");
    }

    // Calculate factorial
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            int num = Integer.parseInt(request.getParameter("num"));

            long fact = 1;
            for (int i = 1; i <= num; i++) {
                fact *= i;
            }

            out.println("<html><body>");
            out.println("<h2>Factorial of " + num + " is: " + fact + "</h2>");
            out.println("<br><a href='factorial'>Try Again</a>");
            out.println("</body></html>");

        } catch (Exception e) {
            out.println("<h3>Invalid Input! Please enter a valid number.</h3>");
        }
    }
}