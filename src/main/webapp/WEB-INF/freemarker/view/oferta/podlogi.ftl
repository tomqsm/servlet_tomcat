<#import "../../layout.ftl" as default>
<#import "../../jesteswMacro.ftl" as jestesw>
<#assign lang="pl">
<#assign title=xml['//podlogi/${lang}']>
<#assign js_scripts=scripts["properties/layout/scripts"]>
<#assign navbar_highlight=xml['//oferta/${lang}']> 

<@default.layout lang title js_scripts navbar_highlight>
<@jestesw.breadcrumbs ["index","podlogi"] lang/>
  <#include "../../html/podlogi.html"/>
</@default.layout>

