<%@page import="java.util.ArrayList"%>
<%@page import="dto.OrderDTO"%>
<%@page import="dao.OrderDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    ArrayList<OrderDTO> listDB = OrderDAO.findAllByState(1);
%>

<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Zona Cocina</title>
        <link rel="stylesheet" href="<%= path%>/assets/css/styles.css">
    </head>
    <div class="caja-container">
        <h2>COCINA</h2>

        <table>
            <thead>
                <tr class="bck-kitchen">
                    <th>#</th>
                    <th>Cliente</th>
                    <th>Pizza</th>
                    <th>Cant.</th>
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
                    <td>
                        <form action="<%= path%>/Attended" method="POST">
                            <input type="hidden" name="orderID" value="<%= order.getOrderID()%>">
                            <button type="submit" class="btn btn-attended">Atender</button>
                        </form>
                    </td>
                </tr>
                <% }%>
            </tbody>
        </table>

        <button class="close-btn">
            <a href="<%= path%>/kitchen/attended.jsp">Atendidos</a>
        </button>

        <button class="close-btn">
            <a href="<%= path%>/cash-registrer/cash-registrer.jsp">Regresar</a>
        </button>
    </div>
</body>
</html>