<?php
require_once "../DAO/FinahDAO.php";
require_once "../Models/LeeftijdsCategorie.php";
?>
<html>
<head>
    <title>FINAH - Leeftijdscategorie</title>
    <link rel="stylesheet" type="text/css" href="Stylesheet.css"/>
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
            <button onclick="location.href='pathologieOverzicht.php'">Pathologie</button>
            <button onclick="location.href='LeeftijdsCategorieOverzicht.php'">Leeftijdscategorie</button>
            <button onclick="location.href='VragenOverzicht.php'">Vragen</button>
            <button onclick="location.href='VragenlijstOverzicht.php'">Vragenlijsten</button>
            <button onclick="location.href='index.php'">Terug naar home</button>

        </div>
        <!--Closing DIV nav-bar-->
        <div id="body-container">
            <h3 id="Breadcrumb">Menu > Leeftijdscategorie > Details</h3>

            <h2 id="Content-Title">Details</h2>

            <br/>
            <table border="1" class="overzicht-table">
                <tr>
                    <th>
                        Van
                    </th>
                    <th>
                        Tot
                    </th>
                    <th>Actie</th>
                </tr>
                <!--                TODO PHP code om het juiste item op te halen -->

                <tr>
                            <td class="leeftijdKolom"> 0</td>
                            <td class="leeftijdKolom"> 10</td>
                             <td class="action-column-small">
                                <a href='leeftijdscategorieEdit.php'>Edit</a> | <a href='delete.php'>Delete</a>
                         </td>
               </tr>
            </table>
            <div class="Back">
                <a href="leeftijdscategorieOverzicht.php">Terug naar overzicht</a>
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
</body>
</head>
</html>