<?php
    /**
     * Created by PhpStorm.
     * User: Rafaël
     * Date: 6/04/2015
     * Time: 15:24
     */
    require_once "../PHP/DAO/FinahDAO.php";
    require_once "../PHP/Models/Aanvraag.php";
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>FINAH - Registratie</title>
    <link rel="stylesheet" type="text/css" href="../Css/Stylesheet.css"/>
    <link rel="stylesheet" type="text/css" href="../Css/bootstrap.css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <script src="../js/jquery-2.1.3.min.js"></script>
    <script src="../js/Validate/jquery.validate.js"></script>
    <script src="../js/jsonhttprequest.js"></script>
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <script type="text/javascript">
        var data = '';
        function OnChange(e) {
            var postc = document.forms["registratieForm"]["Postcode"];
            var val = e.target.value;
            if (val != 'null') {
                empty(postc);
                var pc = '';
                var xhr = new JSONHttpRequest();
                //TODO link aanpassen naar Azure
                var url = "http://finahbackend1920.azurewebsites.net/Postcode/" + val;
                //var url = "http://localhost:1695/Aandoening/" + val + "/Pathologie";
                xhr.open("GET", url, true);
                xhr.onreadystatechange = function () {
                    if (xhr.readyState === 4 && xhr.status === 200) {
                        pc = JSON.parse(xhr.responseText);
                        postc.value = pc.Postnr;
                    }
                };
                xhr.send(null);
            }
        }
         function empty(select) {
            select.innerHTML = '';
        }
    </script>
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
            <li>
                <a href="../index.php"> Home </a>
            </li>
        </ul>
    </div>
    <div id="page-content-wrapper">
        <div class="breadcrumb">
            <span class="glyphicon glyphicon-home"></span> &nbsp / &nbsp <span
                class="breadcrumb-font">Registratie </span>
        </div>
        <?php
            if (isset($_POST["registreren"])){
                var_dump($_POST);
                $typeacc=$_POST["rol"];
                $usernm = $_POST["username"];
                $voornaam = $_POST["voornaam"];
                $naam = $_POST["naam"];
                $email = $_POST["email"];
                $wachtwoord = $_POST["wachtwoord"];
                $confww = $_POST["confwachtwoord"];
                $adres = $_POST["adres"];
                $pcId = $_POST["woonplaats"];
                $telefoon = $_POST["telefoon"];
                $captcha = $_POST["captcha"];

                $av = new Aanvraag();
                $av->setId(0);
                $av->setLogin($usernm);
                $av->setNaam($naam);
                $av->setVoornaam($voornaam);
                $av->setAdres($adres);
                $av->setEmail($email);
                $av->setPostc(FinahDAO::HaalOp("Postcode",$pcId));
                $av->setPasswd($wachtwoord);
                $av->setTelnr($telefoon);
                $av->setTypeAcc($typeacc);
                var_dump($av);
                var_dump(FinahDAO::SchrijfWeg("Aanvraag",$av));
                //TODO controle op ww en captcha
                if ($wachtwoord == $confww){
                    if ($captcha == 2 || $captcha == "2"){
                        //$av->setPasswd($wachtwoord);
                        //FinahDAO::SchrijfWeg("Aanvraag",$av);
                    }else {
                        echo "Captcha niet goed.";
                    }
                }else {
                    echo "wachtwoorden komen niet overeen.";
                }

            }else{

        ?>
        <div class="container-fluid">
            <div class="row">

                <div class="col-lg-12 col-md-12 col-sm-12">
                    <h1 style="margin-bottom:50px;">Registratie</h1>

                    <form id="registratieForm" class="form form-horizontal" role="form" method="POST"
                          action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>">
                        <div class="row">
                            <div class="col-xs-5 col-sm-5 col-md-4 col-lg-2">
                                <label for="rol" class="control-label">
                                    Rol:
                                </label>
                            </div>
                            <div class="col-xs-7 col-sm-7 col-md-5 col-lg-3">
                                <select class="form-control" id="rol" name="rol">
                                    <option value="">Maak een keuze</option>
                                    <option value="Onderzoeker">Onderzoeker</option>
                                    <option value="Hulpverlener">Hulpverlener</option>
                                </select>
                            </div>
                        </div>
                        <div class="row detail-row">
                            <div class="col-xs-5 col-sm-5 col-md-4 col-lg-2">
                                <label for="Username" class="control-label">
                                    Username:
                                </label>
                            </div>
                            <div class="col-xs-3 col-sm-4 col-md-3 col-lg-2 text-nowrap">
                                <input type="text" name="username" id="Username" class="form-control">
                            </div>
                        </div>
                        <div class="row detail-row">
                            <div class="col-xs-5 col-sm-5 col-md-4 col-lg-2">
                                <label for="Voornaam" class="control-label">
                                    Voornaam:
                                </label>
                            </div>
                            <div class="col-xs-7 col-sm-7 col-md-5 col-lg-3">
                                <input type="text" name="voornaam" id="Voornaam" class="form-control">
                            </div>
                        </div>
                        <div class="row detail-row">
                            <div class="col-xs-5 col-sm-5 col-md-4 col-lg-2">
                                <label for="Naam" class="control-label">
                                    Naam:
                                </label>
                            </div>
                            <div class="col-xs-7 col-sm-7 col-md-5 col-lg-3">
                                <input type="text" name="naam" id="Naam" class="form-control">
                            </div>
                        </div>
                        <div class="row detail-row">
                            <div class="col-xs-5 col-sm-5 col-md-4 col-lg-2">
                                <label for="Email" class="control-label">
                                    E-mail:
                                </label>
                            </div>
                            <div class="col-xs-7 col-sm-7 col-md-5 col-lg-3">
                                <input type="text" name="email" id="Email" class="form-control">
                            </div>
                        </div>
                        <div class="row detail-row">
                            <div class="col-xs-5 col-sm-5 col-md-4 col-lg-2">
                                <label for="Wachtwoord" class="control-label">
                                    Wachtwoord:
                                </label>
                            </div>
                            <div class="col-xs-7 col-sm-7 col-md-5 col-lg-3 ">
                                <input type="password" name="wachtwoord" id="Wachtwoord" class="form-control">
                            </div>
                        </div>
                        <div class="row detail-row">
                            <div class="col-xs-5 col-sm-5 col-md-4 col-lg-2">
                                <label for="confWachtwoord" class="control-label">
                                    Herhaal wachtwoord:
                                </label>
                            </div>
                            <div class="col-xs-7 col-sm-7 col-md-5 col-lg-3">
                                <input type="password" name="confwachtwoord" id="confWachtwoord" class="form-control">
                            </div>
                        </div>
                        <div class="row detail-row">
                            <div class="col-xs-5 col-sm-5 col-md-4 col-lg-2">
                                <label for="Adres" class="control-label">
                                    Adres:
                                </label>
                            </div>
                            <div class="col-xs-7 col-sm-7 col-md-5 col-lg-3">
                                <input type="text" name="adres" id="Adres" class="form-control">
                            </div>
                        </div>

                        <div class="row detail-row">
                            <div class="col-xs-5 col-sm-5 col-md-4 col-lg-2">
                                <label for="Postcode" class="control-label">
                                    Postcode:
                                </label>
                            </div>
                            <div class="col-xs-3 col-sm-4 col-md-3 col-lg-2 text-nowrap">
                                <input type="text" name="postcode" id="Postcode" class="form-control">
                            </div>
                        </div>
                        <!--                                        todo met javascript adhv postcode de mogelijke woonplaatsen weergeven in een combobox (== bevraging create ) -->
                        <div class="row detail-row">
                            <div class="col-xs-5 col-sm-5 col-md-4 col-lg-2">
                                <label for="Woonplaats" class="control-label">
                                    Woonplaats:
                                </label>
                            </div>
                            <div class="col-xs-7 col-sm-7 col-md-5 col-lg-3">
                                <select class="form-control" id="Woonplaats" name="woonplaats" onchange="OnChange(event)">
                                    <?php
                                        $postcodes = FinahDAO::HaalOp("Postcode");
                                        foreach ($postcodes as $item) {
                                            echo "<option value='" . $item["Id"] . "'>" . $item["Gemeente"] . "</option>\r\n";

                                        }
                                    ?>
                                </select>
                            </div>
                        </div>
                        <div class="row detail-row">
                            <div class="col-xs-5 col-sm-5 col-md-4 col-lg-2">
                                <label for="Telefoon" class="control-label">
                                    Telefoon:
                                </label>
                            </div>
                            <div class="col-xs-7 col-sm-7 col-md-5 col-lg-3">
                                <input type="text" name="telefoon" id="Telefoon" class="form-control">
                            </div>
                        </div>

                        <div class="row detail-row">
                            <div class="col-xs-5 col-sm-5 col-md-4 col-lg-2">
                                <label for="Captcha" class="control-label">
                                    1+1:
                                </label>
                            </div>
                            <div class="col-xs-7 col-sm-7 col-md-5 col-lg-3">
                                <input type="text" name="captcha" id="Captcha" class="form-control">
                            </div>
                        </div>
                        <div class="row detail-row">
                            <div class="col-xs-offset-5 col-sm-offset-5 col-md-offset-4 col-lg-offset-2">
                                <button type="button" name="terug" class="btn btn-primary form-buttons"
                                        onclick="location.href='../index.php'">
                                    Terug
                                </button>
                                <button type="submit" name="registreren" value="registreren" class="btn btn-primary form-buttons">
                                    Registreren
                                </button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <?php } ?>
    </div>
</div>
<script>
    $().ready(function () {
        $.validator.addMethod(
            "regex",
            function (value, element, regexp) {
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
                    required: true,
                    number: true,
                    min: 1
                },
                straat: "required",
                email: {
                    required: true,
                    email: true
                },
                telefoon: {
                    required: true,
                    minlength: 9
                },
                wachtwoord: {
                    required: true,
                    minlength: 6,
                    regex: /((?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})/



                },
                confwachtwoord: {
                    required: true,
                    minlength: 6,
                    equalTo: "#Wachtwoord",
                    regex: /((?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})/

                },
                postcode: {
                    required: true,
                    number: true,
                    min: 1000,
                    max: 9999
                }
                ,woonplaats: "required"
            },
            messages: {
                rol: "Gelieve een keuze te maken!",
                voornaam: "Gelieve dit veld in te vullen!",
                naam: "Gelieve dit veld in te vullen!",
                huisnr: {
                    required: "Gelieve dit veld in te vullen",
                    number: "Gelieve een numerieke waarde in te vullen",
                    min: "Gelieve een positieve waarde in te vullen"
                },
                straat: "Gelieve dit veld in te vullen!",
                email: {
                    required: "Gelieve dit veld in te vullen!",
                    email: "Gelieve een legitiem email adres in te vullen (Voorbeeld: test@test.com"
                },
                wachtwoord: {
                    required: "Gelieve dit veld in te vullen",
                    minlenght: "Gelieve minimum 6 tekens in te geven",
                    regex: "Gelieve minstens 6 tekens in te voeren waarvan minstens 1 cijfer, 1 uppercase, 1 lowercase en minstens 1 teken (@#$%)"
                },
                confwachtwoord: {
                    required: "Gelieve dit veld in te vullen",
                    minlenght: "Gelieve minimum 6 tekens in te geven",
                    equalTo: "De twee wachtwoord zijn niet identiek",
                    regex: "Gelieve minstens 6 tekens in te voeren waarvan minstens 1 cijfer, 1 uppercase, 1 lowercase en minstens 1 teken (@#$%)"
                },
                telefoon: {
                    required: "Gelieve dit veld in te vullen!",
                    min: "Gelieve een correct telefoon nummer in te voeren"
                },
                postcode: {
                    required: "Gelieve dit veld in te vullen!",
                    number: "Gelieve een numerieke waarde in te vullen",
                    min: "Een postcode heeft 4 cijfers",
                    max: "Een postcode heeft max 4 cijfers"
                }
                ,woonplaats: "Gelieve een keuze te maken!"
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

