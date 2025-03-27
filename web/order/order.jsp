<%@page import="dao.PizzaDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.PizzaModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    ArrayList<PizzaModel> listDB = PizzaDAO.findAll();
%>

<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Zona de Pedidos</title>
        <link rel="stylesheet" href="<%= path%>/assets/css/order.css">
    </head>
    <body>
        <div class="login-container">
            <img src="<%= path%>/assets/images/logo.jpg" alt="Logo">
            <h2>Zona de Pedidos</h2>
            <form action="<%= path%>/Order" method="POST">
                <div class="input-group">
                    <label for="customerName">Cliente</label>
                    <input type="text" id="customerName" name="customerName" 
                           placeholder="Nombre del cliente" required>
                </div>

                <div class="input-group">
                    <label for="dni">DNI</label>
                    <input type="text" id="dni" name="dni" 
                           placeholder="Número de DNI" required>
                </div>

                <div class="input-group">
                    <label for="pizzaAndPrice">Pizza</label>
                    <select id="pizzaAndPrice" name="pizzaAndPrice">
                        <% for (PizzaModel pizza : listDB) {%>
                        <option value="<%= pizza.getPizzaID()%>&<%= pizza.getPrice()%>">
                            <%= pizza.getName()%> - $<%= pizza.getPrice()%>
                        </option>
                        <% }%>
                    </select>                
                </div>

                <div class="input-group">
                    <label for="quantity">Cantidad</label>
                    <input type="number" id="quantity" name="quantity" min="1" 
                           value="1" step="1" required>
                </div>

                <button type="submit" class="login-btn">Registrar pedido</button>
            </form>
        </div>
    </body>
</html>
