<#import "../../layout.ftl" as default>
<#import "../../jesteswMacro.ftl" as jestesw>
<#assign lang="pl"> 
<#assign navbar_highlight=xml['//oferta/${lang}']> 

<@default.layout lang xml['//podlogi/${lang}'] navbar_highlight>
<@jestesw.breadcrumbs ["index","podlogi"] lang/>
  <#include "../../html/podlogi.html"/>
</@default.layout>

