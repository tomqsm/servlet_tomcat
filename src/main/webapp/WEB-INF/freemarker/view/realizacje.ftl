<#import "../layout.ftl" as default>
<#import "../jesteswMacro.ftl" as jestesw>
<#assign title>Realizacje</#assign>
<#assign lang="pl"> 
<#assign navbar_highlight=xml['//realizacje/${lang}']> 

<@default.layout lang title navbar_highlight>
<@jestesw.breadcrumbs ["index","realizacje"] lang/>
  <#include "../html/realizacje.html"/>
<div class="container">
    <p>Wykonane projekty ...</p>
</div>
</@default.layout>

