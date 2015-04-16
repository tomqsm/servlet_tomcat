<#import "layout.ftl" as default>
<#assign lang="pl"> 
<#assign title=xml['//index/${lang}']>
<#assign navbar_highlight=xml['//oferta/${lang}']> 

<@default.layout lang title scripts["properties/layout/scripts"] navbar_highlight>
<#include "view/static/underconstruction.html"/>
</@default.layout>