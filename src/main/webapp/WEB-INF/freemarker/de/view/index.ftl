<#import "../../layout.ftl" as default>
<#assign lang="de"> 
<#assign title>Home page-de</#assign>
<#assign js_scripts=scripts["properties/layout/scripts"]> 
<#assign navbar_highlight=xml['//index/${lang}']> 

<@default.layout lang title js_scripts navbar_highlight>
<#include "../../html/carousel.html"/>
<#include "../../html/columns.html"/>
<div class="container">
    <h1>Das ist geil.</h1>
</div>
</@default.layout>