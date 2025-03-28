<%@page import="java.util.ArrayList"%>
<%@page import="model.PizzaDTO"%>
<%@page import="dao.PizzaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    ArrayList<PizzaDTO> listDB = PizzaDAO.findQuantityPizza(2);
%>

<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Zona Cocina Atendida</title>
        <link rel="stylesheet" href="<%= path%>/assets/css/cash-registrer.css">
    </head>
    <div class="caja-container">
        <h2>COCINA ATENDIDA</h2>
        <table>
            <thead>
                <tr>
                    <th>Pizza</th>
                    <th>Cantidad</th>
                </tr>
            </thead>
            <tbody>
                <% for (PizzaDAO order : listDB) {%>
                <tr>
                    <td><%= order.getPizza()%></td>
                    <td><%= order.getQuantity()%></td>
                </tr>
                <% }%>
            </tbody>
        </table>
        <button class="close-btn">
            <a href="<%= path%>/kitchen/attended.jsp">Atendidos</a>
        </button>
    </div>
</body>
</html>