<#ftl>
<#assign firm = xml["properties/header/firm/${locale}"]>
<#assign address = xml["properties/header/country/${locale}"]>
<#assign title = xml["properties/head/title/${locale}"]>
<#assign jquery = xml["properties/head/jquery"]>
<#assign jqueryUi = xml["properties/head/jqueryUi"]>
<#assign cssMain = xml["properties/head/cssMain"]>
<!DOCTYPE HTML>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="author" content="Tomasz Kusmierczyk">
	<meta name="description" content="Programming services, web development.">
        <link rel="stylesheet" type="text/css" media="screen" href="/servlet_tomcat/${cssMain}" />
	<meta name="viewport" content="width=device-width">
	<title>${title}</title>
        <script src="${jquery}"></script>
        <script src="${jqueryUi}"></script>
        <script src="/servlet_tomcat/js/user.js"></script>
        <script>
            $(document).ready(function() {
                var demo = $('#userSpan').demo();
            });
        </script>
</head>
<body>
	<header>
        <div id="userSpan"></div>
        <img src="/servlet_tomcat/images/animage.jpg">
            h4. Last check for ${firm} locale: ${locale}
            ${address}
		<nav>
			<ul>
				<li>Your menu</li>
			</ul>
		</nav>
	</header>
	
	<section>

		<article>
			<header>
				<h2>Article title</h2>
				<p>Posted on <time datetime="2009-09-04T16:31:24+02:00">September 4th 2009</time> by <a href="#">Writer</a> - <a href="#comments">6 comments</a></p>
			</header>
			<p>Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.</p>
		</article>
		
		<article>
			<header>
				<h2>Article title</h2>
				<p>Posted on <time datetime="2009-09-04T16:31:24+02:00">September 4th 2009</time> by <a href="#">Writer</a> - <a href="#comments">6 comments</a></p>
			</header>
			<p>Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.</p>
		</article>
		
	</section>

	<aside>
		<h2>About section</h2>
		<p>Donec eu libero sit amet quam egestas semper. Aenean ultricies mi vitae est. Mauris placerat eleifend leo.</p>
	</aside>

	<footer>
		<p>Copyright 2009 Your name</p>
	</footer>

</body>
</html>