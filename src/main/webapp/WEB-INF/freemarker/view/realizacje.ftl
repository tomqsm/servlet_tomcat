<#import "../layout.ftl" as default>
<#assign title>Strona główna.</#assign>
<#assign lang="pl"> 
<#assign navbar_highlight=xml['//realizacje/${lang}']> 

<@default.layout lang title navbar_highlight>
  <#include "../html/realizacje.html"/>
<div class="container">
    <p>Wykonane projekty ...</p>
</div>
</@default.layout>

