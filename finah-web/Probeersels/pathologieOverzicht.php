<?php
require "../DAO/FinahDAO.php";
?>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="Stylesheet.css"/>
<body>
<div id="wrapper">
    <div id="page-header">
        <h1>FINAH</h1>
    </div> <!--Closing DIV page header-->
    <div id="inner-wrapper">
        <div id="nav-bar2">
            <h2> Beheren </h2>
            <button onclick="location.href='aandoeningOverzicht.php'">Aandoening </button>
            <button onclick="location.href='pathologieOverzicht.php'">Pathologie </button>
            <button onclick="location.href='leeftijdscategorieOverzicht.php'">Leeftijdscategorie </button>
            <button onclick="location.href='VragenOverzicht.php'">Vragen </button>
            <button onclick="location.href='VragenlijstOverzicht.php'">Vragenlijsten</button>
            <button onclick="location.href='index.php'">Terug naar home </button>

        </div><!--Closing DIV nav-bar-->
        <div id="body-container">
            <h3 id="Breadcrumb">Menu > Pathologie</h3>
            <h2 id="Content-Title">Overzicht</h2>
            <p>
                <a href="pathologieCreate.php">Create new</a>
            </p>
            <br />
            <table border="1" class="overzicht-table">
                <tr>
                    <th>
                        Omschrijving
                    </th>
                    <th >Actie</th>
                </tr>
                <?php
                $pathologieLijst = FinahDAO::HaalOp("Pathologie");
                foreach($pathologieLijst as $item)
                {echo "<tr>
                            <td> $item->Omschrijving</td>
                             <td class='action-column'>
                                <a href='pathologieEdit.php'>Edit</a> | <a href='delete.php'>Delete</a> | <a href='Pathologiedetails.php'>Details</a>
                         </td>
                         </tr>";} ?>
            </table>
        </div><!--Closing DIV body containerr-->
    </div><!--Closing DIV innerwrapper-->
    <div id="page-footer">
        <p>&copy; Copyright 2015-2016. All Rights Reserved</p>
    </div>
</div><!--Closing DIV wrapper-->
</body>
</head>
</html>