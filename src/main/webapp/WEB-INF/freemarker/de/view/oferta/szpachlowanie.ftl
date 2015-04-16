<#import "../../../layout.ftl" as default>
<#import "../../../jesteswMacro.ftl" as jestesw>
<#assign lang="de">
<#assign title=xml['//szpachlowanie/${lang}']>
<#assign js_scripts=scripts["properties/layout/scripts"]> 
<#assign navbar_highlight=xml['//szpachlowanie/${lang}']> 

<@default.layout lang title js_scripts navbar_highlight>
<@jestesw.breadcrumbs ["index","podlogi", "szpachlowanie"] lang/>
  <#include "../../../html/szpachlowanie.html"/>
</@default.layout>

