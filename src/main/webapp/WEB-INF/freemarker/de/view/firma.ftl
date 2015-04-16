<#import "../../layout.ftl" as default>
<#import "../../jesteswMacro.ftl" as jestesw>
<#assign lang="de"> 
<#assign title>xml['//firma/${lang}']</#assign>
<#assign js_scripts=scripts["properties/layout/scripts"]> 
<#assign navbar_highlight=xml['//firma/${lang}']> 

<@default.layout lang title js_scripts navbar_highlight>
<@jestesw.breadcrumbs ["index","firma"] lang/>
<#include "../../html/firma.html"/>
</@default.layout>

