<?php
/**
 * Created by PhpStorm.
 * User: Rafaël
 * Date: 6/04/2015
 * Time: 15:24
 */
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>FINAH - Registratie</title>
    <link rel="stylesheet" type="text/css" href="../Css/Stylesheet.css"/>
    <link rel="stylesheet" type="text/css" href="../Css/bootstrap.css" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="navbar-header pull-left">

        <a href="#menu-toggle" id="menu-toggle" class="btn-toggle">
            <span id="side-toggle" class="glyphicon glyphicon-option-horizontal"></span>
        </a>
        <a class="navbar-brand header" href="../index.php"> Finah</a>
    </div>
</nav>
<div id="wrapper">
    <!-- Sidebar -->
    <div id="sidebar-wrapper">
        <ul class="sidebar-nav">
            <br/>
            <br/>
            <li class="sidebar-brand">
                <h4>
                    MENU
                </h4>
            </li>
            <li >
                <a href="../index.php"> Home </a>
            </li>
        </ul>
    </div>
    <div  id="page-content-wrapper">
        <div class="breadcrumb">
            <span class="glyphicon glyphicon-home"></span> &nbsp / &nbsp <span class="breadcrumb-font">Registratie </span>
        </div>
        <div  class="container-fluid">
            <div class="row">

                <div class="col-lg-12 col-md-12 col-sm-12">
                    <h1 style="margin-bottom:50px;">Registratie</h1>

                    <form class="form form-horizontal" role="form" method="POST"
                          action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>">
                        <div class="row">
                            <div class="col-xs-5 col-sm-5 col-md-4 col-lg-2">
                                <label for="Rol"  class="control-label">
                                    Rol:
                                </label>
                            </div>
                            <div class="col-xs-7 col-sm-7 col-md-5 col-lg-3">
                                <select class="form-control" id="Rol" name="rol">
                                   <option value="null">Maak een keuze</option>
                                    <option value="null">Onderzoeker</option>
                                    <option value="null">Hulpverlener</option>
                                </select>
                            </div>
                        </div>
                        <div class="row detail-row">
                            <div class="col-xs-5 col-sm-5 col-md-4 col-lg-2">
                                <label for="Voornaam"  class="control-label">
                                    Voornaam:
                                </label>
                            </div>
                            <div class="col-xs-7 col-sm-7 col-md-5 col-lg-3">
                                <input type="text" name="voornaam" id="Voornaam" class="form-control" value="Gert">
                            </div>
                        </div>
                        <div class="row detail-row">
                            <div class="col-xs-5 col-sm-5 col-md-4 col-lg-2">
                                <label for="Naam"  class="control-label">
                                    Naam:
                                </label>
                            </div>
                            <div class="col-xs-7 col-sm-7 col-md-5 col-lg-3">
                                <input type="text" name="naam" id="Naam" class="form-control" value="Claeskens">
                            </div>
                        </div>
                        <div class="row detail-row">
                            <div class="col-xs-5 col-sm-5 col-md-4 col-lg-2">
                                <label for="Email"  class="control-label">
                                    E-mail:
                                </label>
                            </div>
                            <div class="col-xs-7 col-sm-7 col-md-5 col-lg-3">
                                <input type="text" name="email" id="Email" class="form-control" value="gert.claeskens@gmail.com">
                            </div>
                        </div>
                        <div class="row detail-row">
                            <div class="col-xs-5 col-sm-5 col-md-4 col-lg-2">
                                <label for="Straat"  class="control-label">
                                    Straat:
                                </label>
                            </div>
                            <div class="col-xs-7 col-sm-7 col-md-5 col-lg-3">
                                <input type="text" name="straat" id="Straat" class="form-control" value="teststraat">
                            </div>
                        </div>
                        <div class="row detail-row">
                            <div class="col-xs-5 col-sm-5 col-md-4 col-lg-2">
                                <label for="Huisnr"  class="control-label">
                                    Huisnummer:
                                </label>
                            </div>
                            <div class="col-xs-3 col-sm-4 col-md-3 col-lg-2">
                                <input type="text" name="huisnr" id="Huisnr" class="form-control" value="55">
                            </div>
                        </div>
                        <div class="row detail-row">
                            <div class="col-xs-5 col-sm-5 col-md-4 col-lg-2">
                                <label for="Postcode"  class="control-label">
                                    Postcode:
                                </label>
                            </div>
                            <div class="col-xs-3 col-sm-4 col-md-3 col-lg-2">
                                <input type="text" name="postcode" id="Postcode" class="form-control" value="3680" onchange="OnChange(event)">
                            </div>
                        </div>
                        <!--                                        todo met javascript adhv postcode de mogelijke woonplaatsen weergeven in een combobox (== bevraging create ) -->
                        <div class="row detail-row">
                            <div class="col-xs-5 col-sm-5 col-md-4 col-lg-2">
                                <label for="Woonplaats"  class="control-label">
                                    Woonplaats:
                                </label>
                            </div>
                            <div class="col-xs-7 col-sm-7 col-md-5 col-lg-3">
                                <select class="form-control" id="Woonplaats" name="woonplaats">
                                    <option value="null">Neeroeteren</option>
                                    <option value="null">Maaseik</option>
                                    <option value="null">Opoeteren</option>

                                </select>
                            </div>
                        </div>
                        <div class="row detail-row">
                            <div class="col-xs-5 col-sm-5 col-md-4 col-lg-2">
                                <label for="Telefoon"  class="control-label">
                                    Telefoon:
                                </label>
                            </div>
                            <div class="col-xs-7 col-sm-7 col-md-5 col-lg-3">
                                <input type="text" name="telefoon" id="Telefoon" class="form-control" value="001-callme-xxx">
                            </div>
                        </div>

                        <div class="row detail-row">
                            <div class="col-xs-5 col-sm-5 col-md-4 col-lg-2">
                                <label for="Captcha"  class="control-label">
                                    1+1:
                                </label>
                            </div>
                            <div class="col-xs-7 col-sm-7 col-md-5 col-lg-3">
                                <input type="text" name="captcha" id="Captcha" class="form-control" value="2" >
                            </div>
                        </div>
                        <div class="row detail-row">
                            <div class="col-xs-offset-5 col-sm-offset-5 col-md-offset-4 col-lg-offset-2" >
                                <button type="button" name="terug" class="btn btn-primary form-buttons" onclick="location.href='../index.php'" >
                                    Terug
                                </button>
                                <button type="submit" name="registreren" class="btn btn-primary form-buttons">
                                    Registreren
                                </button>

                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    $("#menu-toggle").click(function(e) {
        e.preventDefault();
        $("#wrapper").toggleClass("toggled");
        if ($("#side-toggle").hasClass("glyphicon-option-vertical")) {
            $("#side-toggle").removeClass("glyphicon-option-vertical");
            $("#side-toggle").addClass("glyphicon-option-horizontal");
        } else {
            $("#side-toggle").removeClass("glyphicon-option-horizontal");
            $("#side-toggle").addClass("glyphicon-option-vertical");
        }
    });
</script>
</body>
</html>

