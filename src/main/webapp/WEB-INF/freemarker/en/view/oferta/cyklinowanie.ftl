<#import "../../../layout.ftl" as default>
<#import "../../../jesteswMacro.ftl" as jestesw>
<#assign lang="en"> 
<#assign navbar_highlight=xml['//cyklinowanie/${lang}']> 

<@default.layout lang xml['//cyklinowanie/${lang}'] navbar_highlight>
<@jestesw.breadcrumbs ["index","podlogi", "cyklinowanie"] lang/>
  <#include "../../../html/cyklinowanie.html"/>
</@default.layout>

