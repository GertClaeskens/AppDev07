<?php
    require "../PHP/DAO/FinahDAO.php";
?>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../Css/Stylesheet.css"/>
    <title>FINAH - Pathologie</title>
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
            <button onclick="location.href='Overzicht.php'">Pathologie</button>
            <button onclick="location.href='../LeeftijdsCategorie/Overzicht.php'">Leeftijdscategorie</button>
            <button onclick="location.href='../Vragen/Overzicht.php'">Vragen</button>
            <button onclick="location.href='../VragenLijst/Overzicht.php'">Vragenlijsten</button>
            <button onclick="location.href='../index.php'">Terug naar home</button>

        </div>
        <!--Closing DIV nav-bar-->
        <div id="body-container">
            <h3 id="Breadcrumb">Menu > Pathologie</h3>

            <h2 id="Content-Title">Overzicht</h2>

            <p>
                <button class="actieBtn" onclick="window.location='Create.php';return false;">
                    Maak een nieuwe pathologie aan
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
                        <th>Actie</th>
                    </tr>
                    <?php
                        $pathologieLijst = FinahDAO::HaalOp("Pathologie");
                        foreach ($pathologieLijst as $item) {
                            echo "<tr>
                            <td>" . $item["Omschrijving"] . "</td>
                             <td class='action-column'>
                             <input type='hidden' name='Id' value=" . $item["Id"] . " />
                                <input type='submit' value='Edit' class='actieBtn' name='bewerk'/>
                                <input type='submit' value='Delete' class='actieBtn' name='delete'/>
                                <input type='submit' value='Details' class='actieBtn' name='details'/>
<!--                                <a href='pathologieEdit.php'>Edit</a> | <a href='delete.php'>Delete</a> | <a href='Pathologiedetails.php'>Details</a> -->
                         </td>
                         </tr>";
                        } ?>
                </table>
            </form>
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