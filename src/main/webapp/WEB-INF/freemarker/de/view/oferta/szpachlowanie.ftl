<#import "../../../layout.ftl" as default>
<#import "../../../jesteswMacro.ftl" as jestesw>
<#assign lang="de"> 
<#assign navbar_highlight=xml['//szpachlowanie/${lang}']> 

<@default.layout lang xml['//szpachlowanie/${lang}'] navbar_highlight>
<@jestesw.breadcrumbs ["index","podlogi", "szpachlowanie"] lang/>
  <#include "../../../html/szpachlowanie.html"/>
</@default.layout>

