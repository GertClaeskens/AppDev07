<?php
    /**
     * Created by PhpStorm.
     * User: Rafaël
     * Date: 27/03/2015
     * Time: 0:28
     */
    require "../PHP/DAO/FinahDAO.php";
    require "../PHP/Models/Bevraging.php";
    require "../PHP/Models/Onderzoek.php";
    require "../PHP/Models/AntwoordenLijst.php";

?>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width"/>
    <title>FINAH - Bevraging</title>
    <link rel="stylesheet" type="text/css" href="../Css/Stylesheet.css"/>
<!--    <link rel="stylesheet" type="text/css" href="../Css/bootstrap.css"/>-->
    <script src="../js/jquery-2.1.3.min.js"></script>
    <script src="../js/jsonhttprequest.min.js"></script>
    <!--    <script type="text/javascript" src="../js/finah.js"></script>-->
    <script type="text/javascript">
        var data = '';

        function OnChange(e) {
            var patho = document.forms["myForm"]["pathologie"];
            var val = e.target.value;

            if (val != 'null') {
                empty(patho);
                var pat='';
                var xhr = new JSONHttpRequest();

                var url = "http://localhost:1695/Aandoening/"+val+"/Pathologie";
                xhr.open("GET", url, true);

                xhr.onreadystatechange = function () {
                    if (xhr.readyState === 4 && xhr.status === 200) {
                        pat = JSON.parse(xhr.responseText);
                        //alert(pat[0].Omschrijving + " " + pat.length);
                        for (var i = 0; i < pat.length; i++) {
                            var option = document.createElement('option');
                            option.value = pat[i].Id;
                            option.textContent = pat[i].Omschrijving;
                            option.innerText = pat[i].Omschrijving;
                            patho.appendChild(option);
                        }
                    }
                };
                xhr.send(null);

            }
        }


        function empty(select) {
            select.innerHTML = '';
        }

    </script>
</head>
<body>
<div id="wrapper">
    <div id="page-header">
        <h1>FINAH</h1>
    </div>
    <!--Closing DIV page header-->
    <div id="inner-wrapper">
        <div id="nav-bar">
            <h2> Menu </h2>
            <button onclick="location.href='../index.php'">Home</button>
            <button onclick="location.href='Account.php'">Mijn account</button>
            <button onclick="location.href='Overzicht.php'">Bevragingen</button>
            <button onclick="location.href='../Aandoening/Overzicht.php'">Beheren</button>
            <button onclick="location.href='#'">Uitloggen</button>

        </div>
        <!--Closing DIV nav-bar-->
        <div id="body-container">
            <h3 id="Breadcrumb">Menu > Bevraging > Aanmaken</h3>

            <h2 id="Content-Title">Nieuwe bevraging</h2>
            <hr/>

            <form name="myForm" method="POST" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>">
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
                    //$bevraging->setInformatie($informatie);
                    //$bevraging->setRelatie($relatie);
                    //$bevraging->setLeeftijdsCategorie($leeftijdcatLijstPat); //enkel de leeftijdscategorie van de patient
                    //$bevraging->setLeeftijdsCategorieMan($leeftijdcatLijstMan
                    //Todo Leeftijdscategorie voor de mantelzorger ook voorzien in de klasse bevraging.php ??
                    // $bevraging->setAandoening($aandoeninglijst); //Todo aandoening aanmaken in bevraging.php


                    if (FinahDAO::SchrijfWeg("Bevraging", $bevraging)) {
                        //Todo eventueel een exception toevoegen hier
                        //header("Location: Overzicht.php");
                        echo "De bevraging werd succesvol opgeslagen";
                    }


                }else {
                ?>


                <ul class="form-style">
                    <li><label class="control-label">Informatie</label></li>
                    <li><textarea class="form-control" rows="5" id="informatie" name="informatie"></textarea></li>
                    <li><label class="control-label">Kies de aandoening</label></li>
                    <select class="form-control" id="aandoening" name="aandoening" onchange="OnChange(event)">
                        <option value="null">Maak een keuze</option>
                        <?php
                            $aandoening = FinahDAO::HaalOp("Aandoening");
                            foreach ($aandoening as $item) {
                                echo "<option value='" . $item["Id"] . "'>" . $item["Omschrijving"] . "</option>\r\n";
                            }

                        ?>
                    </select>
                    <li><label class="control-label">Kies de pathologie</label></li>
                    <select class="form-control" name="pathologie" id="pathologie">
                        <option value="null">Maak een keuze</option>
                        <!--                        TODO moet pas ingeladen worden als de aandoening geselecteerd is -> Javascript?-->
                        <?php
                            /*                            $pathologie = FinahDAO::HaalOp("Pathologie");
                                                        foreach ($pathologie as $item) {
                                                            $waarde = $item->Omschrijving;
                                                            echo "<option value='" . $item["Id"] . "'>" . $item["Omschrijving"] . "</option>\r\n";
                                                        }

                                                    */ ?>
                    </select>
                    <li><label class="control-label">Kies de leeftijdscategorie van de patient</label></li>
                    <select class="form-control" name="leeftijdscategoriePat">
                        <option value="null">Maak een keuze</option>
                        <?php
                            $leeftijdscategoriePat = FinahDAO::HaalOp("LeeftijdsCategorie");
                            foreach ($leeftijdscategoriePat as $item) {
                                echo "<option value='" . $item["Id"] . "'>" . $item["Van"] . " tot " . $item["Tot"] . "</option>\r\n";
                            }

                        ?>
                    </select>
                    <li><label class="control-label">Kies de leeftijdscategorie van de mantelzorger</label></li>
                    <select class="form-control" name="leeftijdscategorieMan">
                        <option value="null">Maak een keuze</option>
                        <?php
                            $leeftijdscategoriePat = FinahDAO::HaalOp("LeeftijdsCategorie");
                            foreach ($leeftijdscategoriePat as $item) {
                                echo "<option value='" . $item["Id"] . "'>" . $item["Van"] . " tot " . $item["Tot"] . "</option>\r\n";
                            }

                        ?>
                    </select>
                    <li><label class="control-label">Kies de relatie tussen Patient en mantelzorger</label></li>

                    <select class="form-control" name="relatie">
                        <option value="null">Maak een keuze</option>
                        <?php
                            $relatie = FinahDAO::HaalOp("Relatie");
                            foreach ($relatie as $item) {
                                echo "<option value='" . $item["Id"] . "'>" . $item["Naam"] . "</option>\r\n";
                            }

                        ?>
                    </select>

                    <li><input type="submit" value="Create" class="actieBtn" name="creeer"/></li>
                </ul>
            </form>
            <div class="Back">
                <a href="Overzicht.php">Terug naar overzicht</a>
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
