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
         <p> Usuario Logado: <%= request.getSession().getAttribute("usuario") %></p>
         <p>Nome: <%= user.getNome() %></p>
         <p>Esporte: Surf</p>
         <% float somanota = 0; %>
         <% float cont = 0; %>
         <% if (user.getStatus() == true) {%>
            <p>Disponivel para hospedar</p>
        <%} else{ %>
            <p>Indisponivel para hospedar</p>
        <%}%>
        
         <p>Email: <%= user.getEmail() %> </p>
        
         <p> Localidade: <%= user.getLocalidade() %> </p>
         
         <p> Quantidade de visitantes <%= user.getQntvisitante()%> </p>
         
         <p> <b>Recomendacoes por amizade:</b> </p>
       
         <% for (Avaliacao aux: AvaliacaoDAO.getamizade(user.getId())) { %>
            <p>Nome: <a href="PerfilServlet?id=<%=aux.getId()%>"> <%= aux.getUserFaz().getNome() %></a> <p>
            <p>Nota: <%= aux.getNota()%></p>
            <p>Mensagem:<%= aux.getText() %></p>           
             
        <% } %>

        
         <p><b>Recomendacoes por Hospedagem:</b></p>
         
         <% for (Avaliacaocomposta aux: AvaliacaoDAO.gethospedero(user.getId())) { %>
            
         
         <p>Nome: <a href="PerfilServlet?id=<%=aux.getId()%>"> <%= aux.getHospedadoId().getNome()%> </a></p>
          
         <p>Nota: <%= aux.getNota()%> </p>
          
         <p>Mensagem:<%= aux.getTextohospedero() %></p>  
         <% somanota += aux.getNota();%>
         <% cont+=1;%>
        <% } %>
        
        
        <p><b>Recomendacoes por Hospedado:</b></p>
         
         <% for (Avaliacaocomposta aux: AvaliacaoDAO.gethospedado(user.getId())) { %>
            
         
           <p>Nome:<a href="PerfilServlet?id=<%=aux.getId()%>"><%= aux.getHospederoId().getNome() %></a></p>
            
           <p>Nota: <%= aux.getNota()%></p>
            
            <p>Mensagem:<%= aux.getTextohospedagem() %> </p>  
            <% somanota += aux.getNota();%>
            <% cont+=1;%>
        <% } %>
        
         
        <p><b>Recomendacoes por Esporte:</b></p>
        <% for (Avaliacaocomposta aux: AvaliacaoDAO.getesporte(user.getId())) { %>
            
         
           <% if (aux.getHospederoId().getId() != user.getId()) { %>
               <p>Nome: <a href="PerfilServlet?id=<%=aux.getId()%>"><%= aux.getHospederoId().getNome() %></a></p>
                
               <p>Nota: <%= aux.getNota()%></p>
                
                <p>Mensagem:<%= aux.getTextohospedagem()%></p>  
                 <% somanota += aux.getNota();%>
                <% cont+=1;%>
               
            <% } else { %>
                <p>Nome: <a href="PerfilServlet?id=<%=aux.getId()%>"> <%= aux.getHospedadoId().getNome() %> </a></p>
                
               <p>Nota: <%= aux.getNota()%></p>
                
                <p>Mensagem:<%= aux.getTextohospedero()%></p>  
                         <% somanota += aux.getNota();%>
         <% cont+=1;%>
            
            <% } %>
        <% } %>
        
        <% float media = somanota/cont;%>
        <p><b>Média</b> <%= media  %><p>
    </body>
</html>
