package servlet;

import dao.OrderDAO;
import dao.SerieDAO;
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
        } catch (SQLException ex) {
            System.err.println("UPDATE - Error: " + ex.getMessage());
        }

        // find ticket type
        String ticketType = request.getParameter("ticketType");
        System.out.println(ticketType);
        int serieQuantity = 0;

        try {
            serieQuantity = SerieDAO.findQuantityByName(ticketType);
        } catch (SQLException ex) {
            System.err.println("GET - Error: " + ex.getMessage());
        }

        // update serie quantity
        try {
            SerieDAO.updateQuantity(ticketType, serieQuantity + 1);
        } catch (SQLException ex) {
            System.err.println("GET - Error: " + ex.getMessage());
        }

        // generate serie
        String serie = ticketType + "-" + String.format("%05d", serieQuantity);

        // create ticket
        
        
        // final redirect
        response.sendRedirect("kitchen/kitchen.jsp");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
