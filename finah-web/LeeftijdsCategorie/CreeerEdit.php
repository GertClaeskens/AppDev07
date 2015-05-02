<?php
    require "../PHP/DAO/FinahDAO.php";
    require "../PHP/Models/LeeftijdsCategorie.php";
?>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1"/>
        <title>FINAH - Leeftijdscategorie</title>
        <link rel="stylesheet" type="text/css" href="../Css/stylesheet3.css"/>
        <link rel="stylesheet" type="text/css" href="../Css/bootstrap.css"/>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
        <script src="http://code.jquery.com/jquery-2.1.1.min.js"></script>
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
                <a href="../index.php"><span class="glyphicon glyphicon-home"> </a></span>
                <span
                    class="breadcrumb-font"> &nbsp/ Home / Leeftijdscategorie
                </span>
            </div>
            <div class="container-fluid">
                <div class="row">
                    <div class="col-sm-12 col-md-12 col-lg-12">
                        <?php

                            $LeeftijdsCat = new LeeftijdsCategorie();
                            if (isset($_POST)) {
                                if (isset($_POST["bewerk"])) {
                                    $id = $_POST["bewerk"];

                                    $LeeftijdsCat = FinahDAO::HaalOp("LeeftijdsCategorie", $id);
                                    $van = $LeeftijdsCat["Van"];
                                    $tot = $LeeftijdsCat["Tot"];
                                    echo "<h1 class='header'>" . " Bewerken : Van " . $van . " Tot " . $tot . "</h1 >";
                                } elseif (isset($_POST["creeer"]) || isset($_POST["nieuw"])) {
                                    echo "<h1 class='header' >" . " Nieuwe leeftijdscategorie " . "</h1> ";
                                }
//
                                if (isset($_POST["nieuw"]) || isset($_POST["update"])) {
                                    $van = $_POST["van"];
                                    $tot = $_POST["tot"];
                                    $LeeftijdsCat->setVan($van);
                                    $LeeftijdsCat->setTot($tot);

                                    if (isset($_POST["nieuw"])) {
                                        if (FinahDAO::SchrijfWeg("LeeftijdsCategorie", $LeeftijdsCat)) {
                                            //Todo eventueel een exception toevoegen hier
                                            echo "De leeftijdscategorie werd succesvol opgeslagen";
                                        }
                                    }
                                    if (isset($_POST["update"])) {
                                        $id = $_POST["update"];

                                        $LeeftijdsCat->setId($id);
                                        if (FinahDAO::PasAan("LeeftijdsCategorie", $id, $LeeftijdsCat)) {
                                            $LeeftijdsCat = FinahDAO::HaalOp("LeeftijdsCategorie", $id);
                                            $van = $LeeftijdsCat["Van"];
                                            $tot = $LeeftijdsCat["Tot"];
                                            echo "<h1 class='header'>" . " Bewerken : Van " . $van . " Tot " . $tot . "</h1 >";
                                            echo "De leeftijdscategorie werd succesvol opgeslagen";
                                        }

                                    }
                                }
                            }

                        ?>
                        <form id="aandoeningForm" class="form-horizontal" role="form" method="POST"
                              action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>">
                            <div class="form-group top-form">
                                <label class="control-label col-xs-2 col-sm-2 col-md-2 col-lg-2" for="Van"> Van: </label>
                                <div class="col-xs-3 col-sm-2 col-md-2 col-lg-1">
                                    <input type="text" name="van" class="form-control" id="Van" value=
                                    <?php
                                    if (isset($_POST["bewerk"]) || isset($_POST["update"])) {
                                        echo $van;
                                    } ?>>

                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-xs-2 col-sm-2 col-md-2 col-lg-2" for="Tot"> Tot:  </label>
                                <div class="col-xs-3 col-sm-2 col-md-2 col-lg-1">
                                    <input type="text" name="tot" class="form-control" id="Tot" value=
                                        <?php
                                        if (isset($_POST["bewerk"]) || isset($_POST["update"])) {
                                            echo $tot;
                                        } ?> >
                                </div>
                            </div>
                            <div class="form-group">
                                <div class=" col-xs-offset-4 col-sm-offset-4 col-md-offset-2 col-lg-offset-2 col-sm-10">
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
                                    Van: "required"
                                },
                                messages: {
                                    Tot: "Veld is verplicht."
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