<#import "../../layout.ftl" as default>
<#assign title>Strona główna.</#assign>
<#assign lang="de"> 
<#assign navbar_highlight=xml['//cennik/${lang}']> 


<@default.layout lang title navbar_highlight>
<#include "../../html/cennik.html"/>
</@default.layout>

