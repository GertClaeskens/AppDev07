<?php

require "../DAO/FinahDAO.php";
require "../Models/Pathologie.php";
?>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width"/>
    <title>Finah - Pathologie</title>
    <link rel="stylesheet" type="text/css" href="Stylesheet.css"/>
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
            <button onclick="location.href='aandoeningOverzicht.php'">Aandoening</button>
            <button onclick="location.href='PathologieOverzicht.php'">Pathologie</button>
            <button onclick="location.href='LeeftijdsCategorieOverzicht.php'">Leeftijdscategorie</button>
            <button onclick="location.href='VragenOverzicht.php'">Vragen</button>
            <button onclick="location.href='VragenlijstOverzicht.php'">Vragenlijsten</button>
            <button onclick="location.href='index.php'">Terug naar home</button>
        </div>
        <!--Closing DIV nav-bar-->
        <div id="body-container">
            <h3 id="Breadcrumb">Menu > Pathologie > Aanmaken</h3>

            <h2 id="Content-Title">Nieuwe pathologie</h2>
            <hr/>

            <form method="POST" <?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>>
                <?php
                if (isset($_POST["creeer"])) {
                    //var_dump($_POST);
                    $omschrijving = $_POST["omschrijving"];
//TODO misschien alle objecten van Pathologie ophalen en dan uit die lijst selecteren
                    $pathologie = new Pathologie();
                    $pathologie->Id=0;
                    $pathologie->setOmschrijving($omschrijving);

                    if (FinahDAO::SchrijfWeg("Pathologie",$pathologie)){
                        //Todo eventueel een exception toevoegen hier
                        echo "De pathologie werd succesvol opgeslagen";
                    }

                }else {
                ?>
                <ul class="form-style">
                    <li><label class="control-label">Omschrijving</label></li>
                    <li><input class="form-control" type="text" name="omschrijving"/></li>

                    </select>

                    <li><input type="submit" value="Create" class="createBtn" name="creeer"/></li>
                </ul>
            </form>
            <div class="Back">
                <a href="PathologieOverzicht.php">Terug naar overzicht</a>
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
