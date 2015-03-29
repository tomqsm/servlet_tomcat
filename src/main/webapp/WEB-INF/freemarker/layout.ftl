<#macro layout lang title navbar_highlight>
<#import "jestesZalogowanyMacro.ftl" as jestesZalogowany>
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
        <@jestesZalogowany.info lang principalName/>
        <#include "html/navbar.html"/>
        <div id="maincontainer"><!-- maincontainer start -->
            <#nested/><!-- default body from page view -->
        </div><!-- maincontainer end -->
        <#include "html/footer.html"/>
        <#--<#include "html/diagnostics.html"/>-->
    </body>
</html>
</#macro>