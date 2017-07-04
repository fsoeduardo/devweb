<%@page import="Model.Avaliacaohospedagem"%>
<%@page import="Model.Avaliacaosaida"%>
<%@page import="Model.Avaliacaoamizade"%>
<%@page import="DAO.AvaliacoesDAO"%>
<%@page import="Model.Usuario"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<!--
        Twenty by HTML5 UP
        html5up.net | @ajlkn
        Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
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
                        <li><a href="login.jsp" class="button special">Sair</a></li>
                    </ul>
                </nav>
            </header>

            <!-- Main -->
            <article id="main">
                <% Usuario user = ((Usuario) request.getAttribute("user"));%>
                <header class="special container">
                    <span class="icon fa-plane"></span>
                    <h2>Bem-vindo <strong> <a href="PerfilServlet?id=<%= request.getSession().getAttribute("logadoid")%>"> <%= request.getSession().getAttribute("logadonome")%> </a> </strong></h2>
                    <p>Navegue em nosso site e busque a sua hospedagem ideal.</p>
                </header>

                <!-- One -->
                <section class="wrapper style4 container">

                    <div class="row 150%">
                        <div class="4u 12u(narrower)">

                            <!-- Sidebar -->
                            <div class="sidebar">
                                <section>
                                    <a href="#" class="image featured"><img src="images/avatar.png" alt="" /></a>
                                    <header>
                                        <h3>Perfil de <strong> <%= user.getNome()%> </strong> </h3>
                                    </header>
                                    <p> <%= user.getDescricao() %> </p>
                                    <% if (user.getRecebeVisita() == true) {%>
                                    <span class="icon fa-plane"></span>Status: Disponivel para hospedar</br>
                                    <%} else { %>
                                    <span class="icon fa-plane"></span>Status: Indisponivel para hospedar</br>
                                    <%}%>        									
                                    <span class="icon fa-home"></span>Localidade: <%= user.getCidadeFk().getEstadoFk().getNome()%>, <%= user.getCidadeFk().getEstadoFk().getPaisFk().getNome()%> </br>
                                    <span class="icon fa-futbol-o"></span>Esporte: <%= user.getEsporteFk().getNome()%></br>
                                    <span class="icon fa-users"></span>Número de Visitantes: <%= user.getMaxVisitante()%> </br>
                                    <span class="icon fa-envelope  "></span>Contato: <%= user.getEmail()%>  </br>
                                    <span class="icon fa-star"></span> Média de Estrelas: <%= AvaliacoesDAO.getmedia(user.getId()) %> </br>  
                                </section>
                            </div>

                        </div>
                        <div class="8u 12u(narrower) important(narrower)">

                            <!-- Content -->
                            <div class="content">
                                <section>
                                    <a href="#" class="image featured"><img src="images/cover.jpg" alt="" /></a>
                                    <header>
                                        <h3>Recomendações por amizades</h3>
                                    </header>
                                    <% for (Avaliacaoamizade aux : AvaliacoesDAO.getamizade(user.getId())) {%>
                                    <p>
                                    <div class="row 50%">
                                        <div class="6u 12u(mobile)">
                                            Nome: <a href="PerfilServlet?id=<%=aux.getAvaliadorFk().getId()%>"> <%= aux.getAvaliadorFk().getNome()%></a>
                                        </div>
                                        <div class="6u 12u(mobile)">
                                            <span class="icon fa-star"></span>Número estrelas:  <%= aux.getNota()%>
                                        </div>
                                    </div>
                                    </p>
                                    <p>Recomendação: <%= aux.getText()%>.</p>
                                    <% }%>


                                    <header>
                                        <h3>Recomendações dos hospedes</h3>
                                    </header>
                                    <% for (Avaliacaohospedagem aux : AvaliacoesDAO.getanfitriao(user.getId())) {%>
                                    <p>
                                    <div class="row 50%">
                                        <div class="6u 12u(mobile)">
                                            Nome: <a href="PerfilServlet?id=<%=aux.getHospedeFk().getId()%>"> <%= aux.getHospedeFk().getNome()%></a>
                                        </div>
                                        <div class="6u 12u(mobile)">
                                            <span class="icon fa-star"></span>Número estrelas: <%= aux.getNotaAnfitriao()%> 
                                        </div>
                                    </div>
                                    </p>
                                    <p>Recomendação: <%= aux.getAvaAnfitriaoText()%>.</p>
                                    <% }%>

                                    <header>
                                        <h3>Recomendações do anfitrião</h3>
                                    </header>
                                    <% for (Avaliacaohospedagem aux : AvaliacoesDAO.gethospede(user.getId())) {%>
                                    <p>
                                    <div class="row 50%">
                                        <div class="6u 12u(mobile)">
                                            Nome: <a href="PerfilServlet?id=<%=aux.getAnfitriaoFk().getId()%>"> <%= aux.getAnfitriaoFk().getNome()%></a>
                                        </div>
                                        <div class="6u 12u(mobile)">
                                            <span class="icon fa-star"></span>Número estrelas: <%= aux.getNotaHospede()%>
                                        </div>
                                    </div>
                                    </p>
                                    <p>Recomendação: <%= aux.getAvaHospedeText()%>.</p>
                                    <% }%>												
                                    <header>
                                        <h3>Recomendações de Saida por esportes</h3>
                                    </header>
                                    <% for (Avaliacaosaida aux : AvaliacoesDAO.getrecsaida(user.getId())) {%>
                                    <p>
                                    <div class="row 50%">
                                        <div class="6u 12u(mobile)">
                                            Nome: <a href="PerfilServlet?id=<%=aux.getAvaliadorFk().getId()%>"> <%= aux.getAvaliadorFk().getNome()%></a> 
                                        </div>
                                        <div class="6u 12u(mobile)">
                                            <span class="icon fa-star"></span>Número estrelas: <%= aux.getNota()%>
                                        </div>
                                    </div>
                                    </p>
                                    <p>Recomendação: <%= aux.getText()%>.</p>
                                    <% }%>												

                                </section>
                            </div>

                        </div>
                    </div>
                </section>

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

        <!-- Scripts -->
        <script src="assets/js/jquery.min.js"></script>
        <script src="assets/js/jquery.dropotron.min.js"></script>
        <script src="assets/js/jquery.scrolly.min.js"></script>
        <script src="assets/js/jquery.scrollgress.min.js"></script>
        <script src="assets/js/skel.min.js"></script>
        <script src="assets/js/util.js"></script>
        <!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
        <script src="assets/js/main.js"></script>

    </body>
</html>