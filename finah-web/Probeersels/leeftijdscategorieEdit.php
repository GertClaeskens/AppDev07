<?php
/**
 * Created by PhpStorm.
 * User: Rafaël
 * Date: 27/03/2015
 * Time: 0:28
 */
?>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width" />
    <title>FINAH - Leeftijdscategorie</title>
    <link rel="stylesheet" type="text/css" href="../Css/Stylesheet.css"/>
</head>
<body>
<div id="wrapper">
    <div id="page-header">
        <h1>FINAH</h1>
    </div> <!--Closing DIV page header-->
    <div id="inner-wrapper">
        <div id="nav-bar2">
            <h2> Beheren </h2>
            <button onclick="location.href='../Aandoening/Overzicht.php'">Aandoening</button>
            <button onclick="location.href='../Pathologie/Overzicht.php'">Pathologie</button>
            <button onclick="location.href='../LeeftijdsCategorie/Overzicht.php'">Leeftijdscategorie</button>
            <button onclick="location.href='../Vragen/Overzicht.php'">Vragen</button>
            <button onclick="location.href='../VragenLijst/Overzicht.php'">Vragenlijsten</button>
            <button onclick="location.href='../index.php'">Terug naar home</button>
        </div><!--Closing DIV nav-bar-->
        <div id="body-container">
            <h3 id="Breadcrumb">Menu > Leeftijdscategorie > Bewerken</h3>
            <h2 id="Content-Title">Leeftijdscategorie bewerken</h2>
            <hr/>

            <form method="POST">
                <ul class="form-style">
                    <!--TODO PHP Code voor juiste item op te halen en aanpassingen weg te schrijven-->

                    <li><label class="control-label">Van:</label></li>
                    <li><input class="form-control-small" type="text" name="van"/></li>
                    <li><label class="control-label">Tot:</label></li>
                    <li><input class="form-control-small" type="text" name="tot"/></li>
                    <li><input type="submit" value="Bewerken" class="createBtn" name="bewerk"/></li>
                </ul>
            </form>
            <div class="Back">
                <a href="../LeeftijdsCategorie/Overzicht.php">Terug naar overzicht</a>
            </div>
        </div><!--Closing DIV body containerr-->
    </div><!--Closing DIV innerwrapper-->
    <div id="page-footer">
        <p>&copy; Copyright 2015-2016. All Rights Reserved</p>
    </div>
</div><!--Closing DIV wrapper-->

</body>
</html>
