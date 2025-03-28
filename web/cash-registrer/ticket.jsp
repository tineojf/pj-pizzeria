<%@page import="java.util.ArrayList"%>
<%@page import="dto.TicketDTO"%>
<%@page import="dao.TicketDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    ArrayList<TicketDTO> listDB = TicketDAO.findAll();
    double suma = 0.0;
%>

<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Zona Cierre Caja</title>
        <link rel="stylesheet" href="<%= path%>/assets/css/styles.css">
    </head>
    <div class="caja-container">
        <h2>BOLETAS Y FACTURAS</h2>
        <table>
            <thead>
                <tr class="bck-ticket">
                    <th>Serie</th>
                    <th>Cliente</th>
                    <th>DNI</th>
                    <th>Fecha y Hora</th>
                    <th>Total</th>
                </tr>
            </thead>
            <tbody>
                <% for (TicketDTO order : listDB) {%>
                <tr>
                    <td><%= order.getSerie()%></td>
                    <td><%= order.getCustomerName()%></td>
                    <td><%= order.getCustomerDNI()%></td>
                    <td><%= order.getCreatedAt()%></td>
                    <td><%= order.getOrderTotal()%></td>
                    <% suma += order.getOrderTotal(); %>
                </tr>
                <% }%>

                <% if (suma != 0.0) {%>
                <tr>
                    <td colspan="4"><strong>Total</strong></td>
                    <td><%= suma%></td>
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
        <form action="<%= path%>/Ticket" method="POST" class="frm-btn">
            <button class="bar-btn bck-close"" type="submit">Cerrar</button>
        </form>
    </div>
</body>
</html>