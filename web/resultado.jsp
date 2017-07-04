<%-- 
    Document   : resultado
    Created on : 02/07/2017, 15:57:16
    Author     : Ricardo  Junior
--%>

<%@page import="Model.Usuario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
         <% List<Usuario> resultado = ((List) request.getAttribute("resultado"));%>
         <% for(Usuario u:resultado){%>   
                <%= u.getNome()%>
                <%= u.getBairro()+ ", " + u.getCidadeFk().getNome()+ ", " + u.getCidadeFk().getEstadoFk().getNome() + ", "  +u.getCidadeFk().getEstadoFk().getPaisFk().getNome() %>
                <a href="solicitarhospedagem.jsp?anfitriao=<%=u.getId()%>">Solicitar Hospedagem</a>
                <br>
                   
         <%}%>   
    </body>
</html>
