<?php
require "../PHP/DAO/FinahDAO.php";
require "../PHP/Models/VragenLijst.php";
require "../PHP/Models/Aandoening.php";
?>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <title>FINAH - Vragenlijst</title>
        <link rel="stylesheet" type="text/css" href="../Css/stylesheet3.css"/>
        <link rel="stylesheet" type="text/css" href="../Css/bootstrap.css" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min   .js"></script>
        <![endif]-->
    </head>
    <body>
    <nav  class="navbar navbar-default navbar-fixed-top">
        <div  class="navbar-header pull-left">

            <a href="#menu-toggle"  id="menu-toggle" class="btn-toggle">
                <span id="side-toggle" class="glyphicon glyphicon-option-horizontal"></span>
            </a>
            <a  class="navbar-brand header"  href="#"> Finah</a>
        </div>
        <div class="dropdown navbar-header pull-right nav-right">
            <span class="img-circle"><img src="../Images/blank-avatar.png"/></span>  <!--TODO  PHP if'ke maken voor als er een avatar/profiel foto beschikbaar is in database of niet ( dan blank-avatar gebruiken) -->
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
                <li >
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
                    <a href="Overzicht.php"> Vragenlijsten</a>
                </li>
            </ul>
        </div>
        <div  id="page-content-wrapper">
            <div class="breadcrumb">
                <a href="../index.php"><span class="glyphicon glyphicon-home"> </a></span> <span class="breadcrumb-font"> &nbsp/ Home / Vragenlijst  </span>
            </div>
            <div  class="container-fluid">
                <div class="row">
                    <div class="col-sm-12 col-md-12 col-lg-12">
                        <h1 class="header">Nieuwe vragenlijst </h1>
                        <form class="form-horizontal " role="form" method="POST" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>">
                            <!--                --><?php
                            // TODO Code schrijven voor vragenlijst weg te schrijven.
                            /*              if (isset($_POST["creeer"])) {
                                                $omschrijving = $_POST["vraagstelling"];

                                                $vraag = new Vraag();
                                                $vraag->Id=0;
                                                $vraag->setVraagstelling($vraag);

                                                if (FinahDAO::SchrijfWeg("Vraag",$vraag)){
                                                    //Todo eventueel een exception toevoegen hier
                                                    echo "De vraag werd succesvol opgeslagen";
                                                }

                                            }else {
                                            */ ?>
                            <div class="form-group top-form">
                                <label class="control-label col-xs-4 col-sm-4 col-md-3 col-lg-3" for="Aandoening"> Selecteer de gepaste aandoening: </label>
                                <div class="col-xs-8 col-sm-8 col-md-6 col-lg-4">
                                    <select name="aandoening" class="form-control"  id="Aandoening" >
                                        <?php
                                        //$patologieen = new PathologieArray();
                                        //TODO omzetten naar Pathologie object
                                        $patologieen = FinahDAO::HaalOp("Pathologie");
                                        foreach ($patologieen as $item) {
                                            $waarde = $item["Omschrijving"];
                                            echo "<option value='" . $item["Id"] . "'>" . $item["Omschrijving"] . "</option>\r\n";
                                        }
                                        ?>
                                        }
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-xs-4 col-sm-4 col-md-3 col-lg-3" for="vragenAdd"> Selecteer de vragen die je wil toevoegen aan de vragenlijst: </label>

                                <div class="col-xs-8 col-sm-8 col-md-9 col-lg-9">
                                    <select  id="vragenAdd" size="20" multiple >
                                        <?php
                                        /*TODO De vragen in deze select box zoals de pathologie lijst (code hieronder)Eventueel enkel de vragen die van toepassing zijn bij de bovenstaand geselecteerde aandoening?? */
                                            $vragenLijst = FinahDAO::HaalOp("Vragen");
                                            foreach ($vragenLijst as $item) {
                                                echo "<option value='" . $item["Id"] . "'>" . $item["Vraagstelling"] . "</option>\r\n";
                                            }
                                        ?>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class=" col-xs-offset-4 col-sm-offset-4 col-md-offset-3 col-lg-offset-3 col-sm-10">
                                    <button onclick="location.href='Overzicht.php'" class="btn btn-primary"> Terug </button>
                                    <button type="submit" name="creeer" class="btn btn-primary"> Opslaan </button>
                                </div>
                            </div>
                        </form>

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
<?php
?>