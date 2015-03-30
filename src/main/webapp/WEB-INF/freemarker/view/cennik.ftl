<#import "../layout.ftl" as default>
<#assign title>Cennik</#assign>
<#assign lang="pl"> 
<#assign navbar_highlight=xml['//cennik/${lang}']> 

<@default.layout lang title navbar_highlight>
  <#include "../html/cennik.html"/>
</@default.layout>

