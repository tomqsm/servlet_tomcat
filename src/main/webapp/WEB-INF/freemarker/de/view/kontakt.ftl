<#import "../../layout.ftl" as default>
<#assign title>Strona główna.</#assign>
<#assign lang="de"> 
<#assign navbar_highlight=xml['//kontakt/${lang}']> 


<@default.layout lang title navbar_highlight>
<#include "../../html/kontakt.html"/>
<div class="container">
    <p>Deutsch stuff contacts ...</p>
</div>
</@default.layout>

