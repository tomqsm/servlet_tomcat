<#import "../layout.ftl" as default>
<#import "../jesteswMacro.ftl" as jestesw>
<#assign title>Firma</#assign>
<#assign lang="pl"> 
<#assign navbar_highlight=xml['//firma/${lang}']> 
<@default.layout lang title navbar_highlight>
<@jestesw.breadcrumbs ["index","firma"] lang/>
  <#include "../html/firma.html"/>
</@default.layout>
