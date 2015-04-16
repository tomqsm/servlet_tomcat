<#import "../layout.ftl" as default>
<#import "../jesteswMacro.ftl" as jestesw>
<#assign lang="pl"> 
<#assign title>Firma</#assign>
<#assign js_scripts=scripts["properties/layout/scripts"]> 
<#assign navbar_highlight=xml['//firma/${lang}']>

<@default.layout lang title js_scripts navbar_highlight>
<@jestesw.breadcrumbs ["index","firma"] lang/>
  <#include "../html/firma.html"/>
</@default.layout>
