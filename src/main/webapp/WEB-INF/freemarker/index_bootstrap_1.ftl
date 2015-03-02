<#ftl>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href="../../favicon.ico">

        <title>${xml["//title/${locale}"]}</title>

        <!-- Bootstrap core CSS -->
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css" rel="stylesheet">

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->

        <!-- Custom styles for this template -->
        <link href="${context}/css/carousel.css" rel="stylesheet">
        <style>
            .carousel-inner > .item > img,
            .carousel-inner > .item > a > img {
                width: 70%;
                margin: auto;
            }
        </style>
    </head>
    <body>
        <!-- Static navbar -->
        <nav class="navbar navbar-default navbar-static-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">lukasfloor.com</a>
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="#">Cennik</a></li>
                        <li><a href="#about">Firma</a></li>
                        <li><a href="#contact">Kontakt</a></li>
                        <li><a href="#contact">Realizacje</a></li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Oferta<span class="caret"></span></a>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="#">Układanie podłogi</a></li>
                                <li><a href="#">Cyklinowanie</a></li>
                                <li><a href="#">Konserwacja</a></li>
                                <li class="divider"></li>
                                <li class="dropdown-header">Usługi</li>
                                <li><a href="#">Pomiar wilgotności powierzchni</a></li>
                                <li><a href="#">Wylewka poziomująca</a></li>
                            </ul>
                        </li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Zaloguj</a></li>
                    </ul>
                </div><!--/.nav-collapse -->
            </div>
        </nav>
        <div id="maincontainer" class="container">
            <div class="jumbotron">
                <div class="container">
                    <div class="row">
                        <div class="col-md-4"><h1>Podłogi</h1>      
                            <p>Parkiety, podłogi z drewna - układanie, renowacja (czyszczenie, cyklinowanie), konserwacja.</p>      
                            <a href="#" class="btn btn-info btn-lg"><span class="glyphicon glyphicon-search"></span> Zamów</a>
                        </div>
                        <div class="col-md-7">
                            <div id="myCarousel" class="carousel slide" data-ride="carousel">
                                <!-- Indicators -->
                                <ol class="carousel-indicators">
                                    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                                    <li data-target="#myCarousel" data-slide-to="1"></li>
                                    <li data-target="#myCarousel" data-slide-to="2"></li>
                                    <li data-target="#myCarousel" data-slide-to="3"></li>
                                </ol>

                                <!-- Wrapper for slides -->
                                <div class="carousel-inner" role="listbox">
                                    <div class="item active">
                                        <img src="img_chania.jpg" alt="Chania">
                                        <div class="carousel-caption">
                                            <h3>Chania</h3>
                                            <p>The atmosphere in Chania has a touch of Florence and Venice.</p>
                                        </div>
                                    </div>

                                    <div class="item">
                                        <img src="img_chania2.jpg" alt="Chania">
                                        <div class="carousel-caption">
                                            <h3>Chania</h3>
                                            <p>The atmosphere in Chania has a touch of Florence and Venice.</p>
                                        </div>
                                    </div>

                                    <div class="item">
                                        <img src="img_flower.jpg" alt="Flower">
                                        <div class="carousel-caption">
                                            <h3>Flowers</h3>
                                            <p>Beatiful flowers in Kolymbari, Crete.</p>
                                        </div>
                                    </div>

                                    <div class="item">
                                        <img src="img_flower2.jpg" alt="Flower">
                                        <div class="carousel-caption">
                                            <h3>Flowers</h3>
                                            <p>Beatiful flowers in Kolymbari, Crete.</p>
                                        </div>
                                    </div>
                                </div>

                                <!-- Left and right controls -->
                                <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
                                    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                                    <span class="sr-only">Previous</span>
                                </a>
                                <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
                                    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                                    <span class="sr-only">Next</span>
                                </a>
                            </div>
                        </div>
                        <div class="col-md-1">
                            <div class="dropdown pull-right">
                                <button class="btn btn-default dropdown-toggle" type="button" id="menu1" data-toggle="dropdown">Oferta
                                    <span class="caret"></span></button>
                                <ul class="dropdown-menu dropdown-menu-right" role="menu" aria-labelledby="menu1">
                                    <li role="presentation" class="dropdown-header">Podłogi</li>
                                    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Układanie podłogi</a></li>
                                    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Cyklinowanie</a></li>
                                    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Konserwacja</a></li>
                                    <li role="presentation" class="divider"></li>
                                    <li role="presentation" class="dropdown-header">Usługi</li>
                                    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Pomiar wilgotności powierzchni</a></li>
                                    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Wylewka poziomująca</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>

                </div>

            </div>
            <div class="jumbotron">
                <h1>Stolarka</h1>      
                <p>This page will grow as we add more and more components from Bootstrap...</p>      
                <a href="#" class="btn btn-info btn-lg"><span class="glyphicon glyphicon-search"></span> Zamów</a>
            </div>
        </div>
        <!-- Bootstrap core JavaScript
        ================================================== -->
        <#assign scripts = scripts["properties/scripts"]> 
        <#list scripts as s>
        <#list s.* as sc>
        <script src="<#if sc.@with?matches("context")>${sc.@with?eval}${sc}<#else>${sc}</#if>"></script>
        </#list>
        </#list>
    </body>
</html>
