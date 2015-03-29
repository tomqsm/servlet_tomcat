<#macro info lang principalName>
<#if principalName=="undefined"><#assign isLoggedIn="false"><#else><#assign isLoggedIn="true"></#if>
<#if isLoggedIn?boolean && lang="pl">
<div class="alert alert-success">
    Jesteś obecnie zalogowany. Witaj: ${principalName}
<a href="#" class="close" data-dismiss="alert">&times;</a>
</div>
    <#elseif lang=="en">You are logged in. Welcome: ${principalName}
    <#elseif lang=="de">Do bist logged in. Wilkomen: ${principalName}
<#else></#if>
</#macro>