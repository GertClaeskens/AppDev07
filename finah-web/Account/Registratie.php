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
    <script src="../js/jquery-2.1.3.min.js"></script>
    <script src="../js/Validate/jquery.validate.js"></script>
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

                    <form id="registratieForm" class="form form-horizontal" role="form" method="POST"
                          action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>">
                        <div class="row">
                            <div class="col-xs-5 col-sm-5 col-md-4 col-lg-2">
                                <label for="Rol"  class="control-label">
                                    Rol:
                                </label>
                            </div>
                            <div class="col-xs-7 col-sm-7 col-md-5 col-lg-3">
                                <select class="form-control" id="Rol" name="rol">
                                   <option value="">Maak een keuze</option>
                                    <option value="1">Onderzoeker</option>
                                    <option value="2">Hulpverlener</option>
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
                                <input type="text" name="voornaam" id="Voornaam" class="form-control">
                            </div>
                        </div>
                        <div class="row detail-row">
                            <div class="col-xs-5 col-sm-5 col-md-4 col-lg-2">
                                <label for="Naam"  class="control-label">
                                    Naam:
                                </label>
                            </div>
                            <div class="col-xs-7 col-sm-7 col-md-5 col-lg-3">
                                <input type="text" name="naam" id="Naam" class="form-control">
                            </div>
                        </div>
                        <div class="row detail-row">
                            <div class="col-xs-5 col-sm-5 col-md-4 col-lg-2">
                                <label for="Email"  class="control-label">
                                    E-mail:
                                </label>
                            </div>
                            <div class="col-xs-7 col-sm-7 col-md-5 col-lg-3">
                                <input type="text" name="email" id="Email" class="form-control" >
                            </div>
                        </div>
                        <div class="row detail-row">
                            <div class="col-xs-5 col-sm-5 col-md-4 col-lg-2">
                                <label for="Wachtwoord"  class="control-label">
                                    Wachtwoord:
                                </label>
                            </div>
                            <div class="col-xs-7 col-sm-7 col-md-5 col-lg-3">
                                <input type="password" name="wachtwoord" id="Wachtwoord" class="form-control" >
                            </div>
                        </div>
                        <div class="row detail-row">
                            <div class="col-xs-5 col-sm-5 col-md-4 col-lg-2">
                                <label for="confWachtwoord"  class="control-label">
                                    Herhaal wachtwoord:
                                </label>
                            </div>
                            <div class="col-xs-7 col-sm-7 col-md-5 col-lg-3">
                                <input type="password" name="confwachtwoord" id="confWachtwoord" class="form-control" >
                            </div>
                        </div>
                        <div class="row detail-row">
                            <div class="col-xs-5 col-sm-5 col-md-4 col-lg-2">
                                <label for="Straat"  class="control-label">
                                    Straat:
                                </label>
                            </div>
                            <div class="col-xs-7 col-sm-7 col-md-5 col-lg-3">
                                <input type="text" name="straat" id="Straat" class="form-control" >
                            </div>
                        </div>
                        <div class="row detail-row">
                            <div class="col-xs-5 col-sm-5 col-md-4 col-lg-2">
                                <label for="Huisnr"  class="control-label">
                                    Huisnummer:
                                </label>
                            </div>
                            <div class="col-xs-3 col-sm-4 col-md-3 col-lg-2 text-nowrap">
                                <input type="text" name="huisnr" id="Huisnr" class="form-control">
                            </div>
                        </div>
                        <div class="row detail-row">
                            <div class="col-xs-5 col-sm-5 col-md-4 col-lg-2">
                                <label for="Postcode"  class="control-label">
                                    Postcode:
                                </label>
                            </div>
                            <div class="col-xs-3 col-sm-4 col-md-3 col-lg-2 text-nowrap">
                                <input type="text" name="postcode" id="Postcode" class="form-control" onchange="OnChange(event)">
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
                                    <option value="" ></option>
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
                                <input type="text" name="telefoon" id="Telefoon" class="form-control" >
                            </div>
                        </div>

                        <div class="row detail-row">
                            <div class="col-xs-5 col-sm-5 col-md-4 col-lg-2">
                                <label for="Captcha"  class="control-label">
                                    1+1:
                                </label>
                            </div>
                            <div class="col-xs-7 col-sm-7 col-md-5 col-lg-3">
                                <input type="text" name="captcha" id="Captcha" class="form-control"  >
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
    $().ready(function () {
        $.validator.addMethod(
            "regex",
            function(value, element, regexp) {
                var check = false;
                return this.optional(element) || regexp.test(value);
            },
            "Gelieve een legitiem telefoonnummer in te geven."
        );
        $("#registratieForm").validate({
            rules: {
                rol: "required",
                voornaam: "required",
                naam: "required",
                huisnr: {
                    required:true,
                    number:true,
                    min:1
                },
                straat: "required",
                email:{
                    required:true,
                    email:true
                },
                telefoon: {
                    required: true,
                    minlength:9
                },
                wachtwoord: {
                    required: true,
                    minlength: 8,
                    regex: /^(?=.*[A-Z])(?=.*\d).*$/
                },
                confwachtwoord: {
                    required: true,
                    minlength: 8,
                    equalTo: "#Wachtwoord",
                    regex: /^(?=.*[A-Z])(?=.*\d).*$/
                },
                postcode:{
                    required:true,
                    number:true,
                    min:1000,
                    max:9999
                },
                woonplaats:"required"
            },
            messages: {
                rol: "Gelieve een keuze te maken!",
                voornaam:"Gelieve dit veld in te vullen!",
                naam: "Gelieve dit veld in te vullen!",
                huisnr: {
                    required:"Gelieve dit veld in te vullen",
                    number: "Gelieve een numerieke waarde in te vullen",
                    min: "Gelieve een positieve waarde in te vullen"
                },
                straat: "Gelieve dit veld in te vullen!",
                email: {
                    required: "Gelieve dit veld in te vullen!",
                    email: "Gelieve een legitiem email adres in te vullen (Voorbeeld: test@test.com"
                },
                wachtwoord:{
                    required:"Gelieve dit veld in te vullen",
                    minlenght:"Gelieve minimum 8 tekens in te geven",
                    regex:"Gelieve minstens 1 cijfer en 1 hoofdletter in te geven"
                },
                confwachtwoord: {
                    required: "Gelieve dit veld in te vullen",
                    minlenght: "Gelieve minimum 8 tekens in te geven",
                    equalTo: "De twee wachtwoord zijn niet identiek",
                    regex: "Gelieve minstens 1 cijfer en 1 hoofdletter in te geven"
                },
                telefoon: {
                    required:"Gelieve dit veld in te vullen!",
                    min:"Gelieve een correct telefoon nummer in te voeren"
                },
                postcode: {
                    required:"Gelieve dit veld in te vullen!",
                    number:"Gelieve een numerieke waarde in te vullen",
                    min: "Een postcode heeft 4 cijfers",
                    max: "Een postcode heeft max 4 cijfers"
                },
                woonplaats:"Gelieve een keuze te maken!"
            }
        });
    });
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

