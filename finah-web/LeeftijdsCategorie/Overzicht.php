<?php
    require_once "../PHP/DAO/FinahDAO.php";
    require_once "../PHP/Models/LeeftijdsCategorie.php";
?>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../Css/Stylesheet.css"/>
    <title>FINAH - Leeftijdscategorie</title>
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
            <button onclick="location.href='Overzicht.php'">Leeftijdscategorie</button>
            <button onclick="location.href='../Vragen/Overzicht.php'">Vragen</button>
            <button onclick="location.href='../VragenLijst/Overzicht.php'">Vragenlijsten</button>
            <button onclick="location.href='../index.php'">Terug naar home</button>

        </div>
        <!--Closing DIV nav-bar-->
        <div id="body-container">
            <h3 id="Breadcrumb">Menu > Leeftijdscategorie</h3>

            <h2 id="Content-Title">Overzicht</h2>

            <p>
                <a href="leeftijdscategoriecreate.php">Create new</a>
            </p>
            <br/>
            <!-- TODO zorgen dat links naar de juiste pagina's linken -->
            <table class="overzicht-table">
                <tr>
                    <th>
                        Van
                    </th>
                    <th>
                        Tot
                    </th>
                    <th>Actie</th>
                </tr>
                <?php
                    $leeftijdCategorieLijst = FinahDAO::HaalOp("LeeftijdsCategorie");
                    foreach ($leeftijdCategorieLijst as $item) {
                        echo "<tr>
                            <td class='leeftijdKolom'>" . $item["Van"] . "</td>
                            <td class='leeftijdKolom'>" . $item["Tot"] . "</td>
                             <td class='action-column'>
                                <input type='submit' value='Edit' class='actieBtn' name='edit'/>
                                <input type='submit' value='Delete' class='actieBtn' name='delete'/>
                                <input type='submit' value='Details' class='actieBtn' name='details'/>
<!--                                <a href='leeftijdscategorieEdit.php'>Edit</a> | <a href='delete.php'>Delete</a> | <a href='leeftijdscategorieDetails.php'>Details</a> -->
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
</head>
</html>