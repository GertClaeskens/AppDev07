<?php
    require "../PHP/DAO/FinahDAO.php";
    require "../PHP/Models/VragenLijst.php";
    require "../PHP/Models/Aandoening.php";
    if (!isset($_POST["nieuw"]) && !isset($_POST["creeer"]) && !isset($_POST["update"]) && !isset($_POST["bewerk"]) && !isset($_POST["details"])) {
        header('Location: Overzicht.php');
        exit;
    }
    session_start();
?>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1"/>
        <title>FINAH - Vragenlijst</title>
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
                        class="breadcrumb-font"> &nbsp/ Home / Vragenlijst  </span>
                </div>
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-sm-12 col-md-12 col-lg-12">
                            <div id="mededeling">

                            </div>
                            <?php

                                if (isset($_POST)) {
                                $vragenlijst = new VragenLijst();
                                $id = null;
                                if (isset($_POST["bewerk"]) || isset($_POST["update"]) || isset($_POST["creeer"]) || isset ($_POST["nieuw"])) {

                                if (isset($_POST["bewerk"]) || isset($_POST["update"])) {
                                    $id = isset($_POST["bewerk"]) ? $_POST["bewerk"] : $_POST["update"];
                                    $vragenlijst = FinahDAO::HaalOp("VragenLijst", $id,$_SESSION["token"]);
                                    $vragenlijstTitel = $vragenlijst["Omschrijving"];
                                    echo "<h1 class='header'>" . " Bewerken : " . $vragenlijstTitel . "  </h1 >";
                                } elseif (isset($_POST["creeer"]) || isset($_POST["nieuw"])) {
                                    echo "<h1 class='header' >" . " Nieuwe vragenlijst " . "</h1> ";
                                }
                                //Update en nieuw komen na het invullen van de gegevens
                                if (isset($_POST["nieuw"]) || isset($_POST["update"])) {//|| isset($_POST["bewerk"])) {
                                    $vragenlijstTitel = $_POST["Titel"];

                                    //Nieuw item creeeren : Id op 0 zetten anders fouten op backend met modelstate
                                    if (isset($_POST["nieuw"])) {
                                        $vragenlijst->setId(0);
                                        $vragenlijst->setOmschrijving($vragenlijstTitel);
                                        if (isset($_POST["Aandoe"])) {
                                            $aandoening = $_POST["Aandoe"];
                                            $vragenlijst->setAandoe(FinahDAO::HaalOp("Aandoening", $aandoening,$_SESSION["token"]));

                                        }
                                        if (isset($_POST["Vragen"])) {

                                            $vragenArray = $_POST["Vragen"];
                                            for ($a = 0; $a < count($vragenArray); $a++) {
                                                $vragenlijst->voegVragenToe(FinahDAO::HaalOp("Vragen", $vragenArray[$a],$_SESSION["token"]));
                                            };
                                        }
                                        //Schrijf de nieuwe vragenlijst weg
                                        FinahDAO::SchrijfWeg("Vragenlijst", $vragenlijst,$_SESSION["token"]);
                                        echo "De vragenlijst werd succesvol opgeslagen";
                                    }
                                    if (isset($_POST["update"])) {
                                        $vrlijst = new VragenLijst();
                                        //$id = $_POST["update"];
                                        $vrlijst->setId($id);
                                        $vrlijst->setOmschrijving($vragenlijstTitel);
                                        if (isset($_POST["Aandoe"])) {
                                            $aandoening = $_POST["Aandoe"];
                                            $vrlijst->setAandoe(FinahDAO::HaalOp("Aandoening", $aandoening,$_SESSION["token"]));

                                        }
                                        if (isset($_POST["Vragen"])) {
                                            $vragenArray = $_POST["Vragen"];
                                            for ($a = 0; $a < count($vragenArray); $a++) {
                                                $vrlijst->voegVragenToe(FinahDAO::HaalOp("Vragen", $vragenArray[$a],$_SESSION["token"]));
                                            };
                                        }
                                        FinahDAO::PasAan("VragenLijst", $id, $vrlijst,$_SESSION["token"]);
                                        //if (FinahDAO::PasAan("VragenLijst", $id, $vrlijst)) {
                                        /*$vragenlijst = FinahDAO::HaalOp("VragenLijst", $id);
                                        $vragenlijstTitel = $vragenlijst["Omschrijving"];
                                        echo "<h1 class='header'>" . " Bewerken : " . $vragenlijstTitel . "  </h1 >";*/
                                        echo "De vragenlijst werd succesvol opgeslagen";
                                        //}
                                    }
                                }
                            ?>
                            <form id="vragenlijstForm" class="form-horizontal" role="form" method="POST"
                                  action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>">
                                <div class="form-group top-form">
                                    <label class="control-label col-xs-4 col-sm-4 col-md-3 col-lg-3" for="Titel">
                                        Vragenlijst titel: </label>

                                    <div class="col-xs-8 col-sm-8 col-md-6 col-lg-4">
                                        <input type="text" placeholder="Voer een titel in " name="Titel"
                                               class="form-control" id="Titel" value=
                                            <?php
                                                if (isset($_POST["bewerk"]) || isset($_POST["update"])) {
                                                    echo $vragenlijstTitel;
                                                } ?>>

                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-xs-4 col-sm-4 col-md-3 col-lg-3" for="Aandoe">
                                        Selecteer de gepaste aandoening: </label>

                                    <div class="col-xs-8 col-sm-8 col-md-6 col-lg-4">
                                        <select name="Aandoe" class="form-control" id="Aandoening">
                                            <option value="">Maak een keuze</option>
                                            <?php

                                                $aandoeningen = FinahDAO::HaalOp("Aandoening",null,$_SESSION["token"]);
                                                foreach ($aandoeningen as $item) {
                                                    echo "<option value='" . $item["Id"] . "'>" . $item["Omschrijving"] . "</option>\r\n";
                                                }
                                            ?>
                                            }
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-xs-4 col-sm-4 col-md-3 col-lg-3" for="vragenAdd">
                                        Selecteer de vragen die je wil toevoegen aan de vragenlijst: </label>
                                    <div class="col-xs-8 col-sm-8 col-md-9 col-lg-9">
                                        <select id="vragenAdd" name="Vragen[]" size="20" multiple>
                                            <?php
                                                $vragenLijst = FinahDAO::HaalOp("Vragen",null,$_SESSION["token"]);
                                                foreach ($vragenLijst as $item) {
                                                    echo "<option value='" . $item["Id"] . "'>" . $item["VraagStelling"] . "</option>\r\n";
                                                }
                                            ?>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class=" col-xs-offset-4 col-sm-offset-4 col-md-offset-3 col-lg-offset-3 col-sm-10">
                                        <button type="button" onclick="location.href='Overzicht.php'"
                                                class="btn btn-primary">
                                            Terug
                                        </button>
                                        <button class="btn btn-primary" type="submit"
                                                name=<?php if (isset($_POST["bewerk"])) {
                                                    echo "'update'";
                                                } elseif (isset($_POST["creeer"])) {
                                                    echo "'nieuw'";
                                                } elseif (isset($_POST["nieuw"])) {
                                                    echo "'nieuw'";
                                                } elseif (isset($_POST["update"])) {
                                                    echo "'update'";
                                                }
                                                    if (!isset($_POST["creeer"])){
                                                ?> value="<?php echo $id;
                                                    } ?>"> Opslaan
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
            $vragenLijst = FinahDAO::HaalOp("VragenLijst", $id,$_SESSION["token"]);
            $omschrij = $vragenLijst["Omschrijving"];
            $aandoeningLijst = $vragenLijst["Aandoe"];
            $aantal = count($vragenLijst["Vragen"]);
            $vragen = $vragenLijst["Vragen"];
            ?>
            <div class="panel panel-primary">
                <div class="panel-heading ">
                    <h1 class="panel-title"><span
                            class="big-font"> Details: <?php echo "Vragenlijst " . $id ?> </span></h1>
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
                            <label>Omschrijving :</label>
                        </div>
                        <div class="col-xs-9 col-sm-9 col-md-9 col-lg-10 ">
                            <?php echo $omschrij ?>
                        </div>
                    </div>
                    <div class="row detail-row">
                        <div class="col-xs-3 col-sm-3 col-md-3 col-lg-2">
                            <label>Aandoening</label>
                        </div>
                        <div class="col-xs-9 col-sm-9 col-md-9 col-lg-10">
                            <?php
                                echo $aandoeningLijst["Omschrijving"];
                            ?>
                        </div>
                    </div>
                    <div class="row detail-row">
                        <div class="col-xs-3 col-sm-3 col-md-3 col-lg-2">
                            <label>Aantal vragen:</label>
                        </div>
                        <div class="col-xs-9 col-sm-9 col-md-9 col-lg-10">
                            <?php echo $aantal ?>
                        </div>
                    </div>
                    <div class="row detail-row">
                        <div class="col-xs-3 col-sm-3 col-md-3 col-lg-2">
                            <label>Vragen: </label>
                        </div>
                        <div class="col-xs-9 col-sm-9 col-md-9 col-lg-10">
                            <?php
                                foreach ($vragen as $item) {
                                    echo $item["Id"] . ". " . $item["VraagStelling"] . "<br/>";
                                }
                            ?>
                        </div>
                    </div>
                    <div class="row button-row">
                        <div
                            class="col-xs-offset-3 col-sm-offset-3 col-md-offset-3 col-lg-offset-2">
                            <form class="form-horizontal form-buttons" role="form" method="POST"
                                  action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>">
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
                                        onclick="Confirm.render('Verwijder deze vragenlijst?','delete_lft',<?php echo $id ?>,'VragenLijst',this)">
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
                $("#vragenlijstForm").validate({
                    rules: {
                        Titel: "required",
                        Aandoe: "required"
                    },
                    messages: {
                        Titel: "Gelieve dit veld in te vullen!",
                        Aandoe: "Gelieve een keuze te maken!"
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
