<#import "../../layout.ftl" as default>
<#assign title>Strona główna.</#assign>
<#assign lang="de"> 
<#assign navbar_highlight=xml['//realizacje/${lang}']> 
<@default.layout lang title scripts["properties/layout/scripts"] navbar_highlight>
<#include "../../html/realizacje.html"/>
</@default.layout>

