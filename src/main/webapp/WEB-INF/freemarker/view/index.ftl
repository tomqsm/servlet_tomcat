<#import "../layout.ftl" as default>
<#assign title>Strona główna.</#assign>
<#assign lang="pl"> 
<#assign navbar_highlight=xml['//index/${lang}']> 

<@default.layout lang title navbar_highlight>
<#include "../html/carousel.html"/>
<#include "../html/columns.html"/>
<div class="container">
    <h1>Jakaś zawartość tutaj.</h1>
</div>
  <#include "static/artykul1.html"/>
</@default.layout>