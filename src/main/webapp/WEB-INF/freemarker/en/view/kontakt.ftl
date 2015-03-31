<#import "../../layout.ftl" as default>
<#assign title>Strona główna.</#assign>
<#assign lang="en"> 
<#assign navbar_highlight=xml['//kontakt/${lang}']> 


<@default.layout lang title navbar_highlight>
<#include "../../html/kontakt.html"/>
</@default.layout>

