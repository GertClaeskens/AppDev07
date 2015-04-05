<?php

require "../DAO/FinahDAO.php";
require "../Models/Vraag.php";
?>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width"/>
    <title>FINAH - Vragen</title>
    <link rel="stylesheet" type="text/css" href="../Css/Stylesheet.css"/>
</head>
<body>
<div id="wrapper">
    <div id="page-header">
        <h1>FINAH</h1>
    </div>
    <!--Closing DIV page header-->
    <div id="inner-wrapper">
        <div id="nav-bar2">
            <h2> Beheren </h2>
            <button onclick="location.href='../Aandoening/Overzicht.php'">Aandoening</button>
            <button onclick="location.href='../Pathologie/Overzicht.php'">Pathologie</button>
            <button onclick="location.href='../LeeftijdsCategorie/Overzicht.php'">Leeftijdscategorie</button>
            <button onclick="location.href='Overzicht.php'">Vragen</button>
            <button onclick="location.href='../VragenLijst/Overzicht.php'">Vragenlijsten</button>
            <button onclick="location.href='../index.php'">Terug naar home</button>
        </div>
        <!--Closing DIV nav-bar-->
        <div id="body-container">
            <h3 id="Breadcrumb">Menu > Vragen > Aanmaken</h3>

            <h2 id="Content-Title">Nieuwe Vraag</h2>
            <hr/>

            <form method="POST" <?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>>
                <?php
                if (isset($_POST["creeer"])) {
                    $omschrijving = $_POST["vraagstelling"];

                    $vraag = new Vraag();
                    $vraag->Id=0;
                    $vraag->setVraagstelling($vraag);

                    if (FinahDAO::SchrijfWeg("Vraag",$vraag)){
                        //Todo eventueel een exception toevoegen hier
                        echo "De vraag werd succesvol opgeslagen";
                    }

                }else {
                ?>
                <ul class="form-style">
                    <li><label class="control-label">Vraagstelling:</label></li>
                    <li><input class="form-control" type="text" name="vraagstelling"/></li>
                    <!--TODO input velden voor geluid en afbeelding toevoegen ?? -->
                    <li><input type="submit" value="Create" class="createBtn" name="creeer"/></li>
                </ul>
            </form>
            <div class="Back">
                <a href="Overzicht.php">Terug naar overzicht</a>
            </div>
        </div>
        <!--Closing DIV body containerr-->
    </div>
    <!--Closing DIV innerwrapper-->
    <div id="page-footer">
        <p>&copy; Copyright 2015-2016. All Rights Reserved</p>
    </div>
</div>
<!--Closing DIV wrapper-->
<?php }
?>
</body>
</html>
