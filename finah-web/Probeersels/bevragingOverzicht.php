
<?php
require "../DAO/FinahDAO.php";
require_once "../Models/Bevraging.php";
?>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="Stylesheet.css"/>
    <title>FINAH - Bevraging</title>
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
            <button onclick="location.href='index.php'">Home </button>
            <button onclick="location.href='Account.php'">Mijn account </button>
            <button onclick="location.href='BevragingOverzicht.php'">Bevragingen</button>
            <button onclick="location.href='aandoeningOverzicht.php'">Beheren </button>
            <button onclick="location.href='#'">Uitloggen</button>

        </div>
        <!--Closing DIV nav-bar-->
        <div id="body-container">
            <h3 id="Breadcrumb">Menu > Bevraging</h3>

            <h2 id="Content-Title">Overzicht</h2>

            <p>
                <a href="bevragingCreate.php">Create new</a>
            </p>
            <br/>
<!--            Todo juiste kolommen weergeven-->
            <table class="overzicht-table">
                <tr>
                    <th>
                        Aangevraagd
                    </th>
                    <th>
                        Informatie
                    </th>
                    <th>
                        Relatie
                    </th>
                    <th>Actie</th>
                </tr>
                <tr>
                    <td class="datumkolom">
                        1/04/2015
                    </td>
                    <td class="large-column">
                        Voorbeeld informatie
                    </td>
                    <td>
                        Getrouwd
                    </td>
                    <td class='action-column'>
                        <a href='bevragingEdit.php'>Edit</a> | <a href='delete.php'>Delete</a> | <a href='bevragingDetails.php'>Details</a>
                    </td>
                </tr>
                <tr>
                    <td class="datumkolom">
                        1/04/2015
                    </td>
                    <td class="large-column">
                        Voorbeeld informatie
                    </td>
                    <td>
                        Getrouwd
                    </td>
                    <td class='action-column'>
                        <a href='bevragingEdit.php'>Edit</a> | <a href='delete.php'>Delete</a> | <a href='bevragingDetails.php'>Details</a>
                    </td>
                </tr>
                <tr>
                    <td class="datumkolom">
                        1/04/2015
                    </td>
                    <td class="large-column">
                        Voorbeeld informatie
                    </td>
                    <td>
                        Getrouwd
                    </td>
                    <td class='action-column'>
                        <a href='bevragingEdit.php'>Edit</a> | <a href='delete.php'>Delete</a> | <a href='bevragingDetails.php'>Details</a>
                    </td>
                </tr>
                <tr>
                    <td class="datumkolom">
                        1/04/2015
                    </td>
                    <td class="large-column">
                        Voorbeeld informatie
                    </td>
                    <td>
                        Getrouwd
                    </td>
                    <td class='action-column'>
                        <a href='bevragingEdit.php'>Edit</a> | <a href='delete.php'>Delete</a> | <a href='bevragingDetails.php'>Details</a>
                    </td>
                </tr>
            </table>
<!--                <?php
/*                  //Todo php code voor de bevraging op te halen
                $bevragingLijst = FinahDAO::HaalOp("Bevraging");
                for ($a = 0; $a < count($bevragingLijst); $a++) {
                    $item = $bevragingLijst[$a];
                    $aantal = count($item->Patologieen);
                    for ($b = 0; $b < $aantal; $b++) {
                        echo "<tr> <td> $item->Omschrijving</td>";

                        echo "<td>" . $item->Patologieen[$b]->Omschrijving. "</td>";
                        echo "<td class='action-column'>
                            <a href='bevragingEdit.php'>Edit</a> | <a href='delete.php'>Delete</a> | <a href='bevragingDetails.php'>Details</a>
                        </td></tr>";
                    }
                }
                */?>

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
