<%-- 
    Document   : avaliacao
    Created on : 04/07/2017, 03:09:29
    Author     : Ricardo  Junior
--%>

<%@page import="Model.Hospedagem"%>
<%@page import="Model.Usuario"%>
<%@page import="DAO.SolicitacoesDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        Avaliacao por hospedagem
        <%Usuario user = (Usuario) request.getSession().getAttribute("logado");%>
        <%for (Hospedagem h:SolicitacoesDAO.gethospedagem(user.getId())){%>
            
            
        <%if( h.getAnfitriaoId().getId() == user.getId()) {%>
                    <p>Hospede: <%= h.getSolicitanteId().getNome() %></p>
                    <form action="AvaliacaoServlet" method="POST">
                        <input type="text" name="textohospede" placeholder="Texto de avaliacao do hospede" required />
                        <input type="number" name="notahospede" placeholder="Nota" required/>
                        <input type="hidden" name="hospedagem" value="<%= h.getId() %>">
              
                        <input type="submit" value="enviar" />
                    </form>            
        <%}%>
        
        <%if(h.getSolicitanteId().getId() == user.getId()){%>
                    <p>Anfitriao: <%= h.getAnfitriaoId().getNome() %></p>
                    <form action="AvaliacaoServlet" method="POST">
                        <input type="text" name="textoanfitriao" placeholder="Texto de avaliacao do anfitriao" required />
                        <input type="number" name="notaanfitriao" placeholder="Nota" required/>
                        <input type="hidden" name="hospedagem" value="<%= h.getId() %>">
              
                        <input type="submit" value="enviar" />
                    </form>            
        <%}%>


        <%}%>
    </body>
</html>
