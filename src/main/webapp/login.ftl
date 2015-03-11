<#if locale??>
<#else>
<#assign locale="pl">
</#if>
<!DOCTYPE html>
<html lang="${locale}">
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
        <style>
            body {
                padding-top: 40px;
                padding-bottom: 40px;
                background-color: #eee;
            }

            .form-signin {
                max-width: 330px;
                padding: 15px;
                margin: 0 auto;
            }
            .form-signin .form-signin-heading,
            .form-signin .checkbox {
                margin-bottom: 10px;
            }
            .form-signin .checkbox {
                font-weight: normal;
            }
            .form-signin .form-control {
                position: relative;
                height: auto;
                -webkit-box-sizing: border-box;
                -moz-box-sizing: border-box;
                box-sizing: border-box;
                padding: 10px;
                font-size: 16px;
            }
            .form-signin .form-control:focus {
                z-index: 2;
            }
            .form-signin input[type="email"] {
                margin-bottom: -1px;
                border-bottom-right-radius: 0;
                border-bottom-left-radius: 0;
            }
            .form-signin input[type="password"] {
                margin-bottom: 10px;
                border-top-left-radius: 0;
                border-top-right-radius: 0;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <form action="j_security_check" method="post" class="form-signin">
                <h2 class="form-signin-heading">${xml["//zaloguj/${locale}"]} <#if loginResult??> ${xml["//niezalogowano/${locale}"]}<#else></#if></h2>
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
