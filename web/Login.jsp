<!DOCTYPE HTML>
<!--
	Twenty by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
	<head>
		<title>Localhost</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="assets/css/main.css" />
		<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
		<!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
	</head>
	<body class="index">
		<div id="page-wrapper">

			<!-- Header -->
				<header id="header" class="alt">
					<h1 id="logo"><a href="index.html">LOCALHOST <span>Seu site global de hospedagem</span></a></h1>
					<nav id="nav">
						<ul>
							<li class="current"><a href="index.html">Home</a></li>
							<li class="current"><a href="index.html#main" class="scrolly">Quem Somos</a></li>
							<li><a href="#" class="button special">Login</a></li>
						</ul>
					</nav>
				</header>

			<!-- Banner -->
				<section id="banner">

					<div class="inner">

						<header>
							<h2>Login</h2>
						</header>
						<div class="content">
							<form action="LoginUsuarioServlet" method="POST">
										<div class="row 50%">
											<div class="12u">
												<input type="text" name="username" placeholder="Email" />
											</div>
										</div>
										<div class="row 50%">
											<div class="12u">
												<input type="password" name="password" placeholder="Senha"/>
											</div>
										</div>
										<div class="row">
											<div class="12u">
												<ul class="buttons">
													<li><input type="submit" class="special" value="Entrar" /></li>
												</ul>
											</div>
										</div>
									</form>
                                                                        <% if (request.getAttribute("login_failed") != null) { %>
                                                                            <div>Usuario ou Senha incorreto</div>
                                                                        <% }%>
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