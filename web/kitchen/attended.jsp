<%@page import="java.util.ArrayList"%>
<%@page import="dto.PizzaDTO"%>
<%@page import="dao.PizzaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    ArrayList<PizzaDTO> listDB = PizzaDAO.findQuantityPizza(2);
    int suma = 0;
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
                <% for (PizzaDTO pizza : listDB) {%>
                <tr>
                    <td><%= pizza.getName()%></td>
                    <td><%= pizza.getQuantity()%></td>
                    <% suma += pizza.getQuantity(); %>
                </tr>
                <% }%>

                <% if (suma != 0) {%>
                <tr>
                    <td><strong>Total</strong></td>
                    <td><%= suma%></td>
                </tr>
                <% }%>
            </tbody>
        </table>

        <form action="<%= path%>/Close" method="POST" class="frm-btn">
            <button class="close-btn" type="submit">Cerrar</button>
        </form>

        <button class="close-btn">
            <a href="<%= path%>/kitchen/kitchen.jsp">Regresar</a>
        </button>
    </div>
</body>
</html>