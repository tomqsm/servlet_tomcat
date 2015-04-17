<#import "../../layout.ftl" as default>
<#assign lang="en"> 
<#assign title>Home page</#assign>
<#assign js_scripts=scripts["properties/layout/scripts"]> 
<#assign navbar_highlight=xml['//index/${lang}']> 

<@default.layout lang title js_scripts navbar_highlight>
<#include "../../html/carousel.html"/>
<#include "../../html/columns.html"/>
<div class="container">
    <h1>Some content here.</h1>
</div>
</@default.layout>

