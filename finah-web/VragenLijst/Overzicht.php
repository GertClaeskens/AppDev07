<?php
    require "../PHP/DAO/FinahDAO.php";
?>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../Css/Stylesheet.css"/>
    <title>FINAH - Vragenlijst</title>
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
            <button onclick="location.href='Overzicht.php'">Vragenlijsten</button>
            <button onclick="location.href='../index.php'">Terug naar home</button>

        </div>
        <!--Closing DIV nav-bar-->
        <div id="body-container">
            <h3 id="Breadcrumb">Menu > Vragenlijst</h3>

            <h2 id="Content-Title">Overzicht</h2>

            <p>
                <button class="actieBtn" onclick="window.location='Create.php';return false;">
                    Maak een nieuwe vragenlijst aan
                </button>
            </p>
            <br/>
            <table class="overzicht-table">
                <tr>
                    <th>
                        Id
                    </th>
                    <th>
                        Aandoening
                    </th>
                    <th>
                        Aantal vragen
                    </th>
                    <th>Actie</th>
                </tr>
                <?php
                    $vragenLijst = FinahDAO::HaalOp("VragenLijst");
                    foreach ($vragenLijst as $item) {
                        echo "<tr>
                            <td>" . $item["Id"] . "</td>
                            <td> " . $item["Aandoe"]["Omschrijving"] . "</td>
                            <td>" . count($item["Vragen"]) . "</td>
                             <td class='action-column'>
                                <input type='submit' value='Edit' class='actieBtn' name='creeer'/>
                                <input type='submit' value='Delete' class='actieBtn' name='edit'/>
                                <input type='submit' value='Details' class='actieBtn' name='details'/>
                                <!--<a href='vragenlijstEdit.php'>Edit</a> | <a href='delete.php'>Delete</a> | <a href='vragenlijstDetails.php'>Details</a>-->
                         </td>
                         </tr>";
                    } ?>

            </table>
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
s
</html>