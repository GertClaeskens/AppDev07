<?php
    require "../PHP/DAO/FinahDAO.php";
    require_once "../PHP/Models/Pathologie.php";
?>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../Css/Stylesheet.css"/>
    <title>FINAH - Pathologie</title>
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
            <button onclick="location.href='../Vragen/Overzicht.php'">Vragen</button>
            <button onclick="location.href='../VragenLijst/Overzicht.php'">Vragenlijsten</button>
            <button onclick="location.href='../index.php'">Terug naar home</button>

        </div>
        <!--Closing DIV nav-bar-->
        <div id="body-container">
            <h3 id="Breadcrumb">Menu > Pathologie > Details </h3>

            <h2 id="Content-Title">Details</h2>

            <br/>
            <table border="1" class="overzicht-table">
                <tr>
                    <th>
                        Omschrijving
                    </th>
                    <th>Actie</th>
                </tr>
                <!--                TODO PHP code om het juiste item op te halen -->

                <tr>
                    <td>
                        Voorbeeld omschrijving
                    </td>
                    <td class='action-column-small'>
                        <a href='pathologieEdit.php'>Edit</a> | <a href='delete.php'>Delete</a>
                    </td>
                </tr>

            </table>
            <div class="Back">
                <a href="../Pathologie/Overzicht.php">Terug naar overzicht</a>
            </div>
        </div>
        <!--Closing DIV innerwrapper-->
        <div id="page-footer">
            <p>&copy; Copyright 2015-2016. All Rights Reserved</p>
        </div>
    </div>
    <!--Closing DIV wrapper-->
</body>
</html>