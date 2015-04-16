<#import "../../layout.ftl" as default>
<#import "../../jesteswMacro.ftl" as jestesw>
<#assign lang="pl">
<#assign title=xml['//lakierowanie/${lang}']>
<#assign js_scripts=scripts["properties/layout/scripts"]>
<#assign navbar_highlight=xml['//lakierowanie/${lang}']> 

<@default.layout lang title js_scripts navbar_highlight>
<@jestesw.breadcrumbs ["index","podlogi", "lakierowanie"] lang/>
  <#include "../../html/lakierowanie.html"/>
</@default.layout>

