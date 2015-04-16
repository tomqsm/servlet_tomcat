<#import "../../layout.ftl" as default>
<#assign title>Strona główna.</#assign>
<#assign lang="en"> 
<#assign navbar_highlight=xml['//index/${lang}']> 

<@default.layout lang title scripts["properties/layout/scripts"] navbar_highlight>
<#include "../../html/carousel.html"/>
<#include "../../html/columns.html"/>
<div class="container">
    <h1>Some content here.</h1>
</div>
  <#include "static/artykul1.html"/>
</@default.layout>

