<?php
    require "../PHP/DAO/FinahDAO.php";
    require "../PHP/Models/Aandoening.php";
?>

    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1"/>
        <title>FINAH - Aandoening</title>
        <link rel="stylesheet" type="text/css" href="../Css/Stylesheet.css"/>
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
            <a class="btn dropdown-toggle pull-left" type="button" id="menu1" data-toggle="dropdown"><?php echo $_SESSION["username"]; ?>
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
                    <a role="menuitem" tabindex="-1" href="../logout.php">                         <span class="glyphicon glyphicon-log-out"></span> &nbsp Uitloggen                     </a>
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
                <a href="Overzicht.php"> Aandoening </a>
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
        <a href="../index.php"><span class="glyphicon glyphicon-home"> </a></span> <span class="breadcrumb-font"> &nbsp/ Home / Aandoening  </span>
    </div>
    <div class="container-fluid">
    <div class="row">
    <div class="col-sm-12 col-md-12 col-lg-12">
    <h1 class="header">Nieuwe aandoening </h1>
<form id="aandoeningForm" class="form-horizontal " role="form" method="POST"
      action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>">
<?php
    if (isset($_POST["creeer"])) {
        //var_dump($_POST);
        $omschrijving = $_POST["omschrijving"];



        //TODO misschien alle objecten van Pathologie ophalen en dan uit die lijst selecteren
        $aandoening = new Aandoening();
        $aandoening->setId(0);
        $aandoening->setOmschrijving($omschrijving);
        //                    $aandoening->setPatologieen($patologielijst);
        if (isset($_POST["pathologie"])) {
            $patologielijst = $_POST["pathologie"];
            for ($a = 0; $a < count($patologielijst); $a++) {
                $aandoening->voegPathologieAanLijstToe(FinahDAO::HaalOp("Pathologie", $patologielijst[$a]));
            };
        }
        //var_dump


        if (FinahDAO::SchrijfWeg("Aandoening", $aandoening)) {
            //Todo eventueel een exception toevoegen hier
            //header("Location: Overzicht.php");
            echo "De aandoening werd succesvol opgeslagen";
        }
        //$aandoening->setPatologieen($patologielijst);
        //var_dump($aandoening);

    } else {
        ?>
                    <div class="form-group top-form">
                        <label class="control-label col-xs-4  col-sm-4 col-md-2 col-lg-2" for="Omschrijving"> Omschrijving: </label>
                        <div class=" col-xs-8 col-sm-8 col-md-8 col-lg-4">
                            <textarea rows="5" type="text" class="form-control" id="omschrijving" name="omschrijving" placeholder="Voer een omschrijving in"> </textarea>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-4 col-sm-4 col-md-2 col-lg-2" for="Pathologie"> Kies een pathologie:  </label>
                        <div class="col-xs-6 col-sm-5 col-md-5 col-lg-3">
                            <select multiple class="form-control" id="pathologie" name="pathologie[]">
                                <!--                        Pathologieen ophalen-->
                                <?php
        //$patologieen = new PathologieArray();
        //TODO omzetten naar Pathologie object
        $patologieen = FinahDAO::HaalOp("Pathologie");
        foreach ($patologieen as $item) {
            $waarde = $item["Omschrijving"];
            echo "<option value='" . $item["Id"] . "'>" . $item["Omschrijving"] . "</option>\r\n";
        }
        //var_dump($patologieen);
        //                        for ($a=0;$a<count($patologieen);$a++){
        //                            echo "<option>" . $patologieen->Omschrijving . "</option>\r\n";
        //                        }
        ?>

                        </select>
                        </div>

                    </div>
                                     <div class="form-group">
                                        <div class=" col-xs-offset-4 col-sm-offset-4 col-md-offset-2 col-lg-offset-2 col-sm-10">
                                           <button onclick="location.href='Overzicht.php'" class="btn btn-primary"> Terug </button>
                                            <button type="submit" name="creeer" class="btn btn-primary"> Opslaan </button>
                                        </div>
                                    </div>
                 </form>
          </div>
        </div>
    </div>
    <script>
        $().ready(function() {
            $("#aandoeningForm").validate({
                rules: {
                    omschrijving: "required"
                },
                messages: {
                    omschrijving: "Veld is verplicht."
                }
            });
        })
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
<?php }
?>