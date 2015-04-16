<#macro layout lang title js_scripts navbar_highlight>
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
        <#list js_scripts as s>
        <#list s.* as sc>
        <script src="<#if sc.@with?matches("context")>${sc.@with?eval}${sc}<#else>${sc}</#if>"></script>
        </#list>
        </#list>
    </head>
    <body>
        <div class="container"><@jestesZalogowany.info lang principalName/></div>
        <#include "html/navbar.html"/>
        <div id="maincontainer"><!-- maincontainer start -->
            <#nested/><!-- default body from page view -->
        </div><!-- maincontainer end -->
        <#include "html/footer.html"/>
        <#--<#include "html/diagnostics.html"/>-->
    </body>
</html>
</#macro>