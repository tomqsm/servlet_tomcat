<#import "../../layout.ftl" as default>
<#import "../../jesteswMacro.ftl" as jestesw>
<#assign title>Strona główna.</#assign>
<#assign lang="de"> 
<#assign navbar_highlight=xml['//firma/${lang}']> 
<@default.layout lang title scripts["properties/layout/scripts"] navbar_highlight>
<@jestesw.breadcrumbs ["index","firma"] lang/>
<#include "../../html/firma.html"/>
</@default.layout>

