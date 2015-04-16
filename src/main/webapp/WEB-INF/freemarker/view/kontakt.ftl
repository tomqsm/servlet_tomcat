<#import "../layout.ftl" as default>
<#import "../jesteswMacro.ftl" as jestesw>
<#assign lang="pl"> 
<#assign navbar_highlight=xml['//kontakt/${lang}']>
<#assign js_scripts=scripts["properties/layout/scripts"]> 

<@default.layout lang xml['//kontakt/${lang}'] js_scripts navbar_highlight>
<@jestesw.breadcrumbs ["index","kontakt"] lang/>
  <#include "../html/kontakt.html"/>
</@default.layout>

