<#import "../../../layout.ftl" as default>
<#assign lang="en"> 
<#assign navbar_highlight=xml['//oferta/${lang}']> 

<@default.layout lang xml['//podlogi/${lang}'] navbar_highlight>
  <#include "../../../html/podlogi.html"/>
</@default.layout>

