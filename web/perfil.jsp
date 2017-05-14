<%-- 
    Document   : perfil
    Created on : 07/05/2017, 21:55:39
    Author     : Ricardo  Junior
--%>
<%@page import="Model.Avaliacaoesporte"%>
<%@page import="Model.Avaliacaohospedagem"%>
<%@page import="Model.Avaliacaoamizade"%>
<%@page import="DAO.AvaliacoesDAO"%>
<%@page import="Model.Usuario"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>

        <% Usuario user = ((Usuario) request.getAttribute("user"));%>
        <p>Usuario Logado: <a href="PerfilServlet?id=<%= request.getSession().getAttribute("logadoid")%>"> <%= request.getSession().getAttribute("logadonome")%> </a> </p>
        <p>Nome: <%= user.getNome()%></p>
        <p>Esporte: <%= user.getEsporteId().getNome()%> </p>
        <% float somanota = 0; %>
        <% float cont = 0; %>
        <% if (user.getStatus() == true) {%>
            <p>Disponivel para hospedar</p>
        <%} else { %>
            <p>Indisponivel para hospedar</p>
        <%}%>

        <p>Email: <%= user.getEmail()%> </p>

        <p> Localidade: <%= user.getLocalidade()%> </p>

        <p> Quantidade de visitantes <%= user.getQntvisitante()%> </p>

        <p> <b>Recomendacoes por amizade:</b> </p>

        <% for (Avaliacaoamizade aux : AvaliacoesDAO.getamizade(user.getId())) {%>
            <p>Nome: <a href="PerfilServlet?id=<%=aux.getUserFaz().getId()%>"> <%= aux.getUserFaz().getNome()%></a> <p>
            <p>Nota: <%= aux.getNota()%></p>
            <p>Mensagem:<%= aux.getText()%></p>           
            <% somanota += aux.getNota();%>
            <% cont += 1;%>
        <% }%>

        <p> <b>Recomendacoes dos Hospedados:</b> </p>

        <% for (Avaliacaohospedagem aux : AvaliacoesDAO.gethospedeiro(user.getId()) ) {%>
            <p>Nome: <a href="PerfilServlet?id=<%=aux.getHospedadoId().getId() %>"> <%= aux.getHospedadoId().getNome() %></a> <p>
            <p>Nota: <%= aux.getNotahospedado() %></p>
            <p>Mensagem:<%= aux.getTextohospedado() %></p>           
            <% somanota += aux.getNotahospedado() ;%>
            <% cont += 1;%>
        <% }%>


        <p> <b>Recomendacoes dos Hospedeiros:</b> </p>

        <% for (Avaliacaohospedagem aux : AvaliacoesDAO.gethospedado(user.getId()) ) {%>
            <p>Nome: <a href="PerfilServlet?id=<%=aux.getHospedeiroId().getId() %>"> <%= aux.getHospedeiroId().getNome() %></a> <p>
            <p>Nota: <%= aux.getNotahospedeiro() %></p>
            <p>Mensagem:<%= aux.getTextohospedeiro() %></p>           
            <% somanota += aux.getNotahospedeiro() ;%>
            <% cont += 1;%>
        <% }%>
        
        <p> <b>Recomendacoes de Saida por esporte:</b> </p>

        <% for (Avaliacaoesporte aux : AvaliacoesDAO.getesporte(user.getId()) ) {%>
            <p>Nome: <a href="PerfilServlet?id=<%=aux.getUserFaz().getId() %>"> <%= aux.getUserFaz().getNome() %></a> <p>
            <p>Local de saida: <%= aux.getSaidaId().getLocalidade() %></p>
            <p>Nota: <%= aux.getNota() %></p>
            <p>Mensagem:<%= aux.getTexto() %></p>           
            <% somanota += aux.getNota() ;%>
            <% cont += 1;%>
        <% }%>
    
        <% float media = somanota/cont;%>
        <p><b>Média</b> <%= media  %><p>

    </body>
</html>
