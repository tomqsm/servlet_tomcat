<#macro layout lang title navbar_highlight>
<#assign queryString=(request.queryString)!>
<#if queryString != ""><#assign queryString="?"+queryString></#if>
<#assign servletPathQueryString=(request.requestURI)?replace(context,"")+queryString>
<#assign principalName=(request.userPrincipal.name)!"undefined">
<#if principalName=="undefined"><#assign isLoggedIn="false"><#else><#assign isLoggedIn="true"></#if>
<!DOCTYPE html>
<html lang="${lang}">
    <head>
        <#include "html/head.html"/>
    </head>
    <body>
        <#include "html/navbar.html"/>
        <div id="maincontainer"><!-- maincontainer start -->
            <#nested/><!-- default body from page view -->
            <footer>
                <p class="pull-right"><a href="#">Na początek strony</a></p>
                <p>&copy; 2015 Company, Inc. &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>
            </footer>
        </div><!-- maincontainer end -->
        <div id="loadJsonOnClick">test loading json tutaj</div>
        <div id="loadJsonOnClickNSecDelay">test loading json with timeout tutaj</div>
        <#--<#include "html/diagnostics.html"/>-->
        <#include "html/diagnostics.html"/>
    </body>
</html>
</#macro>