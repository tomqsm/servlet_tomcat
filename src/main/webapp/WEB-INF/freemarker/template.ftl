<#ftl>
<#if locale??>
<#else>
<#assign locale="pl">
</#if>
<#assign queryString=(request.queryString)!>
<#if queryString != "">
<#assign queryString="?"+queryString>
</#if>
<#assign servletPathQueryString=(request.requestURI)?replace(context,"")+queryString>
<!DOCTYPE html>
<html lang="${locale}">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href="../../favicon.ico">
        <title>${xml["//title/${locale}"]}</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css" rel="stylesheet">
        <#assign scripts = scripts["properties/scripts"]> 
        <#list scripts as s>
        <#list s.* as sc>
        <script src="<#if sc.@with?matches("context")>${sc.@with?eval}${sc}<#else>${sc}</#if>"></script>
        </#list>
        </#list>
        <!-- Custom styles for this template -->
        <link href="${context}/css/carousel.css" rel="stylesheet"/>
        <style>
            .carousel-inner > .item > img,
            .carousel-inner > .item > a > img {
                width: 70% ;
                margin: auto;
            }
        </style>
        <script>
            var appInit = {
                context: '${context}'
            };
        </script>
    </head>
    <body>

        <div id="showSize"></div>
        <div class="navbar-wrapper">
            <div class="container">
                <nav class="navbar navbar-inverse navbar-static-top">
                    <div class="container">
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                                <span class="sr-only">Toggle navigation</span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                            </button>
                            <a class="navbar-brand" href="${response.encodeURL('')}">lukasfloor.com</a>
                        </div>
                        <div id="navbar" class="navbar-collapse collapse">
                            <ul class="nav navbar-nav">
                                <li class="active"><a href="#">Home</a></li>
                                <li><a href="${response.encodeURL('${xml["//cennik/${locale}"]?lower_case}')}">${xml["//cennik/${locale}"]}</a></li>
                                <li><a href="${response.encodeURL('${xml["//firma/${locale}"]?lower_case}')}">${xml["//firma/${locale}"]}</a></li>
                                <li><a href="${response.encodeURL('${xml["//realizacje/${locale}"]?lower_case}')}">${xml["//realizacje/${locale}"]}</a></li>
                                <li><a href="${response.encodeURL('${xml["//kontakt/${locale}"]?lower_case}')}">${xml["//kontakt/${locale}"]}</a></li>
                                <li class="dropdown">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Oferta <span class="caret"></span></a>
                                    <ul class="dropdown-menu" role="menu">
                                        <li><a href="${response.encodeURL('podlogi')}">Podłogi</a></li>
                                        <li><a href="schody">Schody</a></li>
                                        <li><a href="${response.encodeURL('${xml["//cyklinowanie/${locale}"]?lower_case}')}">${xml["//cyklinowanie/${locale}"]}</a></li>
                                        <li class="divider"></li>
                                        <li class="dropdown-header">Usługi</li>
                                        <li><a href="#">Pomiar wilgotności powierzchni</a></li>
                                        <li><a href="#">Wylewki sampoziomujące</a></li>
                                    </ul>
                                </li>
                                <li class="dropdown">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Język <span class="caret"></span></a>
                                    <ul class="dropdown-menu" role="menu">
                                        <li><a href="${response.encodeURL('en${servletPathQueryString}')}">Angielski</a></li>
                                        <li><a href="${response.encodeURL('pl${servletPathQueryString}')}">Polski</a></li>
                                        <li><a href="${response.encodeURL('de${servletPathQueryString}')}">Niemiecki</a></li>
                                    </ul>
                                </li>
                            </ul>
                            <div class="container">
                                <div class="navbar-collapse">
                                    <ul class="nav navbar-right navbar-nav">
                                        <li class="dropdown"> <a class="dropdown-toggle" href="#" data-toggle="dropdown"><span class="glyphicon glyphicon-log-in"></span> ${xml["//zaloguj/${locale}"]}<strong class="caret"></strong></a>
                                            <div class="dropdown-menu" style="padding:10px; min-width:240px;">
                                                <form action="loginform" method="post" class="form-signin">
                                                    <span class="form-signin-heading">${xml["//zaloguj/${locale}"]}</span>
                                                    <label for="inputEmail" class="sr-only">${xml["//identyfikator/${locale}"]}</label>
                                                    <input type="email" name="username" id="inputEmail" class="form-control" placeholder="${xml["//identyfikator/${locale}"]}" autofocus>
                                                           <label for="inputPassword" class="sr-only">Password</label>
                                                    <input type="password" name="password" id="inputPassword" class="form-control" placeholder="${xml["//haslo/${locale}"]}">
                                                           <div class="checkbox">
                                                        <label>
                                                            <input type="checkbox" value="remember-me"> ${xml["//zapamietaj/${locale}"]}
                                                        </label>
                                                    </div>
                                                    <input type="hidden" name="language" value="${locale}">
                                                    <button class="btn btn-lg btn-primary btn-block" type="submit">${xml["//zaloguj/${locale}"]}</button>
                                                </form>
                                            </div>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </nav>
            </div>
        </div>
        <div id="maincontainer">
            <!-- Carousel
            ================================================== -->
            <div id="myCarousel" class="carousel slide" data-ride="carousel">
                <!-- Indicators -->
                <ol class="carousel-indicators">
                    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                    <li data-target="#myCarousel" data-slide-to="1"></li>
                    <li data-target="#myCarousel" data-slide-to="2"></li>
                </ol>
                <div class="carousel-inner" role="listbox">
                    <div class="item active">
                        <img src="${context}/images/podloga1.jpg" alt="First slide">
                        <div class="container">
                            <div class="carousel-caption">
                                <h1>Example headline.</h1>
                                <p>Note: If you're viewing this page via a <code>file://</code> URL, the "next" and "previous" Glyphicon buttons on the left and right might not load/display properly due to web browser security rules.</p>
                                <p><a class="btn btn-lg btn-primary" href="#" role="button">Sign up today</a></p>
                            </div>
                        </div>
                    </div>
                    <div class="item">
                        <img src="${context}/images/schody.jpg" alt="Second slide">
                        <div class="container">
                            <div class="carousel-caption">
                                <h1>Another example headline.</h1>
                                <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                                <p><a class="btn btn-lg btn-primary" href="#" role="button">Learn more</a></p>
                            </div>
                        </div>
                    </div>
                    <div class="item">
                        <img src="${context}/images/drzwi.jpg" alt="Third slide">
                        <div class="container">
                            <div class="carousel-caption">
                                <h1>One more for good measure.</h1>
                                <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                                <p><a class="btn btn-lg btn-primary" href="#" role="button">Browse gallery</a></p>
                            </div>
                        </div>
                    </div>
                </div>
                <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
                    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
                    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div><!-- /.carousel -->
            <!-- Marketing messaging and featurettes
            ================================================== -->
            <!-- Wrap the rest of the page in another container to center all the content. -->
            <div class="container marketing">
                <!-- Three columns of text below the carousel -->
                <div class="row">
                    <div class="col-lg-3">
                        <img class="img-circle" src="${context}/images/podloga1.jpg" alt="podłoga" style="width: 150px; height: 150px;">
                        <h2>Podłogi</h2>
                        <p>Donec sed odio dui. Etiam porta sem malesuada magna mollis euismod. Nullam id dolor id nibh ultricies vehicula ut id elit. Morbi leo risus, porta ac consectetur ac, vestibulum at eros. Praesent commodo cursus magna.</p>
                        <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
                    </div>
                    <div class="col-lg-3">
                        <img class="img-circle" src="${context}/images/schody.jpg" alt="schody" style="width: 150px; height: 150px;">
                        <h2>Schody</h2>
                        <p>Balustrady. Duis mollis, est non commodo luctus, nisi erat porttitor ligula, eget lacinia odio sem nec elit. Cras mattis consectetur purus sit amet fermentum. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh.</p>
                        <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
                    </div>
                    <div class="col-lg-3">
                        <img class="img-circle" src="${context}/images/drzwi.jpg" alt="drzwi" style="width: 150px; height: 150px;">
                        <h2>Drzwi</h2>
                        <p>Montaż. Duis mollis, est non commodo luctus, nisi erat porttitor ligula, eget lacinia odio sem nec elit. Cras mattis consectetur purus sit amet fermentum. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh.</p>
                        <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
                    </div>

                    <div class="col-lg-3">
                        <img class="img-circle" src="${context}/images/cyklinowanie.jpg" alt="cyklinowanie" style="width: 150px; height: 150px;">
                        <h2>Usługi</h2>
                        <p>Cyklinowanie bezpyłowe. Duis mollis, est non commodo luctus, nisi erat porttitor ligula, eget lacinia odio sem nec elit. Cras mattis consectetur purus sit amet fermentum. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh.</p>
                        <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
                    </div>
                </div><!-- /.row -->

                <!-- START THE FEATURETTES -->
                <hr class="featurette-divider">

                <div class="row featurette">
                    <div class="col-md-7">
                        <h2 class="featurette-heading">First featurette heading. <span class="text-muted">It'll blow your mind.</span></h2>
                        <p class="lead">Donec ullamcorper nulla non metus auctor fringilla. Vestibulum id ligula porta felis euismod semper. Praesent commodo cursus magna, vel scelerisque nisl consectetur. Fusce dapibus, tellus ac cursus commodo.</p>
                    </div>
                    <div class="col-md-5">
                        <img class="featurette-image img-responsive" data-src="holder.js/500x500/auto/lava" alt="Generic placeholder image">
                    </div>
                </div>

                <hr class="featurette-divider">

                <div class="row featurette">
                    <div class="col-md-5">
                        <img class="featurette-image img-responsive" data-src="holder.js/500x500/auto/sky" alt="Generic placeholder image">
                    </div>
                    <div class="col-md-7">
                        <h2 class="featurette-heading">Oh yeah, it's that good. <span class="text-muted">See for yourself.</span></h2>
                        <p class="lead">Donec ullamcorper nulla non metus auctor fringilla. Vestibulum id ligula porta felis euismod semper. Praesent commodo cursus magna, vel scelerisque nisl consectetur. Fusce dapibus, tellus ac cursus commodo.</p>
                    </div>
                </div>

                <hr class="featurette-divider">

                <div class="row featurette">
                    <div class="col-md-7">
                        <h2 class="featurette-heading">And lastly, this one. <span class="text-muted">Checkmate.</span></h2>
                        <p class="lead">Donec ullamcorper nulla non metus auctor fringilla. Vestibulum id ligula porta felis euismod semper. Praesent commodo cursus magna, vel scelerisque nisl consectetur. Fusce dapibus, tellus ac cursus commodo.</p>
                    </div>
                    <div class="col-md-5">
                        <img class="featurette-image img-responsive" data-src="holder.js/500x500/auto/vine" alt="Generic placeholder image">
                    </div>
                </div>

                <hr class="featurette-divider">

                <!-- /END THE FEATURETTES -->
            </div> <!-- /maincontainer -->

            <!-- FOOTER -->
            <footer>
                <p class="pull-right"><a href="#">Na początek strony</a></p>
                <p>&copy; 2014 Company, Inc. &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>
            </footer>

        </div><!-- /.container -->
    </body>
</html>