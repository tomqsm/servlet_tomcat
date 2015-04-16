<#import "../../layout.ftl" as default>
<#import "../../jesteswMacro.ftl" as jestesw>
<#assign title>Contact</#assign>
<#assign lang="en"> 
<#assign navbar_highlight=xml['//kontakt/${lang}']> 
<@default.layout lang title navbar_highlight>
<@jestesw.breadcrumbs ["index","kontakt"] lang/>
<#include "../../html/kontakt.html"/>
</@default.layout>

