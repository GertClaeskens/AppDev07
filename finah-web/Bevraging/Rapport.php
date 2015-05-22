<?php
    require "../PHP/DAO/FinahDAO.php";
    require_once "../PHP/Models/Bevraging.php";
    require_once "../PHP/Models/Onderzoek.php";

    session_start();
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>FINAH - Bevraging</title>
    <link rel="stylesheet" type="text/css" href="../Css/Stylesheet.css"/>
    <link rel="stylesheet" type="text/css" href="../Css/bootstrap.css"/>
    <script src="../js/finah.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
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
        <a class="btn dropdown-toggle pull-left" type="button" id="menu1"
           data-toggle="dropdown"><?php echo $_SESSION["username"]; ?>
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
                <a role="menuitem" tabindex="-1" href="../logout.php"> <span class="glyphicon glyphicon-log-out"></span>
                    &nbsp Uitloggen </a>
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
                <a href="Overzicht.php"> Bevraging</a>
            </li>
            <br/>
            <?php if (isset($_SESSION) && $_SESSION["rol"] != "Hulpverlener") { ?>
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
            <?php } ?>
        </ul>
    </div>
    <div id="page-content-wrapper">
        <div class="breadcrumb">
            <a href="../index.php"><span class="glyphicon glyphicon-home"> </a></span> <span class="breadcrumb-font"> &nbsp/ Home / Bevraging </span>
        </div>
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12">
                    <h1>Rapport</h1>
                    <?php
                        if (isset($_GET)) {
                            //$rapportid = "4cb31482bfe143f0a90e408e86d8432c";
                            $rapportid = $_GET["id"];

                            $onderzoek = FinahDAO::HaalOp("Onderzoek/Rapport", $rapportid);
                            $idMan = $onderzoek[0]["Bevraging_Man"]["Id"];
                            $idPat = $onderzoek[0]["Bevraging_Pat"]["Id"];
                            //$idMan = "2a0aa4c1264f401081e6db09d9a092f6";
                            //$idPat = "6fe059997e0643af91688084e2648c55";
                            $bevrPat = FinahDAO::HaalOp("Bevraging", $idPat);
                            $bevrMan = FinahDAO::HaalOp("Bevraging", $idMan);
                            $reeks1 = $bevrPat["Antwoorden"];
                            $reeks2 = $bevrMan["Antwoorden"];
                            $arr1 = explode(",", $reeks1);
                            $arr2 = explode(",", $reeks2);
                            $vragen = FinahDAO::HaalOp("Onderzoek", $idPat . "/Vragen");
                            $rapport = [];
                            $nogene = [];
                            $teller = 0;
                            for ($i = 0; $i < count($vragen[0]); $i++) {
                                $vraag = $vragen[0][$i];
                                $vrRap["hinderPat"] = 0;
                                $vrRap["hinderMan"] = 0;
                                $vrRap["hulp"] = 0;

                                if ($arr1[$i] > 5 || $arr2[$i] > 5) { //er is hinder
                                    //vraag al bewaren
                                    $vrRap["Vraag"] = $vraag["VraagStelling"];
                                    $vrRap["hinderPat"] = 0;
                                    $vrRap["hinderMan"] = 0;
                                    $vrRap["hulp"] = 0;

                                    if ($arr1[$i] == 6) { //hinder voor de patient hulp
                                        $vrRap["hinderPat"] = 1;
                                        $vrRap["hulp"] = 1;
                                    }
                                    if ($arr1[$i] == 7) { //hinder voor de patient hulp
                                        $vrRap["hinderMan"] = 1;
                                        $vrRap["hulp"] = 1;
                                    }
                                    if ($arr1[$i] == 8) { //hinder voor de patient hulp
                                        $vrRap["hinderPat"] = 1;
                                        $vrRap["hinderMan"] = 1;
                                        $vrRap["hulp"] = 1;
                                    }
                                    if ($arr2[$i] == 6) { //hinder voor de patient hulp
                                        $vrRap["hinderPat"] += 2;
                                        $vrRap["hulp"] += 2;
                                    }
                                    if ($arr2[$i] == 7) { //hinder voor de patient hulp
                                        $vrRap["hinderMan"] += 2;
                                        $vrRap["hulp"] += 2;
                                    }
                                    if ($arr2[$i] == 8) { //hinder voor de patient hulp
                                        $vrRap["hinderPat"] += 2;
                                        $vrRap["hinderMan"] += 2;
                                        $vrRap["hulp"] += 2;
                                    }

                                    $rapport[$vraag["Thema"]["Naam"]][$teller] = $vrRap;
                                    $teller++;
                                }

                            }
                            ?>
                            <table class="table">
                                <tr style="background-color:#337ab7">
                                    <th>Vraag</th>
                                    <th colspan="2">Hinder voor Patient</th>
                                    <th colspan="2">Hinder voor Mantelzorger</th>
                                    <th>Hulpvraag</th>
                                </tr>
                                <tr>
                                    <th></th>
                                    <th>Patient</th>
                                    <th>Mantelzorger</th>
                                    <th>Patient</th>
                                    <th>Mantelzorger</th>
                                    <th>Gesteld door</th>
                                </tr
                                <?php
                                    $i = 0;
                                    foreach (array_keys($rapport) as $key) {
                                        ?>
                                        <tr>
                                            <td><b><?php echo $key ?> </b></td>

                                            <td colspan="5"></td>
                                        </tr>
                                        <?php
                                        for ($j = 0; $j < count($rapport[$key]); $j++) {
                                            echo "<tr><td>" . $rapport[$key][$i]["Vraag"] . "</td>";
                                            switch ($rapport[$key][$i]["hinderPat"]) {
                                                case 0:
                                                    echo "<td></td><td></td>";
                                                    break;
                                                case 1:
                                                    echo "<td class='trueColumn'>X</td><td></td>";
                                                    break;
                                                case 2:
                                                    echo "<td></td><td class='trueColumn'>X</td>";
                                                    break;

                                                case 3:
                                                    echo "<td class='trueColumn'>X</td><td class='trueColumn'>X</td>";
                                                    break;
                                            }
                                            switch ($rapport[$key][$i]["hinderMan"]) {
                                                case 0:
                                                    echo "<td ></td><td ></td>";
                                                    break;
                                                case 1:
                                                    echo "<td class='trueColumn'>X</td><td></td>";
                                                    break;
                                                case 2:
                                                    echo "<td></td><td class='trueColumn'>X</td>";
                                                    break;

                                                case 3:
                                                    echo "<td class='trueColumn'>X</td><td class='trueColumn'>X</td>";
                                                    break;
                                            }
                                            switch ($rapport[$key][$i]["hulp"]) {
                                                case 1:
                                                    echo "<td class='text-center'>Patient</td>";
                                                    break;
                                                case 2:
                                                    echo "<td class='text-center'>Mantelzorger</td>";
                                                    break;

                                                case 3:
                                                    echo "<td class='text-center'>Beiden</td>";
                                                    break;
                                            }
                                            echo "</tr>";
                                            $i++;
                                        }
                                    }
                                ?>
                            </table>
                        <?php } ?>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
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

