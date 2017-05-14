<%-- 
    Document   : newjsp
    Created on : 07/05/2017, 21:41:48
    Author     : Ricardo  Junior
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Login</h2>
        <div class="form">
            <form action="LoginUsuarioServlet" method="POST">
                <h4>Usuário</h4>
                <input type="text" name="username">
                <h4>Senha</h4>
                <input type="password" name="password">
                <div class="clearfix"></div>
                <div class="clearfix"></div>
                <input type="submit" value="Entrar">
            </form>
            <% if (request.getAttribute("login_failed") != null) { %>
            <div>Usuario ou Senha incorreto</div>
            <% }%>
        </div>
    </body>
</html>
