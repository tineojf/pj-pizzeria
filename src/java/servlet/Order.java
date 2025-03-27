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
        // verify & create customer
        String customer = request.getParameter("customerName");
        String dni = request.getParameter("dni");
        int userFound = -2;

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

        System.out.println(userFound);

        // create order
        // create ticket
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
