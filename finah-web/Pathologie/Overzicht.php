<?php
require "../PHP/DAO/FinahDAO.php";
require_once "../PHP/Models/Pathologie.php";
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>FINAH - Pathologie</title>
    <link rel="stylesheet" type="text/css" href="../Css/stylesheet3.css"/>
    <link rel="stylesheet" type="text/css" href="../Css/bootstrap.css" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
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
        <span class="img-circle"><img src="../Images/blank-avatar.png"/></span><!--TODO  PHP if'ke maken voor als er een avatar/profiel foto beschikbaar is in database of niet ( dan blank-avatar gebruiken) -->
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
    <div  id="page-content-wrapper">
        <div class="breadcrumb">
            <a href="../index.php"><span class="glyphicon glyphicon-home"> </a></span> <span class="breadcrumb-font"> &nbsp/ Home / Pathologie </span>        </div>
        <div  class="container-fluid">
            <div class="row">

                <div class="col-lg-12 col-md-12 col-sm-12">
                    <h1>Overzicht</h1>
                    <form action="CreeerEdit.php" method="post">

                        <button class="btn btn-primary createbtn " type="submit" name="creeer">
                            Maak een nieuwe pathologie aan
                        </button>

                        <table class="table table-bordered table-striped">
                            <thead>
                            <tr>
                            <tr>
                                <th>
                                    Omschrijving
                                </th>
                                <th>Actie</th>
                            </tr>
                            </thead>
                            <tbody>
                            <?php
                            $pathologieLijst = FinahDAO::HaalOp("Pathologie");
                            foreach ($pathologieLijst as $item) {
                                echo "<tr>
                                    <td class='col-sm-10 col-md-10 col-lg-10'>" . $item["Omschrijving"] . "</td>";

                                echo "<td class='action-column col-sm-2 col-md-2 col-lg-2'>
                                    <input type='hidden' name='Id' value=" . $item["Id"] . " />
                                        <button type='submit' name='details' class='btn btn-primary' value=".$item["Id"].">
                                            <span class='glyphicon glyphicon-list-alt'></span>&nbsp;
                                        </button>
                                              <button type='submit' name='bewerk' class='btn btn-primary' value=".$item["Id"].">
                                            <span class='glyphicon glyphicon-pencil'></span>&nbsp;
                                        </button>
                                        <button type='submit'  name='delete' class='btn btn-primary' value=".$item["Id"].">
                                            <span class='glyphicon glyphicon-remove'></span>&nbsp;
                                        </button>
                                    <!-- TODO DeleteButton alert window voor bevestiging (JavaScript modal bootstrap hebben we gezien bij .net) -->
                               </tr>";
                            }
                            ?>
                            </tbody>
                        </table>
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

