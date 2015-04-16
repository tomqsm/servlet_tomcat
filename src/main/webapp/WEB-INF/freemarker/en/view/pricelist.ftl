<#import "../../layout.ftl" as default>
<#assign title>Strona główna.</#assign>
<#assign lang="en"> 
<#assign navbar_highlight=xml['//cennik/${lang}']> 


<@default.layout lang title scripts["properties/layout/scripts"] navbar_highlight>
<#include "../../html/cennik.html"/>
</@default.layout>

