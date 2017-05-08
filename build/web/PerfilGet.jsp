<%-- 
    Document   : perfil
    Created on : 07/05/2017, 21:55:39
    Author     : Ricardo  Junior
--%>
<%@page import="model.Avaliacao"%>
<%@page import="model.Avaliacaocomposta"%>
<%@page import="model.Usuario"%>
<%@page import="DAO.AvaliacaoDAO"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
         <% Usuario user = ((Usuario)request.getAttribute("user")); %>
         Nome: <%= user.getNome() %>
         <br>
         Esporte: Surf
         <br>
         <% if (user.getStatus() == true) {%>
            <p>Disponivel</p>
        <%} else{ %>
            <p>Indisponivel</p>
        <%}%>
         <br>
         Email: <%= user.getEmail() %>
         <br>
         Localidade: <%= user.getLocalidade() %>
         <br>
         Quant de visitantes <%= user.getQntvisitante()%>
         <br> 
         <br>
         Recomendacoes por amizade:
        <br>
         <% for (Avaliacao aux: AvaliacaoDAO.getamizade(user.getId())) { %>
         <br>   
         <br>
            Nome: <a href="PerfilServlet?id=<%=aux.getId()%>"> <%= aux.getUserFaz().getNome() %></a>
            <br> 
            Nota: <%= aux.getNota()%>
            <br>
            Mensagem:<%= aux.getText() %>  
            <br>    
        <% } %>

        <br>
         Recomendacoes por Hospedagem:
         
         <% for (Avaliacaocomposta aux: AvaliacaoDAO.gethospedero(user.getId())) { %>
         <br>   
         <br>
         Nome: <a href="PerfilServlet?id=<%=aux.getId()%>"> <%= aux.getHospedadoId().getNome()%> </a>
          <br>
          Nota: <%= aux.getNota()%>
          <br>
          Mensagem:<%= aux.getTextohospedero() %>  
            <br>
        <% } %>
        <br>
        <br>
        Recomendacoes por Hospedado:
         
         <% for (Avaliacaocomposta aux: AvaliacaoDAO.gethospedado(user.getId())) { %>
         <br>   
         <br>
            Nome:<a href="PerfilServlet?id=<%=aux.getId()%>"><%= aux.getHospederoId().getNome() %></a>
            <br>
            Nota: <%= aux.getNota()%>
            <br>
            Mensagem:<%= aux.getTextohospedagem() %>  
            <br>
        <% } %>
        <br>
         
        Recomendacoes por Esporte:
        <% for (Avaliacaocomposta aux: AvaliacaoDAO.getesporte(user.getId())) { %>
         <br>   
         <br>
           <% if (aux.getHospederoId().getId() != user.getId()) { %>
                Nome: <a href="PerfilServlet?id=<%=aux.getId()%>"><%= aux.getHospederoId().getNome() %></a>
                <br>
                Nota: <%= aux.getNota()%>
                <br>
                Mensagem:<%= aux.getTextohospedagem() %>  
                <br>
               
            <% } else { %>
                Nome: <a href="PerfilServlet?id=<%=aux.getId()%>"> <%= aux.getHospedadoId().getNome() %> </a>
                <br>
                Nota: <%= aux.getNota()%>
                <br>
                Mensagem:<%= aux.getTextohospedero()%>  
                <br>
            
            <% } %>
        <% } %>
        <br>
    </body>
</html>
