<%-- 
    Document   : solicitarhospedagem
    Created on : 02/07/2017, 18:30:38
    Author     : Ricardo  Junior
--%>

<%@page import="Model.Esporte"%>
<%@page import="DAO.EsporteDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
<form action="CriarHospedagemServlet" method="GET">
                    <input type="number" name="qtd_hospede" placeholder="Quantidade de hospedes" required />
                    <input type="date" name="data_inicio" placeholder="Data de inicio dd-mm-aaaa" required/>
                    <input type="date" name="data_termino" placeholder="Data de termino dd-mm-aaaa" required/>
                    <input type="number" name="qtd_esportista" placeholder="Quantidade de esportistas" required />
                    <input type="hidden" name="anfitriao" value="<%= request.getParameter("anfitriao") %>">
                    <select  name="esporte">
                        <% for (Esporte aux:EsporteDAO.getesportes()){ %> 
                          <option value="<%=aux.getId() %>"> <%= aux.getNome() %> </option>
                        <%}%>
                    </select>
                    <input type="submit" value="Enviar solicitacao de hospedagem" />
        </form>
    </body>
</html>
