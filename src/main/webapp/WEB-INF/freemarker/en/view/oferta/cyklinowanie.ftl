<#import "../../../layout.ftl" as default>
<#assign lang="en"> 
<#assign navbar_highlight=xml['//cyklinowanie/${lang}']> 

<@default.layout lang xml['//cyklinowanie/${lang}'] scripts["properties/layout/scripts"] navbar_highlight>
  <#include "../../../html/cyklinowanie.html"/>
</@default.layout>

