<?php
/**
 * Created by PhpStorm.
 * User: Rafaël
 * Date: 6/04/2015
 * Time: 15:24
 */

    include_once 'php/DAO/finahDAo.php';
    session_start();

?>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <title>FINAH - Home</title>
        <link rel="stylesheet" type="text/css" href="Css/Stylesheet.css"/>
        <link rel="stylesheet" type="text/css" href="Css/bootstrap.css" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>
    <?php
          if (isset($_POST["login"])) {
              $aanmelden = FinahDAO::GetToken($_POST["user"], $_POST["wachtwoord"]);
              $resarr = (array)$aanmelden;
              var_dump($resarr);
              if (isset($resarr["access_token"])) {
                      session_start();
                      $_SESSION["token"] = $aanmelden["access_token"];
                      header("Location: Aandoening/Overzicht.php");
                  } else echo "aanmelden mislukt";

        }
    ?>
        <nav class="navbar navbar-default navbar-fixed-top">
            <div class="navbar-header pull-left">

                <a href="#menu-toggle" id="menu-toggle" class="btn-toggle">
                    <span id="side-toggle" class="glyphicon glyphicon-option-horizontal"></span>
                </a>
                <a class="navbar-brand header" href="index.php"> Finah</a>
            </div>
    <!--        <div class="dropdown navbar-header pull-right nav-right">-->
    <!--            <a class="btn dropdown-toggle pull-left" type="button" id="menu1" data-toggle="dropdown">Rafaël.Sarrechia-->
    <!--                <span class="caret"></span>-->
    <!--            </a>-->
    <!--            <ul class="dropdown-menu " role="menu" aria-labelledby="menu1">-->
    <!--                <li role="presentation">-->
    <!--                    <a role="menuitem" tabindex="0" href="../Account/Edit.php">-->
    <!--                        <span class="glyphicon glyphicon-user"></span> &nbsp Mijn account-->
    <!--                    </a>-->
    <!--                </li>-->
    <!--                <li role="presentation" class="divider">-->
    <!--                </li>-->
    <!--                <li role="presentation">-->
    <!--                    <a role="menuitem" tabindex="-1" href="#">-->
    <!--                        <span class="glyphicon glyphicon-log-out"></span> &nbsp Uitloggen-->
    <!--                    </a>-->
    <!--                </li>-->
    <!--            </ul>-->
    <!--        </div>-->
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
                        <a href="#"> Home </a>
                    </li>
<!--                    <li>-->
<!--                        <a href="Bevraging/Overzicht.php"> Bevraging</a>-->
<!--                    </li>-->
<!--                    <br/>-->
<!--                    <li class="sidebar-brand">-->
<!--                            <h4>-->
<!--                                BEHEER-->
<!--                            </h4>-->
<!--                    </li>-->
<!--                    <li>-->
<!--                        <a href="../AccountAanvraag/Overzicht.php">Aanvragen</a>-->
<!--                    </li>-->
<!--                    <li>-->
<!--                        <a href="Aandoening/Overzicht.php"> Aandoening </a>-->
<!--                    </li>-->
<!--                    <li>-->
<!--                        <a href="Pathologie/Overzicht.php"> Pathologie</a>-->
<!--                    </li>-->
<!--                    <li>-->
<!--                        <a href="LeeftijdsCategorie/Overzicht.php"> Leeftijdscategorie</a>-->
<!--                    </li>-->
<!--                    <li>-->
<!--                        <a href="Vragen/Overzicht.php"> Vragen</a>-->
<!--                    </li>-->
<!--                    <li>-->
<!--                        <a href="VragenLijst/Overzicht.php"> Vragenlijsten</a>-->
<!--                    </li>-->
<!--                    <li>-->
<!--                        <a href="../Thema/Overzicht.php"> Thema's</a>-->
<!--                    </li>-->
                </ul>
            </div>
            <div  id="page-content-wrapper">
                <div class="breadcrumb">
                   <span class="glyphicon glyphicon-home"></span> &nbsp / &nbsp <span class="breadcrumb-font">Home </span>
                </div>
                <div  class="container-fluid">
                    <div class="row">

                        <div class="col-lg-12 col-md-12 col-sm-12">
<!--                            <h1 style="margin-bottom:50px;">Welkom</h1>-->
<!--                            <p>-->
<!--                                Quisque sed lorem blandit, pretium odio non, volutpat erat. Nam eros tortor, hendrerit laoreet accumsan ut, commodo sed diam.-->
<!--                                Praesent non sodales quam. Vestibulum ante leo, rutrum nec malesuada eget, accumsan et justo. Duis a orci et dolor tempus-->
<!--                                rutrum at sit amet mauris. Vivamus consectetur libero vel metus iaculis, ut facilisis arcu rhoncus. Morbi ut nulla non sem malesuada pretium.-->
<!---->
<!--                                Quisque sed lorem blandit, pretium odio non, volutpat erat. Nam eros tortor, hendrerit laoreet accumsan ut, commodo sed diam.-->
<!--                                Praesent non sodales quam. Vestibulum ante leo, rutrum nec malesuada eget, accumsan et justo. Duis a orci et dolor tempus-->
<!--                                rutrum at sit amet mauris. Vivamus consectetur libero vel metus iaculis, ut facilisis arcu rhoncus. Morbi ut nulla non sem malesuada pretium.-->
<!--                                <br />-->
<!--                                <br />-->
<!--                            </p>-->
                            <h1 style="margin-bottom:50px;">Login</h1>
                            <form class="form form-horizontal" role="form" method="POST"
                                  action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>">
                                <div class="row">
                                    <div class="col-xs-5 col-sm-5 col-md-4 col-lg-2">
                                        <label for="Email"  class="control-label">
                                            Username:
                                        </label>
                                    </div>
                                    <div class="col-xs-7 col-sm-7 col-md-5 col-lg-3">
                                        <input type="text" name="user" id="user"  class="form-control" value="rafael_sarrechia@hotmail.com">
                                    </div>
                                </div>
                                <div class="row detail-row">
                                    <div class="col-xs-5 col-sm-5 col-md-4 col-lg-2">
                                        <label for="Wachtwoord"  class="control-label">
                                            Wachtwoord:
                                        </label>
                                    </div>
                                    <div class="col-xs-7 col-sm-7 col-md-5 col-lg-3">
                                        <input type="password" name="wachtwoord" id="wachtwoord" class="form-control" value="W@chtwoordPxl">
                                    </div>
                                </div>
                                <div class="row detail-row">
                                    <div class="col-xs-offset-5 col-sm-offset-5 col-md-offset-4 col-lg-offset-2" >
                                        <button type="submit" name="login" class="btn btn-primary form-buttons">
                                            Login
                                        </button>
                                    </div>
                                </div>
                                <div class="row detail-row">
                                    <div class="col-md-offset-4 col-lg-offset-2 col-sm-offset-5 col-xs-offset-5">
                                        <p style="margin-left:15px;">Nog geen account? Registreer je <a href="Account/Registratie.php">hier</a></p>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
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

