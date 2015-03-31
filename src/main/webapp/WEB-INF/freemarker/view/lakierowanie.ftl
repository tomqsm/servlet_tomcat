<#import "../layout.ftl" as default>
<#assign lang="pl"> 
<#assign navbar_highlight=xml['//lakierowanie/${lang}']> 

<@default.layout lang xml['//lakierowanie/${lang}'] navbar_highlight>
  <#include "../html/lakierowanie.html"/>
<div class="container">
    <p>Informacje o lakierowaniu podłóg ...</p>
</div>
</@default.layout>

