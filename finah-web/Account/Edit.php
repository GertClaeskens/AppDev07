<?php
require "../PHP/DAO/FinahDAO.php";
session_start()
?>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1"/>
        <title>FINAH - Account</title>
        <link rel="stylesheet" type="text/css" href="../Css/Stylesheet.css"/>
        <link rel="stylesheet" type="text/css" href="../Css/bootstrap.css"/>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
        <script src="http://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script src="../js/Validate/jquery.validate.js"></script>
        <script src="../js/finah.js"></script>
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

<!--        todo script nakijken en aanpassen adhv postcode / woonplaats in backend-->
<!--        <script type="text/javascript">-->
<!--            var data = '';-->
<!---->
<!--            function OnChange(e) {-->
<!--                var woonpl = document.forms["myForm"]["Woonplaats"];-->
<!--                var val = e.target.value;-->
<!---->
<!--                if (val != 'null') {-->
<!--                    empty(woonpl);-->
<!--                    var gem = '';-->
<!--                    var xhr = new JSONHttpRequest();-->
<!--                    var url = "http://finahbackend1920.azurewebsites.net/Postcode/" + val + "/Gemeente";-->
<!--                    xhr.open("GET", url, true);-->
<!---->
<!--                    xhr.onreadystatechange = function () {-->
<!--                        if (xhr.readyState === 4 && xhr.status === 200) {-->
<!--                            gem = JSON.parse(xhr.responseText);-->
<!--                            for (var i = 0; i < pat.length; i++) {-->
<!--                                var option = document.createElement('option');-->
<!--                                option.value = gem[i].Id;-->
<!--                                option.textContent = gem[i].Naam;-->
<!--                                option.innerText = gem[i].Naam;-->
<!--                                woonpl.appendChild(option);-->
<!--                            }-->
<!--                        }-->
<!--                    };-->
<!--                    xhr.send(null);-->
<!--                }-->
<!--            }-->
<!--            </script>-->
    </head>
    <body>
    <div id="dialogoverlay"></div>
    <div id="dialogbox">
        <div>
            <div id="dialogboxhead"></div>
            <div id="dialogboxbody"></div>
            <div id="dialogboxfoot"></div>
        </div>
    </div>
    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="navbar-header pull-left">

            <a href="#menu-toggle" id="menu-toggle" class="btn-toggle">
                <span id="side-toggle" class="glyphicon glyphicon-option-horizontal"></span>
            </a>
            <a class="navbar-brand header" href="../index.php"> Finah</a>
        </div>
        <div class="dropdown navbar-header pull-right nav-right">
            <a class="btn dropdown-toggle pull-left" type="button" id="menu1" data-toggle="dropdown"><?php echo $_SESSION["username"]; ?>
                <span class="caret"></span>
            </a>
            <ul class="dropdown-menu " role="menu" aria-labelledby="menu1">
                <li role="presentation">
                    <a role="menuitem" tabindex="0" href="../Account/Edit.php">
                        <span class="glyphicon glyphicon-user"></span> &nbsp Mijn account
                    </a>
                </li>
                <li role="presentation" class="divider">
                </li>
                <li role="presentation">
                    <a role="menuitem" tabindex="-1" href="#">
                        <span class="glyphicon glyphicon-log-out"></span> &nbsp Uitloggen
                    </a>
                </li>
            </ul>
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
                <li>
                    <a href="../index.php"> Home </a>
                </li>
                <li>
                    <a href="../Bevraging/Overzicht.php"> Bevraging</a>
                </li>
                <br/>
                <li class="sidebar-brand">
                    <h4>
                        BEHEER
                    </h4>
                </li>
                <li>
                    <a href="../AccountAanvraag/Overzicht.php">Aanvragen</a>
                </li>
                <li>
                    <a href="../Aandoening/Overzicht.php"> Aandoening </a>
                </li>
                <li>
                    <a href="../Pathologie/Overzicht.php"> Pathologie</a>
                </li>
                <li>
                    <a href="../LeeftijdsCategorie/Overzicht.php"> Leeftijdscategorie</a>
                </li>
                <li>
                    <a href="../Vragen/Overzicht.php"> Vragen</a>
                </li>
                <li>
                    <a href="../VragenLijst/Overzicht.php"> Vragenlijsten</a>
                </li>
                <li>
                    <a href="../Thema/Overzicht.php"> Thema's</a>
                </li>
            </ul>
        </div>
        <div id="page-content-wrapper">
            <div class="breadcrumb">
                <a href="../index.php"><span class="glyphicon glyphicon-home"> </a></span> <span
                    class="breadcrumb-font"> &nbsp/ Home / Account  </span>
            </div>
            <div class="container-fluid">
                <div class="row">
                    <div class="col-sm-12 col-md-12 col-lg-12">
                        <h1>Account informatie</h1>
<!--                        todo gegevens van account inladen-->
                        <div class="panel-group">
                            <div class="panel panel-primary account-panel">
                                <div class="panel-heading"><span style="color:white;" class="glyphicon glyphicon-user"></span> &nbsp; Algemeen</div>
                                <div class="panel-body">
                                    <form id="accountForm" class="form form-horizontal" role="form" method="POST"
                                          action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>">
                                        <?php $account = FinahDAO::HaalOp("api/Account", "UserInfo", $_SESSION["token"]);?>
                                        <div class="row">
                                            <div class="col-xs-5 col-sm-5 col-md-4 col-lg-2">
                                                <label for="Rol"  class="control-label">
                                                    Rol:
                                                </label>
                                            </div>
                                            <div class="col-xs-7 col-sm-7 col-md-5 col-lg-3">
                                                <input type="text" name="rol" id="Rol"  class="form-control" disabled
                                                    value="<?= $account["Rol"] ?>">
                                            </div>
                                        </div>
                                        <div class="row detail-row">
                                            <div class="col-xs-5 col-sm-5 col-md-4 col-lg-2">
                                                <label for="Voornaam"  class="control-label">
                                                    Voornaam:
                                                </label>
                                            </div>
                                            <div class="col-xs-7 col-sm-7 col-md-5 col-lg-3">
                                                <input type="text" name="voornaam" id="Voornaam" class="form-control"
                                                       value="<?= $account["Voornaam"] ?>">
                                            </div>
                                        </div>
                                        <div class="row detail-row">
                                            <div class="col-xs-5 col-sm-5 col-md-4 col-lg-2">
                                                <label for="Naam"  class="control-label">
                                                    Naam:
                                                </label>
                                            </div>
                                            <div class="col-xs-7 col-sm-7 col-md-5 col-lg-3">
                                                <input type="text" name="naam" id="Naam" class="form-control"
                                                       value="<?= $account["Naam"] ?>">
                                            </div>
                                        </div>
                                        <div class="row detail-row">
                                            <div class="col-xs-5 col-sm-5 col-md-4 col-lg-2">
                                                <label for="Adres"  class="control-label">
                                                    Adres:
                                                </label>
                                            </div>
                                            <div class="col-xs-7 col-sm-7 col-md-5 col-lg-3">
                                                <input type="text" name="Adres" id="Adres" class="form-control"
                                                       value="<?= $account["Adres"] ?>">
                                            </div>
                                        </div>
                                        <div class="row detail-row">
                                            <div class="col-xs-5 col-sm-5 col-md-4 col-lg-2">
                                                <label for="Postcode"  class="control-label">
                                                    Postcode:
                                                </label>
                                            </div>
                                            <div class="col-xs-3 col-sm-4 col-md-3 col-lg-2">
                                                <input type="text" name="postcode" id="Postcode" class="form-control" onchange="OnChange(event)"
                                                       value="<?= $account["Postcode"] ?>">
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
                                                <select name="woonplaats" class="form-control" id="Woonplaats" >
                                                    <option value=""><?= $account["Woonplaats"] ?></option>
                                                    <option value="">Neeroeteren</option>
                                                    <option value="">Maaseik</option>
                                                    <option value="">Opoeteren</option>
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
                                                <input type="text" name="telefoon" id="Telefoon" class="form-control"
                                                       value="<?= $account["Telefoon"] ?>">
                                            </div>
                                        </div>
                                        <div class="row detail-row">
                                            <div class="col-xs-5 col-sm-5 col-md-4 col-lg-2">
                                                <label for="Email"  class="control-label">
                                                    E-mail:
                                                </label>
                                            </div>
                                            <div class="col-xs-7 col-sm-7 col-md-5 col-lg-3">
                                                <input type="text" name="email" id="Email" class="form-control"
                                                       value="<?= $account["Email"] ?>">
                                            </div>
                                        </div>
                                        <div class="row detail-row">
                                            <div class="col-xs-offset-5 col-sm-offset-5 col-md-offset-4 col-lg-offset-2" >
                                                <button type="submit" name="wijzigInfo" class="btn btn-primary form-buttons">
                                                    Opslaan
                                                </button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                            <div class="panel panel-primary account-panel" >
                                <div class="panel-heading"><span class="glyphicon glyphicon-pencil"></span> &nbsp;Wachtwoord wijzigen</div>
                                <div class="panel-body">
                                    <form id="wachtwoordForm" class="form form-horizontal" role="form" method="POST"
                                        action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>">
                                        <div class="row ">
                                            <div class="col-xs-5 col-sm-5 col-md-4 col-lg-2">
                                                <label for="OudWachtWoord"  class="control-label">
                                                    Oud wachtwoord:
                                                </label>
                                            </div>
                                            <div class="col-xs-7 col-sm-7 col-md-5 col-lg-3">

                                            <input type="password" name="oudWachtwoord" id="OudWachtWoord" class="form-control">
                                            </div>
                                        </div>
                                        <div class="row detail-row">
                                            <div class="col-xs-5 col-sm-5 col-md-4 col-lg-2">

                                            <label for="NieuwWachtWoord"  class="control-label">
                                                    Nieuw wachtwoord:
                                                </label>
                                            </div>
                                            <div class="col-xs-7 col-sm-7 col-md-5 col-lg-3">
                                                <input type="password" name="wachtwoord" id="NieuwWachtWoord" class="form-control">
                                            </div>
                                        </div>
                                        <div class="row detail-row">
                                            <div class="col-xs-5 col-sm-5 col-md-4 col-lg-2">
                                                <label for="ConfWachtWoord"  class="control-label">
                                                    Herhaal Wachtwoord:
                                                </label>
                                            </div>
                                            <div class="col-xs-7 col-sm-7 col-md-5 col-lg-3">

                                            <input type="password" name="confwachtwoord" id="ConfWachtWoord" class="form-control">
                                            </div>
                                        </div>
                                        <div class="row detail-row">
                                            <div class="col-xs-offset-5 col-sm-offset-5 col-md-offset-4 col-lg-offset-2" >
                                                <button type="submit" name="wijzigWw" class="btn btn-primary form-buttons">
                                                    Opslaan
                                                </button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>

                        </div>
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
            $("#accountForm").validate({
                rules: {
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
                    postcode:{
                        required:true,
                        number:true,
                        min:1000,
                        max:9999
                    },
                    woonplaats:"required"
                },
                messages: {
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
            $("#wachtwoordForm").validate({
                rules: {
                    oudWachtwoord: {
                        required: true,
                        minlength: 8,
                        regex: /^(?=.*[A-Z])(?=.*\d).*$/
                    },
                    wachtwoord: {
                        required: true,
                        minlength: 8,
                        regex: /^(?=.*[A-Z])(?=.*\d).*$/
                    },
                    confwachtwoord: {
                        required: true,
                        minlength: 8,
                        equalTo: "#NieuwWachtWoord",
                        regex: /^(?=.*[A-Z])(?=.*\d).*$/
                    }
                },
                messages: {
                    oudWachtwoord: {
                        required: "Gelieve dit veld in te vullen",
                        minlenght: "Gelieve minimum 8 tekens in te geven",
                        regex: "Gelieve minstens 1 cijfer en 1 hoofdletter in te geven"
                    },
                    wachtwoord: {
                        required: "Gelieve dit veld in te vullen",
                        minlenght: "Gelieve minimum 8 tekens in te geven",
                        regex: "Gelieve minstens 1 cijfer en 1 hoofdletter in te geven"
                    },
                    confwachtwoord: {
                        required: "Gelieve dit veld in te vullen",
                        minlenght: "Gelieve minimum 8 tekens in te geven",
                        equalTo: "De twee wachtwoord zijn niet identiek",
                        regex: "Gelieve minstens 1 cijfer en 1 hoofdletter in te geven"
                    }
                }
            });
        });
        $("#menu-toggle").click(function (e) {
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
<?php
?>