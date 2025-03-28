<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    // load order state = 0
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
                <tr>
                    <td>1</td>
                    <td>Juanito</td>
                    <td>Americana</td>
                    <td>2</td>
                    <td>$ 50</td>
                    <td><a href="#" class="btn">Pagar</a></td>
                </tr>
                <tr>
                    <td>2</td>
                    <td>María</td>
                    <td>Jamón</td>
                    <td>1</td>
                    <td>$ 30</td>
                    <td><a href="#" class="btn">Pagar</a></td>
                </tr>
                <tr>
                    <td>3</td>
                    <td>Teresa</td>
                    <td>Luisa</td>
                    <td>3</td>
                    <td>$ 60</td>
                    <td><a href="#" class="btn">Pagar</a></td>
                </tr>
            </tbody>
        </table>
        <button class="close-btn">Cierre Caja</button>
    </div>
</body>
</html>