<%-- 
    Document   : pedidodesolicitacoes
    Created on : 03/07/2017, 21:59:45
    Author     : Ricardo  Junior
--%>

<%@page import="Model.Hospedagemesporte"%>
<%@page import="Model.Usuario"%>
<%@page import="Model.Hospedagem"%>
<%@page import="DAO.SolicitacoesDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Localhost</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--[if lte IE 8]>--><script src="assets/js/ie/html5shiv.js"></script><!--[endif]-->
        <link rel="stylesheet" href="assets/css/main.css" />
        <!--[if lte IE 8]>--><link rel="stylesheet" href="assets/css/ie8.css" /><!--[endif]-->
        <!--[if lte IE 9]>--><link rel="stylesheet" href="assets/css/ie9.css" /><!--[endif]-->
    </head>
    <body class="left-sidebar">
        <div id="page-wrapper">

            <!-- Header -->
            <header id="header">
                <nav id="nav">
                    <ul>
                            <li class="current"><a href="index.jsp">Home</a></li>
                            <li class="current"><a href="index.jsp#main" class="scrolly">Quem Somos</a></li>
                            <li class="current"><a href="busca.jsp" class="scrolly">Buscar hospedagens</a></li>
                            <li class="current"><a href="pedidodesolicitacoes.jsp" class="scrolly">Pedidos de hospedagens</a></li>
                            <li class="current"><a href="solicitacoesfeitas.jsp" class="scrolly">Hospedagens solicitadas</a></li>
                            <li class="current"><a href="avaliacao.jsp" class="scrolly">Avaliacao</a></li>
                            <li><a href="login.jsp" class="button special">Sair</a></li>
                    </ul>
                </nav>
            </header>

            <article id="main">
                <header class="special container">
                    <h2>Bem-vindo <strong> <a href="PerfilServlet?id=<%= request.getSession().getAttribute("logadoid")%>"> <%= request.getSession().getAttribute("logadonome")%> </a> </strong></h2>
                    <p>Navegue em nosso site e busque a sua hospedagem ideal.</p>
                </header>
        <%Usuario user = (Usuario) request.getSession().getAttribute("logado");%>
        <p>A Confirmar:</p>
        <% if (!SolicitacoesDAO.existeconfirmado(user.getId())){ %>
            <%for (Hospedagem h: SolicitacoesDAO.getpedidosaceitar( user.getId() )) {%>
                    <% Hospedagemesporte he = SolicitacoesDAO.gethospedagemesporte(h.getId()); %>

                    Data Inicio: <%= h.getDataInicio() %><br>
                    Data Termino: <%= h.getDataTermino() %><br>
                    Quantidade de Hospedes: <%= h.getQtdHospedes() %><br>
                    Anfitriao: <%= h.getAnfitriaoId().getNome() %><br>
                    Esporte: <%= he.getEsporte().getNome() %><br>
                    Quantidade de esportistas: <%= he.getQtdEsportista() %><br>
                    <a href="RespostaSolicitacaoServlet?hospedagem=<%= h.getId() %>&op=3"><button>Confirmar</button></a>
                    <a href="RespostaSolicitacaoServlet?hospedagem=<%= h.getId() %>&op=4"><button>Recusar</button></a>
                    <br>
                    <br>
            <%}%>        
        <% } else { %>
            <p>Voce ja aceitou uma</p>
        <%}%>

        

        ____________________________________________________

        <p>Recusados:</p>

        <%for (Hospedagem h: SolicitacoesDAO.getpedidosrecusados( user.getId() )) {%>
                <% Hospedagemesporte he = SolicitacoesDAO.gethospedagemesporte(h.getId()); %>
                
                Data Inicio: <%= h.getDataInicio() %><br>
                Data Termino: <%= h.getDataTermino() %><br>
                Quantidade de Hospedes: <%= h.getQtdHospedes() %><br>
                Anfitriao: <%= h.getAnfitriaoId().getNome() %><br>
                Esporte: <%= he.getEsporte().getNome() %><br>
                Quantidade de esportistas: <%= he.getQtdEsportista() %><br>
                <br>
                <br>
                
        <%}%>
        ____________________________________________________
        <p>Em Espera:</p>

        <%for (Hospedagem h: SolicitacoesDAO.getpedidosespera( user.getId() )) {%>
                <% Hospedagemesporte he = SolicitacoesDAO.gethospedagemesporte(h.getId()); %>
                
                Data Inicio: <%= h.getDataInicio() %><br>
                Data Termino: <%= h.getDataTermino() %><br>
                Quantidade de Hospedes: <%= h.getQtdHospedes() %><br>
                Anfitriao: <%= h.getAnfitriaoId().getNome() %><br>
                Esporte: <%= he.getEsporte().getNome() %><br>
                Quantidade de esportistas: <%= he.getQtdEsportista() %><br>
                <br>
                <br>
                
        <%}%>

            </article>
            <!-- Footer -->
            <footer id="footer">

                <ul class="icons">
                    <li><a href="#" class="icon circle fa-twitter"><span class="label">Twitter</span></a></li>
                    <li><a href="#" class="icon circle fa-facebook"><span class="label">Facebook</span></a></li>
                </ul>

                <ul class="copyright">
                    <li>Sinta em casa em qualquer lugar</li><li>Localhost</li>
                </ul>

            </footer>


        </div>

    </body>
</html>
