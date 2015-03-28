<?php
require "../DAO/FinahDAO.php";
require_once "../Models/Aandoening.php";
require_once "../Models/Pathologie.php";
?>
<html>
<head>
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
            <h3 id="Breadcrumb">Menu > Aandoening</h3>

            <h2 id="Content-Title">Details</h2>

            <p>
                <a href="aandoeningCreate.php">Create new</a>
            </p>
            <br/>
            <table border="1" class="overzicht-table">
                <tr>
                    <th>
                        Omschrijving
                    </th>
                    <th>
                        Pathologie
                    </th>
                    <th>Actie</th>
                </tr>
                <tr>
                    <td>
                        Voorbeeld omschrijving
                    </td>
                    <td class="medium-column">
                        Pathologie 1
                    </td>
                    <td class='action-column-small'>
                        <a href='aandoeningEdit.php'>Edit</a> | <a href='delete.php'>Delete</a>
                    </td>
                </tr>

            </table>
        </div>
        <!--Closing DIV innerwrapper-->
        <div id="page-footer">
            <p>&copy; Copyright 2015-2016. All Rights Reserved</p>
        </div>
    </div>
    <!--Closing DIV wrapper-->
</body>
</html>