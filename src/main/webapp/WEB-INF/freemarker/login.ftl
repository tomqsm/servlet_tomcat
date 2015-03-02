<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href="../../favicon.ico">
        <title>Zaloguj</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css" rel="stylesheet">

        <#assign scripts = scripts["properties/scripts"]> 
        <#list scripts as s>
        <#list s.* as sc>
        <script src="<#if sc.@with?matches("context")>${sc.@with?eval}${sc}<#else>${sc}</#if>"></script>
        </#list>
        </#list>
    </head>
    <body>
        <div class="container">
            <form action="j_security_check" class="form-signin">
                <h2 class="form-signin-heading">${xml["//zaloguj/${locale}"]}</h2>
                <label for="inputEmail" class="sr-only">Email address</label>
                <input type="email" id="inputEmail" class="form-control" placeholder="${xml["//identyfikator/${locale}"]}" autofocus>
                <label for="inputPassword" class="sr-only">Password</label>
                <input type="password" id="inputPassword" class="form-control" placeholder="${xml["//haslo/${locale}"]}">
                <div class="checkbox">
                    <label>
                        <input type="checkbox" value="remember-me"> ${xml["//zapamietaj/${locale}"]}
                    </label>
                </div>
                <button class="btn btn-lg btn-primary btn-block" type="submit">${xml["//zaloguj/${locale}"]}</button>
            </form>
        </div> <!-- /container -->
    </body>
</html>
