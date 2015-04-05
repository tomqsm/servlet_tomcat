<#import "../../layout.ftl" as default>
<#import "../../jesteswMacro.ftl" as jestesw>
<#assign lang="pl"> 
<#assign navbar_highlight=xml['//lakierowanie/${lang}']> 

<@default.layout lang xml['//lakierowanie/${lang}'] navbar_highlight>
<@jestesw.breadcrumbs ["index","podlogi", "lakierowanie"] lang/>
  <#include "../../html/lakierowanie.html"/>
</@default.layout>

