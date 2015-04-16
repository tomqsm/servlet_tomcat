<#import "../../layout.ftl" as default>
<#assign title>Strona główna.</#assign>
<#assign lang="de"> 
<#assign navbar_highlight=xml['//kontakt/${lang}']> 
<@default.layout lang title scripts["properties/layout/scripts"] navbar_highlight>
<#include "../../html/kontakt.html"/>
</@default.layout>

