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
    <title>Finah - Aandoening</title>
    <link rel="stylesheet" type="text/css" href="Stylesheet.css"/>
</head>
<body>
<div id="wrapper">
    <div id="page-header">
        <h1>FINAH</h1>
    </div> <!--Closing DIV page header-->
    <div id="inner-wrapper">
        <div id="nav-bar2">
            <h2> Beheren </h2>
            <button onclick="location.href='aandoeningOverzicht.php'">Aandoening</button>
            <button onclick="location.href='pathologieOverzicht.php'">Pathologie</button>
            <button onclick="location.href='LeeftijdsCategorieOverzicht.php'">Leeftijdscategorie</button>
            <button onclick="location.href='VragenOverzicht.php'">Vragen</button>
            <button onclick="location.href='VragenlijstOverzicht.php'">Vragenlijsten</button>
            <button onclick="location.href='index.php'">Terug naar home</button>
        </div><!--Closing DIV nav-bar-->
        <div id="body-container">
            <h3 id="Breadcrumb">Menu > Aandoening > Bewerken</h3>
            <h2 id="Content-Title">Aandoening bewerken</h2>
            <hr/>

            <form method="POST">
                <ul class="form-style"">
                <li> <label class="control-label" >Kies een pathologie</label> </li>
                <select class="form-control">
                    <option>Pathologie 1</option>
                    <option selected>Pathologie 2</option>
                    <option>Pathologie 3</option>
                    <option>Pathologie 4</option>
                </select>
                <li><label class="control-label">Omschrijving</label></li>
                <li><input class="form-control" value="Voorbeeld omschrijving" type="text"/></li>
                <li><input type="submit" value="Bewerken" class="createBtn" /></li>
                </ul>
            </form>
            <div class="Back">
                <a href="aandoeningOverzicht.php">Terug naar overzicht</a>
            </div>
        </div><!--Closing DIV body containerr-->
    </div><!--Closing DIV innerwrapper-->
    <div id="page-footer">
        <p>&copy; Copyright 2015-2016. All Rights Reserved</p>
    </div>
</div><!--Closing DIV wrapper-->

</body>
</html>
