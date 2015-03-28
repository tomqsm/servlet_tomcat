<#import "layout.ftl" as default>
<#assign title>Strona główna.</#assign>
<#assign lang="pl"> 
<#assign navbar_highlight=xml['//index/${lang}']> 

<@default.layout lang title navbar_highlight>
  <div><h1>cześć pajacu</h1></div>
  <#include "static/artykul1.html"/>
</@default.layout>

