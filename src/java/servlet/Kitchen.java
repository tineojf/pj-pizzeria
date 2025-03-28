package servlet;

import dao.OrderDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Kitchen", urlPatterns = {"/Kitchen"})
public class Kitchen extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("kitchen/kitchen.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // update state
        int orderID = Integer.parseInt(request.getParameter("orderID"));

        try {
            OrderDAO.update(orderID);
            response.sendRedirect("kitchen/kitchen.jsp");
        } catch (SQLException ex) {
            System.err.println("UPDATE - Error: " + ex.getMessage());
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
