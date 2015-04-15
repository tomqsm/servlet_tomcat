<#import "layout.ftl" as default>
<#assign lang="pl"> 
<#assign title=xml['//index/${lang}']>
<#assign navbar_highlight=xml['//index/${lang}']> 

<@default.layout lang title navbar_highlight>
<#include "html/carousel_todo.html"/>
<#include "html/columns.html"/>
</@default.layout>