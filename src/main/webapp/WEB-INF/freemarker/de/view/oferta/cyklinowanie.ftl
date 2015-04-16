<#import "../../../layout.ftl" as default>
<#import "../../../jesteswMacro.ftl" as jestesw>
<#assign lang="de">
<#assign title=xml['//cyklinowanie/${lang}']>
<#assign js_scripts=scripts['//layout/scripts']> 
<#assign navbar_highlight=xml['//cyklinowanie/${lang}']> 

<@default.layout lang title js_scripts navbar_highlight>
<@jestesw.breadcrumbs ["index","podlogi", "cyklinowanie"] lang/>
  <#include "../../../html/cyklinowanie.html"/>
</@default.layout>

