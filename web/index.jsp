<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% String path = request.getContextPath();%>
<% String userFound = request.getParameter("user");%>

<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Inicio de Sesión</title>
        <link rel="stylesheet" href="<%= path%>/assets/css/login.css">

        <% if (userFound != null && userFound.equals("0")) {%>
        <script>alert("Usuario o contraseña incorrecta")</script>
        <% }%>
    </head>
    <body>
        <div class="login-container">
            <img src="<%= path%>/assets/images/logo.jpg" alt="Logo">
            <h2>Iniciar Sesión</h2>
            <form action="<%= path%>/Login" method="POST">
                <div class="input-group">
                    <label for="username">Usuario</label>
                    <input type="text" name="username" placeholder="Ingresa tu usuario" required>
                </div>

                <div class="input-group">
                    <label for="password">Contraseña</label>
                    <input type="password" name="password" placeholder="Ingresa tu contraseña" required>
                </div>

                <button type="submit" class="login-btn">Ingresar</button>
            </form>
        </div>
    </body>
</html>