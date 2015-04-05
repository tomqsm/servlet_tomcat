<#import "../../../layout.ftl" as default>
<#import "../../../jesteswMacro.ftl" as jestesw>

<#assign lang="de"> 
<#assign navbar_highlight=xml['//cyklinowanie/${lang}']> 

<@default.layout lang xml['//cyklinowanie/${lang}'] navbar_highlight>
  <#include "../../../html/cyklinowanie.html"/>
</@default.layout>

