<?php
require "../PHP/DAO/FinahDAO.php";
require "../PHP/Models/Pathologie.php";
require "../PHP/Models/Aandoening.php";

?>

    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1"/>
        <title>FINAH - Pathologie</title>
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
        </ul>
    </div>
    <div id="page-content-wrapper">
    <div class="breadcrumb">
        <a href="../index.php"><span class="glyphicon glyphicon-home"> </a></span> <span class="breadcrumb-font"> &nbsp/ Home / Pathologie  </span>
    </div>
    <div class="container-fluid">
    <div class="row">
    <div class="col-sm-12 col-md-12 col-lg-12">
        <?php
        if (isset($_POST)) {
            if (isset($_POST["bewerk"]) || isset($_POST["update"])) {
            $id = $_POST["bewerk"];
            $pathologie = FinahDAO::HaalOp("Pathologie", $id);
            $naam = $pathologie["Omschrijving"];
                echo "<h1 class='header'>". " Bewerken : " . $naam . "  </h1 >";
            } elseif (isset($_POST["creeer"]) || isset($_POST["nieuw"])) {
                echo "<h1 class='header' >". " Nieuwe pathologie </h2 >";
            }
        }
            //TODO code hierboven nakijken. Op welke pagina komen we uit na een wijziging of update ?  dezelfde bewerk pagina met de gewijzigde gegevens ??
            //TODO De code voor een wijziging op te slaan.
?>
<form id="aandoeningForm" class="form-horizontal " role="form" method="POST"
      action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>">

                    <div class="form-group top-form">
                        <label class="control-label col-xs-4  col-sm-4 col-md-2 col-lg-2" for="Omschrijving"> Omschrijving: </label>
                        <div class=" col-xs-8 col-sm-8 col-md-8 col-lg-4">
                            <textarea rows="5" type="text" class="form-control" id="omschrijving" name="omschrijving" > <?php
                                if (isset($_POST["bewerk"])) {
                                  echo $naam;} ?>
                            </textarea>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-4 col-sm-4 col-md-2 col-lg-2" for="Aandoening">Ken toe aan een aandoening:  </label>
                            <div class="col-xs-7 col-sm-7 col-md-4 col-lg-3">
                            <select multiple class="form-control" id="aandoening" name="aandoeningen[]">
                                <?php
                                    $aandoeningen = FinahDAO::HaalOp("Aandoening");
                                    foreach ($aandoeningen as $item) {

                                        echo "<option value='" .  $item["Id"] . "'>" . $item["Omschrijving"] . "</option>\r\n";
                                    }
                                ?>
                        </select>
                        </div>
                    </div>
                                     <div class="form-group">
                                        <div class=" col-xs-offset-4 col-sm-offset-4 col-md-offset-2 col-lg-offset-2 col-sm-10">
                                           <button onclick="location.href='Overzicht.php'" class="btn btn-primary"> Terug </button>
                                            <button class="btn btn-primary" type="submit" name=<?php if(isset($_POST["bewerk"])){echo "'update'";} elseif (isset($_POST["creeer"])){echo "'nieuw'";}?> > Opslaan </button>
                                        </div>
                                    </div>
                 </form>

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
<?php
?>