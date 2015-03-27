<#macro layout title>
<#if locale??><#else><#assign locale="pl"></#if>
<#setting locale=locale>
<#assign queryString=(request.queryString)!>
<#if queryString != ""><#assign queryString="?"+queryString></#if>
<#assign servletPathQueryString=(request.requestURI)?replace(context,"")+queryString>
<#assign principalName=(request.userPrincipal.name)!"undefined">
<#if principalName=="undefined"><#assign isLoggedIn="false"><#else><#assign isLoggedIn="true"></#if>
<!DOCTYPE html>
  <html lang="${locale}">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href="../../favicon.ico">
        <title>${title}</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css" rel="stylesheet">
        <script>
            var appInit = {
                context: '${context}'
            };
        </script>
        <#assign scripts = scripts["properties/scripts"]> 
        <#list scripts as s>
                <#list s.* as sc>
        <script src="<#if sc.@with?matches("context")>${sc.@with?eval}${sc}<#else>${sc}</#if>"></script>
        </#list>
        </#list>
        <!-- Custom styles for this template -->
        <link href="${context}/css/carousel.css" rel="stylesheet"/>
        <style>
            .carousel-inner > .item > img,
            .carousel-inner > .item > a > img {
                width: 70% ;
                margin: auto;
            }
        </style>
    </head>
    <body>
        <#include "html/diagnostics.html"/>
        <#--<#include "html/navbar.html"/>-->
        <div id="maincontainer"><!-- maincontainer start -->
            <#include "html/carousel.html"/>
            <#include "html/columns.html"/>
            <footer>
                <p class="pull-right"><a href="#">Na początek strony</a></p>
                <p>&copy; 2015 Company, Inc. &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>
            </footer>
        </div><!-- maincontainer end -->
        <div id="loadJsonOnClick">test loading json tutaj</div>
        <div id="loadJsonOnClickNSecDelay">test loading json with timeout tutaj</div>
    </body>
  </html>
</#macro>