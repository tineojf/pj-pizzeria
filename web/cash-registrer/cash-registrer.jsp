<%@page import="java.util.ArrayList"%>
<%@page import="model.OrderDTO"%>
<%@page import="dao.OrderDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    ArrayList<OrderDTO> listDB = OrderDAO.findAllByState(0);
%>

<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Zona Caja</title>
        <link rel="stylesheet" href="<%= path%>/assets/css/cash-registrer.css">
    </head>
    <div class="caja-container">
        <h2>CAJA</h2>
        <table>
            <thead>
                <tr>
                    <th>#</th>
                    <th>Cliente</th>
                    <th>Pizza</th>
                    <th>Cant.</th>
                    <th>Total</th>
                    <th>Acción</th>
                </tr>
            </thead>
            <tbody>
                <% for (OrderDTO order : listDB) {%>
                <tr>
                    <td><%= order.getOrderID()%></td>
                    <td><%= order.getCustomer()%></td>
                    <td><%= order.getPizza()%></td>
                    <td><%= order.getQuantity()%></td>
                    <td><%= order.getTotal()%></td>
                    <td>
                        <form action="<%= path%>/Kitchen" method="POST">
                            <input type="hidden" name="orderID" value="<%= order.getOrderID()%>">
                            <button type="submit" class="btn">Pagar</button>
                        </form>
                    </td>
                </tr>
                <% }%>
            </tbody>
        </table>
        <button class="close-btn">
            <a href="<%= path%>/cash-registrer/close-registrer.jsp">Cierre Caja</a>
        </button>
    </div>
</body>
</html>