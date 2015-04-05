<?php
    require "../PHP/DAO/FinahDAO.php";
    require_once "../PHP/Models/Aandoening.php";
    require_once "../PHP/Models/Pathologie.php";
?>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../Css/Stylesheet.css"/>
    <title>FINAH - Aandoening</title>
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
            <button onclick="location.href='Overzicht.php'">Aandoening</button>
            <button onclick="location.href='../Pathologie/Overzicht.php'">Pathologie</button>
            <button onclick="location.href='../LeeftijdsCategorie/Overzicht.php'">Leeftijdscategorie</button>
            <button onclick="location.href='../Vragen/Overzicht.php'">Vragen</button>
            <button onclick="location.href='../VragenLijst/Overzicht.php'">Vragenlijsten</button>
            <button onclick="location.href='../index.php'">Terug naar home</button>

        </div>
        <!--Closing DIV nav-bar-->
        <div id="body-container">
            <h3 id="Breadcrumb">Menu > Aandoening</h3>

            <h2 id="Content-Title">Overzicht</h2>

            <p>
                <button class="actieBtn" onclick="window.location='Create.php';return false;">
                    Maak een nieuwe aandoening
                </button>
<!--                <a href="Create.php">Create new</a>-->
            </p>
            <br/>

            <form action="EditDetails.php" method="post">
                <table class="overzicht-table">
                    <tr>
                        <th>
                            Omschrijving
                        </th>
                        <th>
                            Pathologie
                        </th>
                        <th>Actie</th>
                    </tr>
                    <?php
                        $aandoeningLijst = FinahDAO::HaalOp("Aandoening");
                        for ($a = 0; $a < count($aandoeningLijst); $a++) {
                            $item = $aandoeningLijst[$a];
                            $aantal = count($item["Patologieen"]);
                            for ($b = 0; $b < $aantal; $b++) {
                                echo "<tr> <td>" . $item["Omschrijving"] . "</td>";

                                echo "<td>" . $item["Patologieen"][$b]["Omschrijving"] . "</td>";
                                echo "<td class='action-column'>
                                <input type='hidden' name='Id' value=". $item["Id"] ." />
                                <input type='submit' value='Edit' class='actieBtn' name='bewerk'/>
                                <!-- TODO DeleteButton alert window voor bevestiging (JavaScript?) -->
                                <input type='submit' value='Delete' class='actieBtn' name='delete'/>
                                <input type='submit' value='Details' class='actieBtn' name='details'/>
                           </tr>";
                            }
                            //<a href='aandoeningEdit.php'>Edit</a> | <a href='delete.php'>Delete</a> | <a href='aandoeningDetails.php'>Details</a>
                        } ?>

                </table>
            </form>
        </div>
        <!--Closing DIV innerwrapper-->
        <!--Closing DIV Content-->
    </div>  <!--Closing DIV innerwrapper-->
        <div id="page-footer">
            <p>&copy; Copyright 2015-2016. All Rights Reserved</p>
        </div>
    </div>
    <!--Closing DIV wrapper-->
</body>
</html>