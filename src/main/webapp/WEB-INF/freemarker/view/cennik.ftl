<#import "../layout.ftl" as default>
<#assign lang="pl"> 
<#assign navbar_highlight=xml['//cennik/${lang}']> 

<@default.layout lang xml['//cennik/${lang}'] navbar_highlight>
  <#include "../html/cennik.html"/>
</@default.layout>

