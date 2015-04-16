<#import "../../../layout.ftl" as default>
<#assign lang="de"> 
<#assign navbar_highlight=xml['//lakierowanie/${lang}']> 

<@default.layout lang xml['//lakierowanie/${lang}'] scripts["properties/layout/scripts"] navbar_highlight>
  <#include "../../../html/lakierowanie.html"/>
</@default.layout>

