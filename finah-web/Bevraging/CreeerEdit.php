<?php
require "../PHP/DAO/FinahDAO.php";
require "../PHP/Models/Bevraging.php";
require "../PHP/Models/Onderzoek.php";
require "../PHP/Models/AntwoordenLijst.php";
require "../PHP/Finah.php";
?>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1"/>
        <title>FINAH - Bevraging</title>
        <link rel="stylesheet" type="text/css" href="../Css/Stylesheet.css"/>
        <link rel="stylesheet" type="text/css" href="../Css/bootstrap.css"/>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
        <script src="http://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script src="../js/Validate/jquery.validate.js"></script>
        <script src="../js/jsonhttprequest.js"></script>

        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
        <script type="text/javascript">
            var data = '';

            function OnChange(e) {
                var patho = document.forms["myForm"]["Pathologie"];
                var val = e.target.value;

                if (val != 'null') {
                    empty(patho);
                    var pat = '';
                    var xhr = new JSONHttpRequest();
                    //TODO link aanpassen naar Azure
                    var url = "http://localhost:1695/Aandoening/" + val + "/Pathologie";
                    xhr.open("GET", url, true);

                    xhr.onreadystatechange = function () {
                        if (xhr.readyState === 4 && xhr.status === 200) {
                            pat = JSON.parse(xhr.responseText);
                            for (var i = 0; i < pat.length; i++) {
                                var option = document.createElement('option');
                                option.value = pat[i].Id;
                                option.textContent = pat[i].Omschrijving;
                                option.innerText = pat[i].Omschrijving;
                                patho.appendChild(option);
                            }
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
            <a class="navbar-brand header" href="#"> Finah</a>
        </div>
        <div class="dropdown navbar-header pull-right nav-right">
            <span class="img-circle"><img src="../Images/blank-avatar.png"/></span>
            <!--TODO  PHP if'ke maken voor als er een avatar/profiel foto beschikbaar is in database of niet ( dan blank-avatar gebruiken) -->
            <a class="btn dropdown-toggle pull-left" type="button" id="menu1" data-toggle="dropdown">Rafaël.Sarrechia
                <span class="caret"></span>
            </a>
            <ul class="dropdown-menu " role="menu" aria-labelledby="menu1">
                <li role="presentation">
                    <a role="menuitem" tabindex="0" href="#">
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
            </ul>
        </div>
        <div id="page-content-wrapper">
            <div class="breadcrumb">
                <a href="../index.php"><span class="glyphicon glyphicon-home"> </a></span> <span
                    class="breadcrumb-font"> &nbsp/ Home / Bevraging  </span>
            </div>
            <div class="container-fluid">
                <div class="row">
                    <div class="col-sm-12 col-md-12 col-lg-12">
                        <?php
                                $bevraging_man = new Bevraging();
                                $bevraging_man->setIsPatient(false);
                                $bevraging_pat = new Bevraging();
                                $bevraging_pat->setispatient(true);
                                if (isset($_POST)) {
                                    if (isset($_POST["bewerk"])) {
                                        $id = $_POST["bewerk"];
                                        $onderzoek = FinahDAO::HaalOp("Onderzoek",$id);
                                        $informatie = $onderzoek["informatie"];
                                        $aandoening = $onderzoek["aandoening"];
                                        $pathologie = $onderzoek["Pathologie"];
                                        $leeftijdcatPat = $onderzoek["leeftijdcategoriePat"];
                                        $leeftijdcatMan = $onderzoek["leeftijdcategorieMan"];
                                        $relatie = $onderzoek["relatie"];
                                        echo "<h1 class='header'>" . " Bewerken : " . $informatie . "  </h1 >";
                                    } elseif(isset($_POST["creeer"]) || isset($_POST["nieuw"])){
                                        echo "<h1 class='header' >" . " Nieuwe bevraging " .  "</h1> ";
                                    }
                                if (isset($_POST["nieuw"]) || isset($_POST["update"])) {
                                    $informatie = $_POST["informatie"];
                                    $aandoening = $_POST["aandoening"];
                                    $pathologie = $_POST["Pathologie"];
                                    $leeftijdcatPat = $_POST["leeftijdcategoriePat"];
                                    $leeftijdcatMan = $_POST["leeftijdcategorieMan"];
                                    $relatie = $_POST["relatie"];

                                    $antwoorden_pat = new AntwoordenLijst();
                                    $antwoorden_pat->setId($bevraging_pat->getId());
                                    $antwoorden_pat->setLeeftijdsCategorie(FinahDAO::HaalOp("Leeftijdscategorie", $leeftijdcatPat));

                                    $antwoorden_pat->setDatum($dateTime);
                                    $antwoorden_man = new AntwoordenLijst();
                                    $antwoorden_man->setId($bevraging_man->getId());
                                    $antwoorden_man->setLeeftijdsCategorie(FinahDAO::HaalOp("Leeftijdscategorie", $leeftijdcatMan));
                                    $antwoorden_man->setDatum($dateTime);

                                    if (isset($_POST["nieuw"])){
                                        //TODO id laten genereren op Backend

                                        $ids = FinahDAO::HaalOp("Bevraging", "UniekeIds");
                                        $bevraging_pat->setId($ids[0]);
                                        $bevraging_man->setId($ids[1]);
                                        $onderzoek = new Onderzoek();
                                        $onderzoek->setId(0);
                                        $onderzoek->setAandoening(FinahDAO::HaalOp("Aandoening", $aandoening));
                                        //TODO wanneer we met accounts werken verder uitwerken
                                        $onderzoek->setBevragingPat($bevraging_pat);
                                        $onderzoek->setBevragingMan($bevraging_man);
                                        $onderzoek->setInformatie($informatie);
                                        $onderzoek->setRelatie(FinahDAO::HaalOp("Relatie", $relatie));
                                        $onderzoek->setAangemaaktDoor(null);
                                        $onderzoek->setPathologie(FinahDAO::HaalOp("Pathologie", $pathologie));
                                        //TODO vragenlijst ophalen
                                        $vrLijst = $aandoening . "/Vragenlijst";
                                        $vragen = FinahDAO::HaalOp("Aandoening", $vrLijst);
                                        $onderzoek->setVragen($vragen);
                                        $leeg_vragen = array_fill(0, count($vragen["Vragen"]) - 1, 0);
                                        $antwoorden_pat->setAntwoorden($leeg_vragen);
                                        $antwoorden_man->setAntwoorden($leeg_vragen);
                                        //new DateTime(date("d/m/Y G:i:s")))
                                        $datum = new DateTime("Now");
                                        $dat = $datum->format('d/m/Y G:i:s');
                                        $dateTime = DateTime::createFromFormat('d/m/Y G:i:s', $dat);
                                        if (FinahDAO::SchrijfWeg("Onderzoek", $onderzoek)) {
                                            //Todo eventueel een exception toevoegen hier
                                            $antwoorden_man->setBevraging(FinahDAO::HaalOp("Bevraging", $antwoorden_man->getId()));
                                            $antwoorden_pat->setBevraging(FinahDAO::HaalOp("Bevraging", $antwoorden_pat->getId()));
                                            if (FinahDAO::SchrijfWeg("AntwoordenLijst", $antwoorden_pat) && FinahDAO::SchrijfWeg("AntwoordenLijst", $antwoorden_man)) {
                                                //Todo eventueel een exception toevoegen hier
                                                //header("Location: Overzicht.php");
                                                echo "De bevraging werd succesvol opgeslagen";
                                                $to = "gert.claeskens@student.pxl.be";
                                                /*                            $headers  = 'MIME-Version: 1.0' . "\r\n";
                                                                            $headers .= 'Content-type: text/html; charset=iso-8859-1' . "\r\n";
                                                                            $headers .= 'From: gert.claeskens@student.pxl.be' . "\r\n" .
                                                                                'Reply-To: gert.claeskens@student.pxl.be' . "\r\n" .
                                                                                'X-Mailer: PHP/' . phpversion();*/
                                                $subject = "Bevraging aangemaakt op ";
                                                $msg = "Beste\r\nHartelijk dank voor jouw aanvraag\r\n\r\n";
                                                $msg .= "<a href=\"http:\\\\www.finah.be\\?" . $bevraging_man->getId() . "\">De vragenlijst voor de mantelzorger kan u hier vinden</a>\r\n";
                                                $msg .= "<a href=\"http:\\\\www.finah.be\\?" . $bevraging_pat->getId() . "\">De vragenlijst voor de patient kan u hier vinden</a>\r\n";
                                                //$msg .= "<a href=\"http:\\\\www.google.be\">Achteraf kan u de ze link gebruiken om het rapport op te vragen</a>\r\n";
                                                $msg .= "\r\n\r\nMet vriendelijke groeten\r\n\r\nFinah Webmaster";
                                                $msg = wordwrap($msg, 70, "\r\n");
                                                Finah::send_simple_message($to, $subject, $msg);
                                            }
                                        }
                                    }
                                }

                        }?>
                        <form id="aandoeningForm" class="form-horizontal" role="form" method="POST"
                              action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>">

                            <div class="form-group top-form">
                                <label class="control-label col-xs-4 col-sm-4 col-md-3 col-lg-3" for="Informatie"> Informatie: </label>
                                <div class=" col-xs-8 col-sm-8 col-md-8 col-lg-4">
                                    <textarea rows="5" type="text" class="form-control" id="Informatie" name="informatie" ><?php if (isset($_POST["bewerk"]) || isset($_POST["update"])) {
                                                echo $informatie;
                                          } ?></textarea>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-xs-4 col-sm-4 col-md-3 col-lg-3" for="Aandoening"> Kies de aandoening: </label>
                                <div class="col-xs-8 col-sm-8 col-md-6 col-lg-4">
                                    <select class="form-control" id="Aandoening" name="aandoening" onchange="OnChange(event)">
                                        <option value="null">Maak een keuze</option>
                                        <?php
                                        $aandoening = FinahDAO::HaalOp("Aandoening");
                                        foreach ($aandoening as $item) {
                                            echo "<option value='" . $item["Id"] . "'>" . $item["Omschrijving"] . "</option>\r\n";
                                        }
                                        ?>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-xs-4 col-sm-4 col-md-3 col-lg-3" for="Pathologie"> Kies de pathologie: </label>
                                <div class="col-xs-8 col-sm-8 col-md-6 col-lg-4">
                                    <select class="form-control" id="Pathologie" name="Pathologie">
                                        <option value="null">Maak een keuze</option>
                                        <?php
                                        //todo  code voor pathologielijst op te halen
                                        ?>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-xs-4 col-sm-4 col-md-3 col-lg-3" for="LeeftijdcategoriePat"> Kies de leeftijdscategorie (patient): </label>
                                <div class="col-xs-8 col-sm-8 col-md-6 col-lg-4">
                                    <select class="form-control" id="LeeftijdcategoriePat" name="leeftijdcategoriePat">
                                        <option value="null">Maak een keuze</option>
                                        <?php
                                        $leeftijdscategoriePat = FinahDAO::HaalOp("LeeftijdsCategorie");
                                        foreach ($leeftijdscategoriePat as $item) {
                                            echo "<option value='" . $item["Id"] . "'>" . $item["Van"] . " tot " . $item["Tot"] . "</option>\r\n";
                                        }
                                        ?>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-xs-4 col-sm-4 col-md-3 col-lg-3" for="LeeftijdscategorieMan"> Kies de leeftijdscategorie (mantelzorger): </label>
                                <div class="col-xs-8 col-sm-8 col-md-6 col-lg-4">
                                    <select class="form-control" id="LeeftijdcategorieMan" name="leeftijdcategorieMan">
                                        <option value="null">Maak een keuze</option>
                                        <?php
                                        $leeftijdscategoriePat = FinahDAO::HaalOp("LeeftijdsCategorie");
                                        foreach ($leeftijdscategoriePat as $item) {
                                            echo "<option value='" . $item["Id"] . "'>" . $item["Van"] . " tot " . $item["Tot"] . "</option>\r\n";
                                        }

                                        ?>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-xs-4 col-sm-4 col-md-3 col-lg-3" for="Relatie"> Kies de relatie tussen patient en mantelzorger: </label>
                                <div class="col-xs-8 col-sm-8 col-md-6 col-lg-4">
                                    <select class="form-control" id="Relatie" name="relatie">
                                        <option value="null">Maak een keuze</option>
                                        <?php
                                        $relatie = FinahDAO::HaalOp("Relatie");
                                        foreach ($relatie as $item) {
                                            echo "<option value='" . $item["Id"] . "'>" . $item["Naam"] . "</option>\r\n";
                                        }

                                        ?>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class=" col-xs-offset-4 col-sm-offset-4 col-md-offset-3 col-lg-offset-3 col-sm-10">
                                    <button type="button" onclick="location.href='Overzicht.php'" class="btn btn-primary">
                                        Terug
                                    </button>
                                    <button class="btn btn-primary" type="submit"
                                            name=<?php if (isset($_POST["bewerk"])) {
                                                echo "'update'";
                                            } elseif (isset($_POST["creeer"])) {
                                                echo "'nieuw'";
                                            } elseif (isset($_POST["nieuw"])) {
                                                echo "'nieuw'";
                                            } elseif (isset($_POST["update"])){
                                                echo "'update'";
                                            }
                                            if (!isset($_POST["creeer"])){?> value="<?php echo $id ;}?>"> Opslaan
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
                 $("#aandoeningForm").validate({
                     rules: {
                         omschrijving: "required"
                     },
                     messages: {
                         omschrijving: "Veld is verplicht."
                     }
                 });
             })
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