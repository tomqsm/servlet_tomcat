<#macro breadcrumbs listUrl lang>
<div class="container"><#list listUrl as crumb>
    <a class="<#if crumb_has_next>back<#else></#if>" href="<#if crumb_has_next>${response.encodeURL(xml['//${crumb}/${lang}/@url'])}<#else>#</#if>">${xml['//${crumb}/${lang}']}</a><#if crumb_has_next> &rarr;</#if>
</#list></div>
</#macro>