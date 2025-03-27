<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Inicio de Sesión</title>
        <link rel="stylesheet" href="<%= request.getContextPath()%>/assets/css/login.css">
    </head>
    <body>
        <div class="login-container">
            <img src="<%= request.getContextPath()%>/assets/images/logo.jpg" alt="Logo">
            <h2>Iniciar Sesión</h2>
            <form>
                <div class="input-group">
                    <label for="email">Correo Electrónico</label>
                    <input type="email" id="email" placeholder="Ingresa tu correo" required>
                </div>
                <div class="input-group">
                    <label for="password">Contraseña</label>
                    <input type="password" id="password" placeholder="Ingresa tu contraseña" required>
                </div>
                <button type="submit" class="login-btn">Ingresar</button>
            </form>
            <div class="forgot-password">
                <a href="#">¿Olvidaste tu contraseña?</a>
            </div>
        </div>
    </body>
</html>