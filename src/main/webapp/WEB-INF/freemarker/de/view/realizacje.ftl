<#import "../../layout.ftl" as default>
<#import "../../jesteswMacro.ftl" as jestesw>
<#assign lang="de"> 
<#assign title>Strona główna.</#assign>
<#assign js_scripts=scripts["properties/layout/scripts"]> 
<#assign navbar_highlight=xml['//realizacje/${lang}']>

<@default.layout lang title js_scripts navbar_highlight>
<@jestesw.breadcrumbs ["index","realizacje"] lang/>
<#include "../../html/realizacje.html"/>
</@default.layout>

