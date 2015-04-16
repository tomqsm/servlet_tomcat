<#macro tags lang scripts>
<#list scripts as s>
<#list s.* as sc>
<script src="<#if sc.@with?matches("context")>${sc.@with?eval}${sc}<#else>${sc}</#if>"></script>
</#list>
</#list>
</#macro>