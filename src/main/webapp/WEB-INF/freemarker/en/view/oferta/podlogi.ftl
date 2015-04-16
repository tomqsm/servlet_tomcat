<#import "../../../layout.ftl" as default>
<#import "../../../jesteswMacro.ftl" as jestesw>
<#assign lang="en"> 
<#assign navbar_highlight=xml['//oferta/${lang}']> 

<@default.layout lang xml['//podlogi/${lang}'] scripts["properties/layout/scripts"] navbar_highlight>
<@jestesw.breadcrumbs ["index","podlogi"] lang/>
  <#include "../../../html/podlogi.html"/>
</@default.layout>

