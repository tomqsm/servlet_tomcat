<#import "../../layout.ftl" as default>
<#assign lang="pl"> 
<#assign navbar_highlight=xml['//oferta/${lang}']> 

<@default.layout lang xml['//podlogi/${lang}'] navbar_highlight>
  <#include "../../html/podlogi.html"/>
</@default.layout>

