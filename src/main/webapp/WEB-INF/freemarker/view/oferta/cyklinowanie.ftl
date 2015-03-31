<#import "../../layout.ftl" as default>
<#assign lang="pl"> 
<#assign navbar_highlight=xml['//cyklinowanie/${lang}']> 

<@default.layout lang xml['//cyklinowanie/${lang}'] navbar_highlight>
  <#include "../../html/cyklinowanie.html"/>
</@default.layout>

