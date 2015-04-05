<?php
    require "../PHP/DAO/FinahDAO.php";
    require "../PHP/Models/LeeftijdsCategorie.php";
?>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width"/>
    <title>FINAH - Leeftijdscategorie</title>
    <link rel="stylesheet" type="text/css" href="../Css/Stylesheet.css"/>
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
            <button onclick="location.href='Overzicht.php'">Leeftijdscategorie</button>
            <button onclick="location.href='../Vragen/Overzicht.php'">Vragen</button>
            <button onclick="location.href='../VragenLijst/Overzicht.php'">Vragenlijsten</button>
            <button onclick="location.href='../index.php'">Terug naar home</button>
        </div>
        <!--Closing DIV nav-bar-->
        <div id="body-container">
            <h3 id="Breadcrumb">Menu > Leeftijdscategorie > Aanmaken</h3>

            <h2 id="Content-Title">Nieuwe Leeftijdscategorie</h2>
            <hr/>

            <form method="POST" <?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>>
                <?php
                    if (isset($_POST["creeer"])) {
                    //var_dump($_POST);
                    $van = $_POST["van"];
                    $tot = $_POST["tot"];

                    $leeftijdsCat = new LeeftijdsCategorie();
                    //ID moet op 0 gezet worden, anders een error op de backend
                    $leeftijdsCat->Id = 0;
                    //Todo Validation op de input velden. Enkel positieve getallen tussen 0-120
                    $leeftijdsCat->setVan($van);
                    $leeftijdsCat->setTot($tot);
                    if (FinahDAO::SchrijfWeg("LeeftijdsCategorie", $leeftijdsCat)) {
                        //Todo eventueel een exception toevoegen hier
                        echo "De leeftijdscategorie werd succesvol opgeslagen";
                    }
                    //var_dump($aandoening);

                }else {
                ?>
                <ul class="form-style">
                    <li><label class="control-label">Van:</label></li>
                    <li><input class="form-control-small" type="text" name="van"/></li>
                    <li><label class="control-label">Tot:</label></li>
                    <li><input class="form-control-small" type="text" name="tot"/></li>
                    <li><input type="submit" value="Create" class="createBtn" name="creeer"/></li>
                </ul>
            </form>
            <div class="Back">
                <a href="Overzicht.php">Terug naar overzicht</a>
            </div>
        </div>
        <!--Closing DIV body container-->
    </div>
    <!--Closing DIV innerwrapper-->
    <div id="page-footer">
        <p>&copy; Copyright 2015-2016. All Rights Reserved</p>
    </div>
</div>
<!--Closing DIV wrapper-->
<?php }
?>
</body>
</html>
