<#import "../../layout.ftl" as default>
<#import "../../jesteswMacro.ftl" as jestesw>
<#assign lang="de"> 
<#assign title>Strona główna.</#assign>
<#assign js_scripts=scripts["properties/layout/scripts"]> 
<#assign navbar_highlight=xml['//kontakt/${lang}']> 
<@default.layout lang title js_scripts navbar_highlight>
<@jestesw.breadcrumbs ["index","kontakt"] lang/>
<#include "../../html/kontakt.html"/>
</@default.layout>

