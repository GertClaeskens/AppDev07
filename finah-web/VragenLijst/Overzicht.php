<?php
require "../PHP/DAO/FinahDAO.php";
require "../PHP/Models/VragenLijst.php";
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>FINAH - Vragenlijst</title>
    <link rel="stylesheet" type="text/css" href="../Css/Stylesheet.css"/>
    <link rel="stylesheet" type="text/css" href="../Css/bootstrap.css" />
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
        <a class="navbar-brand header" href="#"> Finah</a>
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
    <div  id="page-content-wrapper">
        <div class="breadcrumb">
            <a href="../index.php"><span class="glyphicon glyphicon-home"> </a></span> <span class="breadcrumb-font"> &nbsp/ Home / Vragenlijst </span>        </div>
        <div  class="container-fluid">
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12">
                    <h1>Overzicht</h1>
                    <form action="CreeerEdit.php" method="post">
                        <button class="btn btn-primary createbtn " type="submit" name="creeer">
                            Maak een nieuwe vragenlijst aan
                        </button>
                        <?php
                        if (isset($_POST["delete"])) {
                            $id = $_POST["delete"];
                            $vragenlijst = FinahDAO::HaalOp("VragenLijst", $id);
                            if (FinahDAO::Verwijder("VragenLijst", $id, $vragenlijst)) {
                                echo " De vragenlijst werd succesvol verwijderd "; }
                        }
                        ?>
                        <table class="table table-bordered table-striped">
                            <thead>
                            <tr>
                                <th>
                                    Id
                                </th>
                                <th>
                                    Omschrijving
                                </th>
                                <th>
                                    Aandoening
                                </th>
                                <th>
                                    Aantal vragen
                                </th>
                                <th>Actie</th>
                            </tr>
                            </thead>
                            <tbody>
                                <?php
                                $vragenLijst = FinahDAO::HaalOp("VragenLijst");
                                foreach ($vragenLijst as $item) {
                                    echo "<tr>"?>
                                       <td class='col-sm-1 col-md-1 col-lg-1 text-center'><?php echo $item["Id"]?></td>
                                        <td class='col-sm-6 col-md-6 col-lg-6'> <?php echo $item["Omschrijving"]?></td>
                                       <td class='col-sm-6 col-md-6 col-lg-6'> <?php echo $item["Aandoe"]["Omschrijving"]?></td>
                                       <td class='col-sm-3 col-md-3 col-lg-3 text-center'><?php echo count($item["Vragen"])?></td>
                                       <td class='action-column col-sm-2 col-md-2 col-lg-2'>
                                            <button type='submit' name='details' id='<?php echo "Dt".$item["Id"] ?>'
                                                    class='btn btn-primary' value="<?php echo $item["Id"] ?>">
                                                    <span class='glyphicon glyphicon-list-alt'></span>&nbsp;
                                            </button>
                                            <button type='submit' name='bewerk' id='<?php echo "Bw". $item["Id"] ?>'
                                                    class='btn btn-primary' value="<?php echo $item["Id"] ?>">
                                                    <span class='glyphicon glyphicon-pencil'></span>&nbsp;
                                            </button>
                                                <?php $verw = $item["Id"]; ?>
                                            <button type='button' title='Verwijderen' id='<?php echo "Del". $item["Id"] ?>'
                                                    name='verwijderBtn' value="<?php echo $item["Id"] ?>"
                                                    class='delBtn btn btn-primary'
                                                    onclick="Confirm.render('Verwijder vragenlijst <?php echo $verw; ?>?','delete_lft',<?php echo $verw; ?>,'VragenLijst',this)">
                                                <span class='glyphicon glyphicon-remove'></span>&nbsp;
                                            </button>
                                         </td>
                                    </tr>
                                <?php } ?>
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
<
</body>
</html>

