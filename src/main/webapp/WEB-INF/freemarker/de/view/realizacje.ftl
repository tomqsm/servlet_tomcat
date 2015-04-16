<#import "../../layout.ftl" as default>
<#import "../../jesteswMacro.ftl" as jestesw>
<#assign title>Strona główna.</#assign>
<#assign lang="de"> 
<#assign navbar_highlight=xml['//realizacje/${lang}']>
<#assign js_scripts=scripts["properties/layout/scripts"]> 

<@default.layout lang title js_scripts navbar_highlight>
<@jestesw.breadcrumbs ["index","realizacje"] lang/>
<#include "../../html/realizacje.html"/>
</@default.layout>

