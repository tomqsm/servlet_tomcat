<#import "../layout.ftl" as default>
<#import "../jesteswMacro.ftl" as jestesw>
<#assign lang="pl"> 
<#assign navbar_highlight=xml['//cennik/${lang}']> 

<@default.layout lang xml['//cennik/${lang}'] navbar_highlight>
<@jestesw.breadcrumbs ["index","cennik"] lang/>
  <#include "../html/cennik.html"/>
</@default.layout>

