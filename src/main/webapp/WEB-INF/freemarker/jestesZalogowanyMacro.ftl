<#macro info lang principalName>
<#if principalName=="undefined"><#assign isLoggedIn="false"><#else><#assign isLoggedIn="true"></#if>
<#if isLoggedIn?boolean && lang=="pl">
    Jesteś obecnie zalogowany. Witaj: ${principalName}
    <#elseif isLoggedIn?boolean && lang=="en">You are logged in. Welcome: ${principalName}
    <#elseif isLoggedIn?boolean && lang=="de">Do bist logged in. Wilkomen: ${principalName}
<#else></#if>
</#macro>