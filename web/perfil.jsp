<%-- 
    Document   : perfil
    Created on : 07/05/2017, 21:55:39
    Author     : Ricardo  Junior
--%>
<%@page import="Model.Avaliacaohospedagem"%>
<%@page import="Model.Avaliacaosaida"%>
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
        <p>Esporte: <%= user.getEsporteFk().getNome() %> </p>
        <% float somanota = 0; %>
        <% float cont = 0; %>
        <% if (user.getRecebeVisita() == true) {%>
            <p>Disponivel para hospedar</p>
        <%} else { %>
            <p>Indisponivel para hospedar</p>
        <%}%>

        <p>Email: <%= user.getEmail()%> </p>

           <p> Bairro: <%= user.getBairro() %></p> 
           <p> Cidade: <%= user.getCidadeFk().getNome()%> </p>
           <p> Estado: <%= user.getCidadeFk().getEstadoFk().getNome()%> </p>
           <p> País: <%= user.getCidadeFk().getEstadoFk().getPaisFk().getNome() %> </p>

        <p> Quantidade maxima de visitantes: <%= user.getMaxVisitante() %> </p>
        <p> Quantidade minima de visitantes: <%= user.getMinVisitante() %> </p>

        <p> <b>Recomendacoes por amizade:</b> </p>

        <% for (Avaliacaoamizade aux : AvaliacoesDAO.getamizade(user.getId())) {%>
            <p>Nome: <a href="PerfilServlet?id=<%=aux.getAvaliadorFk().getId()%>"> <%= aux.getAvaliadorFk().getNome() %></a> <p>
            <p>Nota: <%= aux.getNota()%></p>
            <p>Mensagem:<%= aux.getText()%></p>           
            <% somanota += aux.getNota();%>
            <% cont += 1;%>
        <% }%>

        <p> <b>Recomendacoes dos Hospedes:</b> </p>

        <% for (Avaliacaohospedagem aux : AvaliacoesDAO.getanfitriao(user.getId()) ) {%>
            <p>Nome: <a href="PerfilServlet?id=<%=aux.getHospedeFk().getId() %>"> <%= aux.getHospedeFk().getNome() %></a> <p>
            <p>Nota: <%= aux.getNotaAnfitriao() %></p>
            <p>Mensagem:<%= aux.getAvaAnfitriaoText() %></p>           
            <% somanota += aux.getNotaAnfitriao() ;%>
            <% cont += 1;%>
        <% }%>


        <p> <b>Recomendacoes dos Anfitriões:</b> </p>

        <% for (Avaliacaohospedagem aux : AvaliacoesDAO.gethospede(user.getId()) ) {%>
            <p>Nome: <a href="PerfilServlet?id=<%=aux.getAnfitriaoFk().getId() %>"> <%= aux.getAnfitriaoFk().getNome() %></a> <p>
            <p>Nota: <%= aux.getNotaHospede() %></p>
            <p>Mensagem:<%= aux.getAvaHospedeText() %></p>           
            <% somanota += aux.getNotaHospede() ;%>
            <% cont += 1;%>
        <% }%>

        
        <p> <b>Recomendacoes de Saida por esporte:</b> </p>

        <% for (Avaliacaosaida aux : AvaliacoesDAO.getrecsaida(user.getId()) ) {%>
            <p>Nome: <a href="PerfilServlet?id=<%=aux.getAvaliadorFk().getId() %>"> <%= aux.getAvaliadorFk().getNome() %></a> <p>
            <p>Local de saida: <%= aux.getSaidaFk().getCidadeFk().getNome() %></p>
            <p>Local de saida: <%= aux.getSaidaFk().getDescricao() %></p>
            <p>Nota: <%= aux.getNota() %></p>
            <p>Mensagem:<%= aux.getText() %></p>           
            <% somanota += aux.getNota() ;%>
            <% cont += 1;%>
        <% }%>
    
        <% float media = somanota/cont;%>
        <p><b>Média</b> <%= media  %><p>

    </body>
</html>
