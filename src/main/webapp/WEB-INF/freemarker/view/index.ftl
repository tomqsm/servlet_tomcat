<#import "../layout.ftl" as default>
<#assign lang="pl"> 
<#assign title=xml['//index/${lang}']>
<#assign js_scripts=scripts["properties/layout/scripts"]> 
<#assign navbar_highlight=xml['//index/${lang}']> 

<@default.layout lang title js_scripts navbar_highlight>
<#include "../html/carousel.html"/>
<#include "../html/columns.html"/>
<div class="container">
    <h1>Jakaś zawartość tutaj. ${config.resources.URL}</h1>
</div>
  <#include "static/artykul1.html"/>
</@default.layout>