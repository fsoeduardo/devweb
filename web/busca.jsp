<%-- 
    Document   : busca
    Created on : 02/07/2017, 13:18:58
    Author     : Ricardo  Junior
--%>

<%@page import="Model.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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

                <article id="main">

                    <% Usuario user = ((Usuario) request.getAttribute("user"));%>
                    <header class="special container">
                        <span class="icon fa-plane"></span>
                        <h2>Bem-vindo <strong> <a href="PerfilServlet?id=<%= request.getSession().getAttribute("logadoid")%>"> <%= request.getSession().getAttribute("logadonome")%> </a> </strong></h2>
                        <p>Navegue em nosso site e busque a sua hospedagem ideal.</p>
                    </header>
                    <form action="buscaservlet" method="GET">
                        <input type="text" name="pais" placeholder="País" required />
                        <input type="text" name="cidade" placeholder="Cidade" required/>
                        <input type="submit" value="Pesquisar" />
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
