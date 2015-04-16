<#import "../../layout.ftl" as default>
<#assign title>Strona główna.</#assign>
<#assign lang="de"> 
<#assign navbar_highlight=xml['//index/${lang}']> 

<@default.layout lang title scripts["properties/layout/scripts"] navbar_highlight>
<#include "../../html/carousel.html"/>
<#include "../../html/columns.html"/>
<div class="container">
    <h1>Das ist geil.</h1>
</div>
  <#include "static/artykul1.html"/>
</@default.layout>