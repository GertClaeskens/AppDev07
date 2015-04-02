<?php
/**
 * Created by PhpStorm.
 * User: Rafaël
 * Date: 27/03/2015
 * Time: 0:28
 */
require "../DAO/FinahDAO.php";
require "../Models/Bevraging.php";
?>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width"/>
    <title>FINAH - Bevraging</title>
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
            <div id="nav-bar2">
                <h2> Menu </h2>
                <button onclick="location.href='index.php'">Home </button>
                <button onclick="location.href='Account.php'">Mijn account </button>
                <button onclick="location.href='BevragingOverzicht.php'">Bevragingen</button>
                <button onclick="location.href='aandoeningOverzicht.php'">Beheren </button>
                <button onclick="location.href='#'">Uitloggen</button>

            </div>
        </div>
        <!--Closing DIV nav-bar-->
        <div id="body-container">
            <h3 id="Breadcrumb">Menu > Bevraging > Aanmaken</h3>

            <h2 id="Content-Title">Nieuwe bevraging</h2>
            <hr/>

            <form method="POST" <?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>>
                <?php
                if (isset($_POST["creeer"])) {
                    //var_dump($_POST);
                    $informatie = $_POST["informatie"];
                    $aandoeninglijst = $_POST["aandoening"];
                    $leeftijdcatLijstPat = $_POST["leeftijdcategoriePat"];
                    $leeftijdcatLijstMan = $_POST["leeftijdcategorieMan"];
                    $relatie = $_POST["relatie"];

                    //TODO misschien alle objecten van Pathologie ophalen en dan uit die lijst selecteren
                    $bevraging = new Bevraging();
                    $bevraging->setId(0);
                    $bevraging->setInformatie($informatie);
                    $bevraging->setRelatie($relatie);
                    $bevraging->setLeeftijdsCategorie($leeftijdcatLijstPat); //enkel de leeftijdscategorie van de patient
                    //$bevraging->setLeeftijdsCategorieMan($leeftijdcatLijstMan
                    //Todo Leeftijdscategorie voor de mantelzorger ook voorzien in de klasse bevraging.php ??
                   // $bevraging->setAandoening($aandoeninglijst); //Todo aandoening aanmaken in bevraging.php





                    if (FinahDAO::SchrijfWeg("Bevraging", $bevragingg)) {
                        //Todo eventueel een exception toevoegen hier
                        //header("Location: aandoeningOverzicht.php");
                        echo "De bevraging werd succesvol opgeslagen";
                    }


                }else {
                ?>


                <ul class="form-style">
                    <li><label class="control-label">Informatie</label></li>
                    <li><input class="form-control" type="text" name="informatie"/></li>
                    <li><label class="control-label">Kies de aandoening</label></li>
                    <select class="form-control" name="aandoening[]" multiple="multiple">
                        <?php
                        $aandoening = FinahDAO::HaalOp("Aandoening");
                        foreach ($aandoening as $item) {
                            $waarde = $item->Omschrijving;
                            echo "<option value='$item->Id'>" . $item->Omschrijving . "</option>\r\n";
                        }

                        ?>
                    </select>
                    <li><label class="control-label">Kies de leeftijdscategorie van de patient</label></li>
                    <select class="form-control" name="leeftijdscategoriePat[]" multiple="multiple">
                        <?php
                        $leeftijdscategoriePat = FinahDAO::HaalOp("LeeftijdsCategorie");
                        /*   foreach ($leeftijdscategoriePat as $item) {
                               $waarde = $item->Omschrijving;
                               echo "<option value='$item->Id'>" . $item->Omschrijving . "</option>\r\n";
                           }*/

                        ?>
                    </select>
                    <li><label class="control-label">Kies de relatie tussen Patient en mantelzorger</label></li>

                    <select class="form-control" name="relatie[]" multiple="multiple">
                        <?php
                        $relatie = FinahDAO::HaalOp("Relatie");
                        /*   foreach ($leeftijdscategoriePat as $item) {
                               $waarde = $item->Omschrijving;
                               echo "<option value='$item->Id'>" . $item->Omschrijving . "</option>\r\n";
                           }*/

                        ?>
                    </select>

                    <li><input type="submit" value="Create" class="createBtn" name="creeer"/></li>
                </ul>
            </form>
            <div class="Back">
                <a href="bevragingOverzicht.php">Terug naar overzicht</a>
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
<?php }
?>
</body>
</html>
