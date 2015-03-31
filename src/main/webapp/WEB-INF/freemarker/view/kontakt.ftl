<#import "../layout.ftl" as default>
<#assign lang="pl"> 
<#assign navbar_highlight=xml['//kontakt/${lang}']> 

<@default.layout lang xml['//kontakt/${lang}'] navbar_highlight>
  <#include "../html/kontakt.html"/>
</@default.layout>

