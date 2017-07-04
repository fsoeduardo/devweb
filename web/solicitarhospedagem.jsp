<%-- 
    Document   : solicitarhospedagem
    Created on : 02/07/2017, 18:30:38
    Author     : Ricardo  Junior
--%>

<%@page import="Model.Usuario"%>
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
                    <h1 id="logo"><a href="index.jsp">Localhost <span>Seu site global de hospedagem</span></a></h1>
                    <nav id="nav">
                        <ul>
                            <li class="current"><a href="index.jsp">Home</a></li>
                            <li class="current"><a href="index.jsp#main" class="scrolly">Quem Somos</a></li>
                            <li class="current"><a href="busca.jsp" class="scrolly">Buscar hospedagens</a></li>
                            <li class="current"><a href="pedidodesolicitacoes.jsp" class="scrolly">Pedidos de hospedagens</a></li>
                            <li class="current"><a href="solicitacoesfeitas.jsp" class="scrolly">Hospedagens solicitadas</a></li>
                            <li><a href="login.jsp" class="button special">Sair</a></li>
                        </ul>
                    </nav>
                </header>

                <article id="main">
                    <% Usuario user = ((Usuario) request.getAttribute("user"));%>
                    <header class="special container">
                        <span class="icon fa-plane"></span>
                        <h2>Bem-vindo <strong> <a href="PerfilServlet?id=<%= request.getSession().getAttribute("logadoid")%>"> <%= request.getSession().getAttribute("logadonome")%> </a> </strong></h2>
                        <p>Navegue em nosso site e busque a sua hospedagem ideal.</p>
                    </header>


                    <form action="CriarHospedagemServlet" method="GET">
                        <input type="number" name="qtd_hospede" placeholder="Quantidade de hospedes" required />
                        <input type="date" name="data_inicio" placeholder="Data de inicio dd-mm-aaaa" required/>
                        <input type="date" name="data_termino" placeholder="Data de termino dd-mm-aaaa" required/>
                        <input type="number" name="qtd_esportista" placeholder="Quantidade de esportistas" required />
                        <input type="hidden" name="anfitriao" value="<%= request.getParameter("anfitriao")%>">
                        <select  name="esporte">
                            <% for (Esporte aux : EsporteDAO.getesportes()) {%> 
                                 <option value="<%=aux.getId()%>"> <%= aux.getNome()%> </option>
                            <%}%>
                        </select>
                        <input type="submit" value="Enviar solicitacao de hospedagem" />
                    </form>
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
