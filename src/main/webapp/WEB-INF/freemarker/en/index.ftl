<#import "../layout.ftl" as default>
<#assign title>Main page.</#assign>
<#assign lang="en">
<#assign navbar_highlight=xml['//index/${lang}']> 

<@default.layout lang title navbar_highlight>
  <div><h1>Hello Dude</h1></div>
</@default.layout>

