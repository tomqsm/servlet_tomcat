<#import "../../layout.ftl" as default>
<#assign title>Strona główna.</#assign>
<#assign lang="en"> 
<#assign navbar_highlight=xml['//firma/${lang}']> 


<@default.layout lang title navbar_highlight>
<#include "../../html/firma.html"/>
<div class="container">
    <p>Informations about the firm ...</p>
</div>
</@default.layout>

