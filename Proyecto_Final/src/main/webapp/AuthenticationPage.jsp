<%-- 
    Document   : AuthenticationPage
    Created on : 20/06/2020, 10:46:47
    Author     : reyg6
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Supermercado Agua Santa</h1>
        <form action="AuthenticationCa" method="post">
            <label>Usuario</label>
            <input type="text" name="user"/>
            <br/>
            <label>Contrasena</label>
            <input type="password" name="password"/>
            <br/>
            <input type="submit" value="Verificar"/>
            <br/>          
        </form> 
        <a href="creacionUsuario">Crear Usuario</a>
      
    </body>
</html>
