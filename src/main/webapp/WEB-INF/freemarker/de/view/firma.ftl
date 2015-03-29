<#import "../../layout.ftl" as default>
<#assign title>Strona główna.</#assign>
<#assign lang="de"> 
<#assign navbar_highlight=xml['//firma/${lang}']> 


<@default.layout lang title navbar_highlight>
<#include "../../html/firma.html"/>
<div class="container">
    <p>Deutsch stuff bla bla</p>
</div>
</@default.layout>

