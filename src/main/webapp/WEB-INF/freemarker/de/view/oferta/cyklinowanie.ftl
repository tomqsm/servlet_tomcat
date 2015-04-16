<#import "../../../layout.ftl" as default>
<#import "../../../jesteswMacro.ftl" as jestesw>

<#assign lang="de"> 
<#assign js_scripts=scripts['//layout/scripts']> 
<#assign navbar_highlight=xml['//cyklinowanie/${lang}']> 

<@default.layout lang xml['//cyklinowanie/${lang}'] scripts["properties/layout/scripts"] navbar_highlight>
  <#include "../../../html/cyklinowanie.html"/>
</@default.layout>

