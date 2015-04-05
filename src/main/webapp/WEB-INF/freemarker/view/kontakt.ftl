<#import "../layout.ftl" as default>
<#import "../jesteswMacro.ftl" as jestesw>
<#assign lang="pl"> 
<#assign navbar_highlight=xml['//kontakt/${lang}']> 
<@default.layout lang xml['//kontakt/${lang}'] navbar_highlight>
<@jestesw.breadcrumbs ["index","kontakt"] lang/>
  <#include "../html/kontakt.html"/>
</@default.layout>

