<#import "../layout.ftl" as default>
<#assign title>Kontakt</#assign>
<#assign lang="pl"> 
<#assign navbar_highlight=xml['//kontakt/${lang}']> 

<@default.layout lang title navbar_highlight>
  <#include "../html/kontakt.html"/>
<div class="container">
    <p>Dane kontaktowe</p>
</div>
</@default.layout>
