<#import "../../layout.ftl" as default>
<#import "../../jesteswMacro.ftl" as jestesw>
<#assign title>Strona główna.</#assign>
<#assign lang="en"> 
<#assign navbar_highlight=xml['//realizacje/${lang}']> 
<@default.layout lang title scripts["properties/layout/scripts"] navbar_highlight>
<@jestesw.breadcrumbs ["index","firma"] lang/>
<#include "../../html/realizacje.html"/>
</@default.layout>

