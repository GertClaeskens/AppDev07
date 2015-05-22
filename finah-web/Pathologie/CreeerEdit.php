<?php
    require "../PHP/DAO/FinahDAO.php";
    require "../PHP/Models/Pathologie.php";
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
         <title>FINAH - Pathologie</title>
         <link rel="stylesheet" type="text/css" href="../Css/Stylesheet.css"/>
         <link rel="stylesheet" type="text/css" href="../Css/bootstrap.css"/>
         <script src="http://code.jquery.com/jquery-2.1.1.min.js"></script>
         <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
         <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
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
                        <a href="Overzicht.php"> Pathologie</a>
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
                        class="breadcrumb-font"> &nbsp/ Home / Pathologie  </span>
                </div>
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-sm-12 col-md-12 col-lg-12">
                            <div id="mededeling">

                            </div>
                            <?php
                                $naam = "";
                                $pathologie = new Pathologie();
                                if (isset($_POST)) {
                                if (isset($_POST["bewerk"]) || isset($_POST["update"]) || isset($_POST["creeer"]) || isset ($_POST["nieuw"])) {
                                if (isset($_POST["bewerk"])) {
                                    $id = $_POST["bewerk"];
                                    $pathologie = FinahDAO::HaalOp("Pathologie", $id,$_SESSION["token"]);
                                    $naam = $pathologie["Omschrijving"];
                                    echo "<h1 class='header'>" . " Bewerken : " . $naam . "  </h1 >";
                                } elseif (isset($_POST["creeer"]) || isset($_POST["nieuw"])) {
                                    echo "<h1 class='header' >" . " Nieuwe pathologie " . "</h1> ";
                                }
                                if (isset($_POST["nieuw"]) || isset($_POST["update"])) {
                                    $omschrijving = $_POST["omschrijving"];
                                    $pathologie->setOmschrijving($omschrijving);
                                    if (isset($_POST["aandoeningen"])) {
                                        $aandoeningenlijst = $_POST["aandoeningen"];
                                        for ($a = 0; $a < count($aandoeningenlijst); $a++) {
                                            $pathologie->voegAandoeningAanPathologieToe(FinahDAO::HaalOp("Aandoening", $aandoeningenlijst[$a],$_SESSION["token"]));
                                        };
                                    }
                                    if (isset($_POST["nieuw"])) {
                                        $pathologie->setId(0);
                                        if (FinahDAO::SchrijfWeg("Pathologie", $pathologie,$_SESSION["token"])) {
                                            //Todo eventueel een exception toevoegen hier
                                            echo "De pathologie werd succesvol opgeslagen";
                                        }
                                    }
                                    if (isset($_POST["update"])) {
                                        $id = $_POST["update"];

                                        $pathologie->setId($id);
                                        if (FinahDAO::PasAan("Pathologie", $id, $pathologie,$_SESSION["token"])) {

                                        }
                                        $pathologie = FinahDAO::HaalOp("Pathologie", $id,$_SESSION["token"]);
                                        $naam = $pathologie["Omschrijving"];
                                        echo "<h1 class='header'>" . " Bewerken : " . $naam . "  </h1 >";
                                        echo "De pathologie werd succesvol opgeslagen";
                                    }
                                }
                            ?>
                            <form id="pathologieForm" class="form-horizontal" role="form" method="POST"
                                  action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>">

                                <div class="form-group top-form">
                                    <label class="control-label col-xs-4  col-sm-4 col-md-2 col-lg-2" for="Omschrijving">
                                        Omschrijving: </label>

                                    <div class=" col-xs-8 col-sm-8 col-md-8 col-lg-4">
                                        <textarea autofocus="true" rows="5" type="text" class="form-control"
                                                  id="Omschrijving" name="omschrijving"><?php
                                                if (isset($_POST["bewerk"]) || isset($_POST["update"])) {
                                                    echo $naam;
                                                } ?></textarea>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-xs-4 col-sm-4 col-md-2 col-lg-2" for="aandoening">
                                        Aandoening:
                                    </label>

                                    <div class="col-xs-8 col-sm-8 col-md-8 col-lg-4">
                                        <select multiple class="form-control" id="aandoening" name="aandoeningen[]">
                                            <?php
                                                $aandoeningen = FinahDAO::HaalOp("Aandoening",null,$_SESSION["token"]);
                                                foreach ($aandoeningen as $item) {
                                                    $selected = "";
                                                    if (isset($_POST["bewerk"]) || isset($_POST["update"])) {
                                                        foreach ($pathologie["Aandoeningen"] as $ad) {
                                                            if ($item["Id"] == $ad["Id"]) {
                                                                $selected = " selected='selected' ";
                                                                break;
                                                            }

                                                        }
                                                        echo "<option value='" . $item["Id"] . "'" . $selected . ">" . $item["Omschrijving"] . "</option>\r\n";
                                                    } else {
                                                        echo "<option value='" . $item["Id"] .  "'>" . $item["Omschrijving"] . "</option>\r\n";
                                                    }
                                                }
                                            ?>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class=" col-xs-offset-4 col-sm-offset-4 col-md-offset-2 col-lg-offset-2 col-sm-10">
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
            $pathologie = FinahDAO::HaalOp("Pathologie", $id,$_SESSION["token"]);
            $omschrijving = $pathologie["Omschrijving"];
            $aandoeningLijst = $pathologie["Aandoeningen"];
            ?>
            <div class="panel panel-primary">
                <div class="panel-heading ">
                    <h1 class="panel-title"><span
                            class="big-font"> Details: <?php echo "Pathologie " . $id ?> </span></h1>
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
                            <label>Omschrijving:</label>
                        </div>
                        <div class="col-xs-9 col-sm-9 col-md-9 col-lg-10 ">
                            <?php echo $omschrijving ?>
                        </div>
                    </div>
                    <div class="row detail-row">
                        <div class="col-xs-3 col-sm-3 col-md-3 col-lg-2">
                            <label>Aandoening</label>
                        </div>
                        <div class="col-xs-9 col-sm-9 col-md-9 col-lg-10">
                            <?php
                                foreach ($aandoeningLijst as $item) {
                                    echo $item["Id"] . ". " . $item["Omschrijving"] . "<br/>";
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
                                        onclick="Confirm.render('Deze pathologie verwijderen?','delete_lft',<?php echo $id ?>,'Pathologie',this)">
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
                $("#pathologieForm").validate({
                    rules: {
                        omschrijving: "required"
                    },
                    messages: {
                        omschrijving: "Gelieve dit veld in te vullen"
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