<#import "../../layout.ftl" as default>
<#import "../../jesteswMacro.ftl" as jestesw>
<#assign lang="pl"> 
<#assign navbar_highlight=xml['//cyklinowanie/${lang}']> 

<@default.layout lang xml['//cyklinowanie/${lang}'] scripts["properties/layout/scripts"] navbar_highlight>
<@jestesw.breadcrumbs ["index","podlogi", "cyklinowanie"] lang/>
  <#include "../../html/cyklinowanie.html"/>
</@default.layout>