<%@page import="java.util.ArrayList"%>
<%@page import="dto.OrderDTO"%>
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
        <link rel="stylesheet" href="<%= path%>/assets/css/styles.css">
    </head>
    <div class="caja-container">
        <h2>CAJA</h2>

        <table>
            <thead>
                <tr class="bck-registrer">
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
                            <input type="hidden" name="ticketType" value="B001">
                            <button type="submit" class="btn double-btn bck-ticket">Boleta</button>
                        </form>
                        <form action="<%= path%>/Kitchen" method="POST">
                            <input type="hidden" name="orderID" value="<%= order.getOrderID()%>">
                            <input type="hidden" name="ticketType" value="F001">
                            <button type="submit" class="btn double-btn bck-ticket">Factura</button>
                        </form>
                    </td>
                </tr>
                <% }%>
            </tbody>
        </table>

        <button class="bar-btn bck-order">
            <a href="<%= path%>/order/order.jsp">Pedido</a>
        </button>
        <button class="bar-btn bck-kitchen">
            <a href="<%= path%>/kitchen/kitchen.jsp">Cocina</a>
        </button>
        <button class="bar-btn bck-attended">
            <a href="<%= path%>/kitchen/attended.jsp">Atendidos</a>
        </button>
        <button class="bar-btn bck-ticket">
            <a href="<%= path%>/cash-registrer/ticket.jsp">Comprobantes</a>
        </button>
    </div>
</body>
</html>