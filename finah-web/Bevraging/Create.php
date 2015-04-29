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
    require "../PHP/Finah.php";
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
    <script src="http://code.jquery.com/jquery-2.1.1.min.js"></script>
    <script src="../js/Validate/jquery.validate.js"></script>
    <!--    <script type="text/javascript" src="../js/finah.js"></script>-->
    <script type="text/javascript">
        var data = '';

        function OnChange(e) {
            var patho = document.forms["myForm"]["pathologie"];
            var val = e.target.value;

            if (val != 'null') {
                empty(patho);
                var pat = '';
                var xhr = new JSONHttpRequest();
                //TODO link aanpassen naar Azure
                var url = "http://localhost:1695/Aandoening/" + val + "/Pathologie";
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

            <form id="myForm" name="myForm" method="POST" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>">
                <?php
                    if (isset($_POST["creeer"])) {
                    //var_dump($_POST);
                    $informatie = $_POST["informatie"];
                    $aandoening = $_POST["aandoening"];
                    $pathologie = $_POST["pathologie"];
                    $leeftijdcatPat = $_POST["leeftijdcategoriePat"];
                    $leeftijdcatMan = $_POST["leeftijdcategorieMan"];
                    $relatie = $_POST["relatie"];

                    //TODO misschien alle objecten van Pathologie ophalen en dan uit die lijst selecteren
                    $onderzoek = new Onderzoek();
                    $onderzoek->setId(0);
                    //$onderzoek->setAandoening($aandoening);
                    $onderzoek->setAandoening(FinahDAO::HaalOp("Aandoening", $aandoening));
                    //TODO wanneer we met accounts werken verder uitwerken
                    $onderzoek->setAangemaaktDoor(null);
                    $onderzoek->setPathologie(FinahDAO::HaalOp("Pathologie", $pathologie));
                    $bevraging_pat = new Bevraging();
                    $bevraging_pat->setIsPatient(true);
                    $bevraging_man = new Bevraging();
                    $bevraging_man->setIsPatient(false);
                    //TODO id laten genereren op Backend
                    $ids = FinahDAO::HaalOp("Bevraging", "UniekeIds");
                    $bevraging_pat->setId($ids[0]);
                    $bevraging_man->setId($ids[1]);

                    $antwoorden_pat = new AntwoordenLijst();
                    $antwoorden_pat->setId($bevraging_pat->getId());
                    $antwoorden_pat->setLeeftijdsCategorie(FinahDAO::HaalOp("Leeftijdscategorie", $leeftijdcatPat));

                    $datum = new DateTime("Now");
                    $dat = $datum->format('d/m/Y G:i:s');
                    $dateTime = DateTime::createFromFormat('d/m/Y G:i:s', $dat);
                    $antwoorden_pat->setDatum($dateTime);
                    $antwoorden_man = new AntwoordenLijst();
                    $antwoorden_man->setId($bevraging_man->getId());
                    $antwoorden_man->setLeeftijdsCategorie(FinahDAO::HaalOp("Leeftijdscategorie", $leeftijdcatMan));
                    $antwoorden_man->setDatum($dateTime);
                    //new DateTime(date("d/m/Y G:i:s")))
                    $onderzoek->setBevragingPat($bevraging_pat);
                    $onderzoek->setBevragingMan($bevraging_man);
                    $onderzoek->setInformatie($informatie);
                    $onderzoek->setRelatie(FinahDAO::HaalOp("Relatie", $relatie));
                    //TODO vragenlijst ophalen
                    $vrLijst = $aandoening . "/Vragenlijst";
                    $vragen = FinahDAO::HaalOp("Aandoening", $vrLijst);
                    $onderzoek->setVragen($vragen);
                    $leeg_vragen = array_fill(0,count($vragen["Vragen"])-1 ,0);
                    $antwoorden_pat->setAntwoorden($leeg_vragen);
                    $antwoorden_man->setAntwoorden($leeg_vragen);
                    //var_dump($onderzoek);
                    if (FinahDAO::SchrijfWeg("Onderzoek", $onderzoek)) {
                        //Todo eventueel een exception toevoegen hier
                        $antwoorden_man->setBevraging(FinahDAO::HaalOp("Bevraging",$antwoorden_man->getId()));
                        $antwoorden_pat->setBevraging(FinahDAO::HaalOp("Bevraging",$antwoorden_pat->getId()));
                        if (FinahDAO::SchrijfWeg("AntwoordenLijst", $antwoorden_pat) && FinahDAO::SchrijfWeg("AntwoordenLijst", $antwoorden_man)) {
                            //Todo eventueel een exception toevoegen hier
                            //header("Location: Overzicht.php");
                            echo "De bevraging werd succesvol opgeslagen";
                            $to = "gert.claeskens@student.pxl.be";
/*                            $headers  = 'MIME-Version: 1.0' . "\r\n";
                            $headers .= 'Content-type: text/html; charset=iso-8859-1' . "\r\n";
                            $headers .= 'From: gert.claeskens@student.pxl.be' . "\r\n" .
                                'Reply-To: gert.claeskens@student.pxl.be' . "\r\n" .
                                'X-Mailer: PHP/' . phpversion();*/
                            $subject = "Bevraging aangemaakt op ";
                            $msg = "Beste\r\nHartelijk dank voor jouw aanvraag\r\n\r\n";
                            $msg .= "<a href=\"http:\\\\www.finah.be\\?" . $bevraging_man->getId() . "\">De vragenlijst voor de mantelzorger kan u hier vinden</a>\r\n";
                            $msg .= "<a href=\"http:\\\\www.finah.be\\?" . $bevraging_pat->getId() . "\">De vragenlijst voor de patient kan u hier vinden</a>\r\n";
                            //$msg .= "<a href=\"http:\\\\www.google.be\">Achteraf kan u de ze link gebruiken om het rapport op te vragen</a>\r\n";
                            $msg .= "\r\n\r\nMet vriendelijke groeten\r\n\r\nFinah Webmaster";
                            $msg = wordwrap($msg, 70, "\r\n");
                            Finah::send_simple_message($to, $subject, $msg);
                        }
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

                    </select>
                    <li><label class="control-label">Kies de leeftijdscategorie van de patient</label></li>
                    <select class="form-control" name="leeftijdcategoriePat">
                        <option value="null">Maak een keuze</option>
                        <?php
                            $leeftijdscategoriePat = FinahDAO::HaalOp("LeeftijdsCategorie");
                            foreach ($leeftijdscategoriePat as $item) {
                                echo "<option value='" . $item["Id"] . "'>" . $item["Van"] . " tot " . $item["Tot"] . "</option>\r\n";
                            }

                        ?>
                    </select>
                    <li><label class="control-label">Kies de leeftijdscategorie van de mantelzorger</label></li>
                    <select class="form-control" name="leeftijdcategorieMan">
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
<script>
    // add the rule here
    $.validator.addMethod("valueNotEquals", function(value, element, arg){
        return arg != value;
    }, "Value must not equal arg.");

    $().ready(function() {
        $("#myForm").validate({
            rules: {
                aandoening: { valueNotEquals: "null" },
                pathologie: { valueNotEquals: "null" },
                leeftijdcategoriePat: { valueNotEquals: "null" },
                leeftijdcategorieMan: { valueNotEquals: "null" },
                relatie: { valueNotEquals: "null" }
            },
            messages: {
                aandoening: { valueNotEquals: "Keuze verplicht!" },
                pathologie: { valueNotEquals: "Keuze verplicht!" },
                leeftijdcategoriePat: { valueNotEquals: "Keuze verplicht!" },
                leeftijdcategorieMan: { valueNotEquals: "Keuze verplicht!" },
                relatie: { valueNotEquals: "Keuze verplicht!" }
            }
        });
    });
</script>
<?php }
?>
</body>
</html>
