<#import "../../layout.ftl" as default>
<#import "../../jesteswMacro.ftl" as jestesw>
<#assign title>Price list</#assign>
<#assign lang="en"> 
<#assign navbar_highlight=xml['//cennik/${lang}']> 
<@default.layout lang title scripts["properties/layout/scripts"] navbar_highlight>
<@jestesw.breadcrumbs ["index","cennik"] lang/>
<#include "../../html/cennik.html"/>
</@default.layout>

