<#import "../../layout.ftl" as default>
<#import "../../jesteswMacro.ftl" as jestesw>
<#assign lang="en"> 
<#assign title>Price list</#assign>
<#assign js_scripts=scripts["properties/layout/scripts"]> 
<#assign navbar_highlight=xml['//cennik/${lang}']>

<@default.layout lang title js_scripts navbar_highlight>
<@jestesw.breadcrumbs ["index","cennik"] lang/>
<#include "../../html/cennik.html"/>
</@default.layout>

