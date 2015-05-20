<?php
require "../PHP/DAO/FinahDAO.php";
require "../PHP/Models/Bevraging.php";
require "../PHP/Models/Onderzoek.php";
require "../PHP/Models/AntwoordenLijst.php";

require "../PHP/Finah.php";
if (!isset($_POST[ "nieuw"])&&!isset($_POST["creeer"])&&!isset($_POST["update"])&&!isset($_POST["bewerk"])&&!isset($_POST["details"])){
    header('Location: Overzicht.php');
    exit;
}
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
        <script src="../js/finah.js"></script>


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
                    var url = "http://finahbackend1920.azurewebsites.net/Aandoening/" + val + "/Pathologie";
                    //var url = "http://localhost:1695/Aandoening/" + val + "/Pathologie";
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

            function OnChange2(e) {
                var vrl = document.forms["myForm"]["Vragenlijst"];
                var val = e.target.value;

                if (val != 'null') {
                    empty(vrl);
                    var pat = '';
                    var xhr = new JSONHttpRequest();
                    //TODO link aanpassen naar Azure
                    var url = "http://finahbackend1920.azurewebsites.net/Aandoening/" + val + "/Vragenlijst";
                    //var url = "http://localhost:1695/Aandoening/" + val + "/Vragenlijst";
                    xhr.open("GET", url, true);

                    xhr.onreadystatechange = function () {
                        if (xhr.readyState === 4 && xhr.status === 200) {
                            pat = JSON.parse(xhr.responseText);
                            for (var i = 0; i < pat.length; i++) {
                                var option = document.createElement('option');
                                option.value = pat[i].Id;
                                option.textContent = pat[i].Omschrijving;
                                option.innerText = pat[i].Omschrijving;
                                vrl.appendChild(option);
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
            <a class="btn dropdown-toggle pull-left" type="button" id="menu1" data-toggle="dropdown">Rafaël.Sarrechia
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
                    class="breadcrumb-font"> &nbsp/ Home / Bevraging  </span>
            </div>
            <div class="container-fluid">
                <div class="row">
                    <div class="col-sm-12 col-md-12 col-lg-12">
                        <?php
                        $onderzoek = new Onderzoek();
                                if (isset($_POST)) {
                                    if (isset($_POST["bewerk"]) || isset($_POST["update"]) || isset($_POST["creeer"]) || isset ($_POST["nieuw"])) {
                                        if (isset($_POST["bewerk"])) {
                                            $id = $_POST["bewerk"];
                                            $onderzk = FinahDAO::HaalOp("Onderzoek",$id);
                                            $onderzoek = $onderzk[0];
                                            $informatie = $onderzoek["Informatie"];
                                            $leeftijdcatLijst = FinahDAO::HaalOp("LeeftijdsCategorie");
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
                                            $vrl = $_POST["Vragenlijst"];
                                            if (isset($_POST["nieuw"])) {
                                                //TODO id laten genereren op Backend
                                                $onderzoek->setId(0);
                                                $onderzoek->setAandoening(FinahDAO::HaalOp("Aandoening", $aandoening));
                                                //TODO wanneer we met accounts werken verder uitwerken
                                                $onderzoek->setAangemaaktDoor(null);
                                                $onderzoek->setPathologie(FinahDAO::HaalOp("Pathologie", $pathologie));
                                                $bevraging_pat = new Bevraging();
                                                $bevraging_pat->setIsPatient(true);
                                                $bevraging_man = new Bevraging();
                                                $bevraging_man->setIsPatient(false);
                                                $ids = FinahDAO::HaalOp("Bevraging", "UniekeIds");
                                                $bevraging_pat->setId($ids[0]);
                                                $bevraging_man->setId($ids[1]);
                                                //$antwoorden_pat = new AntwoordenLijst();
                                                //$antwoorden_pat->setId(0);
                                                //$antwoorden_pat->setBevragingId($bevraging_pat->getId());
                                                //$bevraging_pat->setLeeftijdsCategorie(FinahDAO::HaalOp("Leeftijdscategorie", $leeftijdcatPat));
                                                $bevraging_pat->setLeeftijdsCategorieId($leeftijdcatPat);
                                                $datum = new DateTime("Now");
                                                $dat = $datum->format('d/m/Y G:i:s');
                                                $dateTime = DateTime::createFromFormat('d/m/Y G:i:s', $dat);
                                                //$bevraging_pat->setDatum($dateTime);
                                                //$antwoorden_man = new AntwoordenLijst();
                                                //$antwoorden_man->setId(0);
                                                //$antwoorden_man->setBevragingId($bevraging_man->getId());
                                                //$antwoorden_man->setLeeftijdsCategorie(FinahDAO::HaalOp("Leeftijdscategorie", $leeftijdcatMan));
                                                $bevraging_man->setLeeftijdsCategorieId($leeftijdcatPat);
                                                //$bevraging_man->setDatum($dateTime);
                                                $vragen = FinahDAO::HaalOp("VragenLijst", $vrl);
                                                $onderzoek->setVragen($vragen);
                                                $leeg_vragen = array_fill(0, count($vragen["Vragen"]), 0);
                                                $bevraging_pat->setAntwoorden(implode(',', $leeg_vragen));
                                                $bevraging_man->setAntwoorden(implode(',', $leeg_vragen));
                                                FinahDAO::SchrijfWeg("Bevraging",$bevraging_pat);
                                                FinahDAO::SchrijfWeg("Bevraging",$bevraging_man);
                                                $onderzoek->setBevragingPat($bevraging_pat);
                                                $onderzoek->setBevragingMan($bevraging_man);
                                                $onderzoek->setInformatie($informatie);
                                                $onderzoek->setRelatie(FinahDAO::HaalOp("Relatie", $relatie));
                                                //TODO vragenlijst ophalen
                                                /*$vrLijst = $aandoening . "/Vragenlijst";
                                                $vragen = FinahDAO::HaalOp("Aandoening", $vrLijst);*/

                                                if (FinahDAO::SchrijfWeg("Onderzoek", $onderzoek)) {
                                                    //Todo eventueel een exception toevoegen hier
                                    /*                $antwoorden_man->setBevraging(FinahDAO::HaalOp("Bevraging", $antwoorden_man->getBevragingId()));
                                                    $antwoorden_pat->setBevraging(FinahDAO::HaalOp("Bevraging", $antwoorden_pat->getBevragingId()));
                                                    if (FinahDAO::SchrijfWeg("AntwoordenLijst", $antwoorden_pat) && FinahDAO::SchrijfWeg("AntwoordenLijst", $antwoorden_man)) {
                                                        //Todo eventueel een exception toevoegen hier
                                                        //header("Location: Overzicht.php");
                                                        echo "De bevraging werd succesvol opgeslagen";
                                                        $to = "gert.claeskens@student.pxl.be";
                                                        /*                            $headers  = 'MIME-Version: 1.0' . "\r\n";
                                                                                    $headers .= 'Content-type: text/html; charset=iso-8859-1' . "\r\n";
                                                                                    $headers .= 'From: gert.claeskens@student.pxl.be' . "\r\n" .
                                                                                        'Reply-To: gert.claeskens@student.pxl.be' . "\r\n" .
                                                                                        'X-Mailer: PHP/' . phpversion();
                                                        $subject = "Bevraging aangemaakt op ";
                                                        $msg = "Beste\r\nHartelijk dank voor jouw aanvraag\r\n\r\n";
                                                        $msg .= "<a href=\"http:\\\\www.finah.be\\?" . $bevraging_man->getId() . "\">De vragenlijst voor de mantelzorger kan u hier vinden</a>\r\n";
                                                        $msg .= "<a href=\"http:\\\\www.finah.be\\?" . $bevraging_pat->getId() . "\">De vragenlijst voor de patient kan u hier vinden</a>\r\n";
                                                        //$msg .= "<a href=\"http:\\\\www.google.be\">Achteraf kan u de ze link gebruiken om het rapport op te vragen</a>\r\n";
                                                        $msg .= "\r\n\r\nMet vriendelijke groeten\r\n\r\nFinah Webmaster";
                                                        $msg = wordwrap($msg, 70, "\r\n");
                                                        Finah::send_simple_message($to, $subject, $msg);
                                                    }*/
                                                }
                                            } else {
                                                if (isset($_POST["update"])) {
                                                    $id = $_POST["update"];

                                                    $onderzoek->setId($id);
                                                    if (FinahDAO::PasAan("Onderzoek", $id, $onderzoek)) {

                                                    }
                                                    $onderzk = FinahDAO::HaalOp("Onderzoek", $id);
                                                    $onderzoek = $onderzk[0];
                                                    $informatie = $onderzoek["Informatie"];
                                                    echo "<h1 class='header'>" . " Bewerken : " . $informatie . "  </h1 >";
                                                    echo "Het onderzoek werd succesvol opgeslagen";
                                                }
                                            }
                                        }


                        ?>
                        <form id="bevragingForm" class="form-horizontal" role="form" method="POST" name="myForm"
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
                                    <select class="form-control" id="Aandoening" name="aandoening" onchange="OnChange(event);OnChange2(event);">
                                        <option value="">Maak een keuze</option>
                                        <?php
                                        $aandoeningLijst = FinahDAO::HaalOp("Aandoening");
                                        foreach ($aandoeningLijst as $item) {
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
                                        <option value="">Maak een keuze</option>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label col-xs-4 col-sm-4 col-md-3 col-lg-3" for="Vragenlijst"> Kies de vragenlijst: </label>
                                <div class="col-xs-8 col-sm-8 col-md-6 col-lg-4">
                                    <select class="form-control" id="Vragenlijst" name="Vragenlijst">
                                        <option value="">Maak een keuze</option>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label col-xs-4 col-sm-4 col-md-3 col-lg-3" for="LeeftijdcategoriePat"> Kies de leeftijdscategorie (patient): </label>
                                <div class="col-xs-8 col-sm-8 col-md-6 col-lg-4">
                                    <select class="form-control" id="LeeftijdcategoriePat" name="leeftijdcategoriePat">
                                        <option value="">Maak een keuze</option>
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
                                        <option value="">Maak een keuze</option>
                                        <?php
                                            $leeftijdscategorieMan = FinahDAO::HaalOp("LeeftijdsCategorie");
                                            foreach ($leeftijdscategorieMan as $item) {
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
                                        <option value="">Maak een keuze</option>
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
    <?php
    } elseif (isset($_POST["details"])) {
        $id = $_POST["details"];
        $onderzk = FinahDAO::HaalOp("Onderzoek",$id);
        $onderzoek = $onderzk[0];
        $informatie = $onderzoek["Informatie"];
        $aandoeningLijst= $onderzoek["Aandoening"];
        $pathologieLijst = $onderzoek["Pathologie"];
        $antwPat = FinahDAO::HaalOp("Bevraging",$onderzoek["Bevraging_Pat"]["Id"]);
        $antwMan = FinahDAO::HaalOp("Bevraging",$onderzoek["Bevraging_Man"]["Id"]);
        $leeftijdcatPatVan = $antwPat["LeeftijdsCategorie"]["Van"];
        $leeftijdcatPatTot = $antwPat["LeeftijdsCategorie"]["Tot"];
        $leeftijdcatManVan = $antwMan["LeeftijdsCategorie"]["Van"];
        $leeftijdcatManTot = $antwMan["LeeftijdsCategorie"]["Tot"];
        $relatie = $onderzoek["Relatie"]["Naam"];
        ?>
        <div class="panel panel-primary">
            <div class="panel-heading ">
                <h1 class="panel-title"><span
                        class="big-font"> Details: <?php echo "Bevraging " . $id ?> </span></h1>
            </div>
            <div class="panel-body">
                <div class="row">
                    <div class="col-xs-3 col-sm-3 col-md-3 col-lg-2">
                        <label>ID:</label>
                    </div>
                    <div class="col-xs-3 col-sm-3 col-md-3 col-lg-2">
                        <?php echo $id ?>
                    </div>
                </div>
                <div class="row detail-row">
                    <div class="col-xs-3 col-sm-3 col-md-3 col-lg-2">
                        <label>Informatie:</label>
                    </div>
                    <div class="col-xs-3 col-sm-3 col-md-3 col-lg-2 text-nowrap">
                        <?php echo $informatie ?>
                    </div>
                </div>
                <div class="row detail-row">
                    <div class="col-xs-3 col-sm-3 col-md-3 col-lg-2">
                        <label>Aandoening:</label>
                    </div>
                    <div class="col-xs-3 col-sm-3 col-md-3 col-lg-2">
                        <?php
                        $i = 0;
                        if (count($aandoeningLijst) == 3) {
                            echo $aandoeningLijst["Omschrijving"];
                        } else {
                            foreach ($aandoeningLijst as $item) {
                                $i++;
                                echo $item[$i]["Omschrijving"];
                            }
                        }
                    ?>
                    </div>
                </div>
                <div class="row detail-row">
                    <div class="col-xs-3 col-sm-3 col-md-3 col-lg-2">
                        <label>Pathologie:</label>
                    </div>
                    <div class="col-xs-3 col-sm-3 col-md-3 col-lg-2">
                        <?php
                        $i = 0;
                        if (count($pathologieLijst) == 3) {
                            echo $pathologieLijst["Omschrijving"];
                        } else {
                            foreach ($pathologieLijst as $item) {
                                $i++;
                                echo $item[$i]["Omschrijving"];
                            }
                        }
                        ?>
                    </div>
                </div>
                <div class="row detail-row ">
                    <div class="col-xs-3 col-sm-3 col-md-3 col-lg-2">
                        <label>Leeftijdscategorie mantelzorger:</label>
                    </div>
                    <div class="col-xs-3 col-sm-3 col-md-3 col-lg-2">
                        <?php
                        echo "Van " . $leeftijdcatManVan . " tot " . $leeftijdcatManTot;
                        ?>
                    </div>
                </div>
                <div class="row detail-row">
                    <div class="col-xs-3 col-sm-3 col-md-3 col-lg-2">
                        <label>Leeftijdscategorie patient:</label>
                    </div>
                    <div class="col-xs-3 col-sm-3 col-md-3 col-lg-2">
                        <?php
                        echo "Van " . $leeftijdcatPatVan . " tot " . $leeftijdcatPatTot;
                        ?>
                    </div>
                </div>
                <div class="row detail-row">
                    <div class="col-xs-3 col-sm-3 col-md-3 col-lg-2">
                        <label>Relatie:</label>
                    </div>
                    <div class="col-xs-3 col-sm-3 col-md-3 col-lg-2">
                        <?php
                            echo $relatie;
                        ?>
                    </div>
                </div>
                <div class="row button-row">
                    <div
                        class="col-xs-offset-3 col-sm-offset-3 col-md-offset-3 col-lg-offset-2">
                        <form class="form-horizontal form-buttons" role="form" method="POST" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>">
                        <button type="button" onclick="location.href='Overzicht.php'"
                                class="btn btn-primary">
                            Terug
                        </button>
                        <button type='submit' name='bewerk' id='<?php echo $id ?>'
                                class='btn btn-primary' value="<?php echo $id ?>">
                            Bewerken
                        </button>
                        <button type='button' title='Verwijderen' id='<?php echo $id ?>'
                                name='verwijderBtn' value="<?php echo $id ?>"
                                class='delBtn btn btn-primary'
                                onclick="Confirm.render('Verwijder bevraging?','delete_lft',<?php echo $id ?>,'Bevraging',this)">
                            Verwijderen
                        </button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    <?php
        }
    }
        ?>
        <script>
            $().ready(function () {
                 $("#bevragingForm").validate({
                     rules: {
                         informatie: "required",
                         aandoening: "required",
                         Pathologie: "required",
                         Vragenlijst: "required",
                         leeftijdcategoriePat: "required",
                         leeftijdcategorieMan: "required",
                         relatie: "required"
                     },
                     messages: {
                         informatie: "Gelieve dit veld in te vullen!",
                         aandoening: "Gelieve een keuze te maken!",
                         Pathologie: "Gelieve een keuze te maken!",
                         Vragenlijst: "Gelieve een keuze te maken!",
                         leeftijdcategoriePat: "Gelieve een keuze te maken!",
                         leeftijdcategorieMan: "Gelieve een keuze te maken!",
                         relatie: "Gelieve een keuze te maken!"
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