<%-- 
    Document   : busca
    Created on : 02/07/2017, 13:18:58
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
        <form action="buscaservlet" method="GET">
                    <input type="text" name="pais" placeholder="País" required />
                    <input type="text" name="cidade" placeholder="Cidade" required/>
                    <input type="submit" value="Pesquisar" />
        </form>
    </body>
</html>
