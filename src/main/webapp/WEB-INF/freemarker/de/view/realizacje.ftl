<#import "../../layout.ftl" as default>
<#import "../../jesteswMacro.ftl" as jestesw>
<#assign title>Strona główna.</#assign>
<#assign lang="de"> 
<#assign navbar_highlight=xml['//realizacje/${lang}']> 
<@default.layout lang title navbar_highlight>
<@jestesw.breadcrumbs ["index","realizacje"] lang/>
<#include "../../html/realizacje.html"/>
</@default.layout>

