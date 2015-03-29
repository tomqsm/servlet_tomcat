<#import "../../layout.ftl" as default>
<#assign title>Strona główna.</#assign>
<#assign lang="de"> 
<#assign navbar_highlight=xml['//realizacje/${lang}']> 


<@default.layout lang title navbar_highlight>
<#include "../../html/realizacje.html"/>
<div class="container">
    <p>Deutsch stuff about job done bla bla</p>
</div>
</@default.layout>

