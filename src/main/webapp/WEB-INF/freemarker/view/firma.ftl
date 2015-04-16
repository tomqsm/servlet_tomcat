<#import "../layout.ftl" as default>
<#import "../jesteswMacro.ftl" as jestesw>
<#assign title>Firma</#assign>
<#assign lang="pl"> 
<#assign navbar_highlight=xml['//firma/${lang}']>
<#assign js_scripts=scripts["properties/layout/scripts"]> 

<@default.layout lang title js_scripts navbar_highlight>
<@jestesw.breadcrumbs ["index","firma"] lang/>
  <#include "../html/firma.html"/>
</@default.layout>
