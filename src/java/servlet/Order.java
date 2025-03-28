package servlet;

import dao.CustomerDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.CustomerModel;
import model.OrderModel;

@WebServlet(name = "Order", urlPatterns = {"/Order"})
public class Order extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Order</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Order at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // foreign key
        int userFound = -2;
        int orderID = -1;

        // verify & create customer
        String customer = request.getParameter("customerName");
        String dni = request.getParameter("dni");

        try {
            userFound = CustomerDAO.findByDNI(dni);

            if (userFound == -1) {
                CustomerModel newCustomer = new CustomerModel(dni, customer);
                CustomerDAO.create(newCustomer);
                userFound = CustomerDAO.findByDNI(dni);
            }
        } catch (SQLException ex) {
            System.out.println("GET error: " + ex.getMessage());
        }

        // create order
        String[] pizzaAndPrice = request.getParameter("pizzaAndPrice").split("&");
        int pizzaID = Integer.parseInt(pizzaAndPrice[0]);
        double price = Double.parseDouble(pizzaAndPrice[1]);
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        double total = price * quantity;

        OrderModel newOrder = new OrderModel(quantity, total, 0, userFound, pizzaID);

        // create ticket
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
