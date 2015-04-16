<#import "../../layout.ftl" as default>
<#import "../../jesteswMacro.ftl" as jestesw>
<#assign title>Contact</#assign>
<#assign lang="en"> 
<#assign navbar_highlight=xml['//kontakt/${lang}']> 
<@default.layout lang title scripts["properties/layout/scripts"] navbar_highlight>
<@jestesw.breadcrumbs ["index","firma"] lang/>
<#include "../../html/kontakt.html"/>
</@default.layout>

