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
        <link rel="icon" href="${context}/images/favicon.ico">
        <title>Zaloguj</title>
        <link href="${context}/css/main.css" rel="stylesheet">

        <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css" rel="stylesheet">
        <script>
            var appInit = {
                context: '${context}'
            };
        </script>
        <#assign scripts = scripts["properties/scripts"]> 
        <#list scripts as s>
        <#list s.* as sc>
        <script src="<#if sc.@with?matches("context")>${sc.@with?eval}${sc}<#else>${sc}</#if>"></script>
        </#list>
        </#list>
        <script src="${context}/js/lib/jquery.validate.min.js"></script>
        <script src="${context}/js/validate-login.js"></script>
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
            <form id="loginForm" action="${response.encodeURL('j_security_check')}" method="post" class="form-signin">
                <h2 class="form-signin-heading">${xml["//zaloguj/${locale}"]} <#if failed??> ${xml["//niezalogowano/${locale}"]}<#else></#if></h2>
                <label for="inputEmail">${xml["//identyfikator/${locale}"]} (${xml["//polewymagane/${locale}"]})</label>
                <input type="email" name="j_username" id="inputEmail" class="form-control" placeholder="${xml["//identyfikator/${locale}"]}" autofocus 
data-rule-required="true" data-msg-required="${xml['//wypelnijpole/${locale}']} '${xml["//identyfikator/${locale}"]}'" 
data-rule-email="true" data-msg-email="Proszę wprowadzić poprawny e-mail.">
                       <label for="inputPassword" required="required">${xml["//haslo/${locale}"]} (${xml["//polewymagane/${locale}"]}) (${xml["//minlength/${locale}"]})</label>
                <input type="password" name="j_password" id="inputPassword" class="form-control" placeholder="${xml["//haslo/${locale}"]}" 
                data-rule-required="true" data-msg-required="${xml['//wypelnijpole/${locale}']} '${xml["//haslo/${locale}"]}'"
                data-rule-minlength="4" data-msg-minlength="${xml['//wypelnijpole/${locale}']} '${xml["//haslo/${locale}"]}' - ${xml['//minlength/${locale}']?lower_case}">
                       <div class="checkbox">
                    <label>
                        <input type="checkbox" value="remember-me"> ${xml["//zapamietaj/${locale}"]}
                    </label>
                </div>
                <input type="hidden" name="language" value="${locale}">
                <button class="btn btn-lg btn-primary btn-block" type="submit">${xml["//zaloguj/${locale}"]}</button>
            </form>
        </div> <!-- /container -->
    </body>
</html>
