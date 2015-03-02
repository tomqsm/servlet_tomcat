<#ftl>
<#assign scripts = scripts["properties/scripts"]>
<#assign csses = csses["properties/csses"]>
<#escape x as x?html></#escape>
<!DOCTYPE HTML>
<html lang="pl">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="author" content="Tomasz Kusmierczyk">
        <meta name="description" content="Programming services, web development.">
        <meta name="viewport" content="width=device-width">
        <title></title>
        <#list csses as c>
            <#list c.* as css>
            <link rel="stylesheet" type="text/css" media="${css.@media}" href="<#if css.@with?matches("context")>${css.@with?eval}${css}<#else>${css}</#if>" />
            </#list>
        </#list>
        <#list scripts as s>
            <#list s.* as sc>
            <script src="<#if sc.@with?matches("context")>${sc.@with?eval}${sc}<#else>${sc}</#if>"></script>
            </#list>
        </#list>
        <script>
            $(document).ready(function() {
                var demo = $('#userSpan').demo();
            });
        </script>
    </head>
    <body>
        <header>
            <div id="userSpan"></div>
            <img src="${context}/images/animage.jpg">
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
                <p>Request: ${context}</p>
            </article>
		
            <article>
                <header>
                    <h2>Article title</h2>
                    <p>Posted on <time datetime="2009-09-04T16:31:24+02:00">September 4th 2009</time> by <a href="#">Writer</a> - <a href="#comments">6 comments</a></p>
                </header>
                <p>Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.</p>
            </article>
        </section>
        <script type="text/html" id="userTemplate">
            <table cellspacing='0' cellpadding='0' border='1' >
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                    </tr>
                </thead>
                <tbody>
        <% _.each(items,function(item,key,list){ 
            // create more variables
            var f = item.name.split("").shift().toLowerCase(); 
        %>
                <tr>
                    <!-- use variables -->
                    <td><%= key %></td>
                    <td class="<%= f %>"><%= item.name %></td>
                </tr>
        <% }); %>
                </tbody>
            </table>
        </script>
        <aside>
            <h2>Script</h2>
            <span class="glyphicons glyphicons-server-minus"></span>
            <!-- Create your target -->
            <div id="target"></div>
        </aside>
<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
          <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
          <li data-target="#carousel-example-generic" data-slide-to="1"></li>
          <li data-target="#carousel-example-generic" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner" role="listbox">
          <div class="item active">
            <img data-src="holder.js/1140x500/auto/#777:#555/text:First slide" alt="First slide">
          </div>
          <div class="item">
            <img data-src="holder.js/1140x500/auto/#666:#444/text:Second slide" alt="Second slide">
          </div>
          <div class="item">
            <img data-src="holder.js/1140x500/auto/#555:#333/text:Third slide" alt="Third slide">
          </div>
        </div>
        <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
          <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
          <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
          <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
          <span class="sr-only">Next</span>
        </a>
      </div>
        <footer>
            <p>Copyright 2009 Your name</p>
        </footer>
<debug>
<h3>App info</h3>
<ul>
<li>Pliki CSS: ${csses["count(//css)"]}</li>
<li>Pliki JS: ${scripts["count(//script)"]}</li>
</ul>
</debug>

    </body>
</html>