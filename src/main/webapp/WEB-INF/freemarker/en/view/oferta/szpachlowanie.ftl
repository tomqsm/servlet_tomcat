<#import "../../../layout.ftl" as default>
<#assign lang="en"> 
<#assign navbar_highlight=xml['//szpachlowanie/${lang}']> 

<@default.layout lang xml['//szpachlowanie/${lang}'] navbar_highlight>
  <#include "../../../html/szpachlowanie.html"/>
</@default.layout>

