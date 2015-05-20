<?php
    /**
     * Created by PhpStorm.
     * User: Brian
     * Date: 1/04/2015
     * Time: 10:20
     */
    require "../PHP/DAO/FinahDAO.php";
    require "../PHP/Finah.php";
    require "../PHP/Models/Bevraging.php";
?>
<html>
<head>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="../Css/StylesheetVragenInvullen.css"/>
    <script type="text/javascript" src="../js/VraagInvullen.js"></script>
    <title>FINAH - Bevraging</title>
</head>
<body>
<?php
    if (isset($_GET["id"])) {
//    TODO kijken of er al vragen zijn ingevuld
        $aantalingevuld = 0;
        $volgende = 1;
        $bevraging = new Bevraging();
        $bevraging = FinahDAO::HaalOp("Bevraging", $_GET["id"]);
        $antwoordenlijst = FinahDAO::HaalOp("Antwoordenlijst", $_GET["id"]);
        $antwoorden = Finah::csvToArray($antwoordenlijst["Antwoorden"]);
        if (array_search("0", $antwoorden)) {
            $aantalingevuld = array_search(0, $antwoorden);
        }
        $aantalingevuld = 0;
        $patient = ($bevraging["IsPatient"] == true) ? true : false;
        if ($patient) {
            echo "<h2>Enquete Patient</h2>";
        } else {
            echo "<h2>Enquete Mantelzorger</h2>";
        }
        ?>
        <!--    TODO als er al vragen zijn ingevuld moet er op de button staan hervatten vragenlijst-->
        <form name="myForm" method="POST" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>">

            Korte inleiding over de enquete<br/><br/>

            <input type="hidden" name="id" id="id" value="<?php echo $_GET["id"] ?>">
            <!--TODO datum ophalen kijken van de oudste niet volledig ingevulde antwoordenlijst wat de datum is, ofwel dit op de backend toepassen-->
            <!--            <input type="hidden" name="datum" id="datum">-->
            <input type="hidden" name="volgendevraag" value="<?php echo $aantalingevuld ?>">
            <input type="hidden" name="patient" id="patient" value="<?php echo $patient ?>">
            <?php if ($aantalingevuld > 0) { ?>

                <input type="submit" name="volgende" value="Hervat Vragenlijst" class="btn btn-primary antwoordButton">
            <?php } else { ?>
                <input type="submit" name="volgende" value="Start Vragenlijst" class="btn btn-primary antwoordButton">
            <?php } ?>
            <!-- </div> --><!-- einde pagina1 -->
        </form>
    <?php } elseif (isset($_POST["volgende"])) {

        $volgende = $_POST["volgendevraag"];
        $id = $_POST["id"];
        $vragen = FinahDAO::HaalOp("Onderzoek", $id . "/Vragen");
        $vraag = $vragen[0][$volgende];
        $patient = $_POST["patient"];
        $gedaan = (int)($volgende * 100 / count($vragen[0]));
        if ($volgende > 0) {
            $antwoordenlijst = FinahDAO::HaalOp("Antwoordenlijst", $id);
            if (isset($_POST["hulp"])) {
                $antwoord = $_POST["hinder"] + $_POST["hulp"];
            } else {
                $antwoord = $_POST["hinder"];
            }
            //$antwoordenlijst = new AntwoordenLijst();
            $antwoorden = Finah::csvToArray($antwoordenlijst["Antwoorden"]);
            $antwoorden[$volgende] = $antwoord;
            $antwoordenlijst["Antwoorden"] = Finah::arrayToCsv($antwoorden);
            FinahDAO::PasAan("antwoordenlijst", $id, $antwoordenlijst);
        }
        $volgende += 1;
        //FinahDAO::PasAan("antwoordlijst",$_POST["id"])
//TODO vorige antwoord opslaan
//TODO Zolang er vragen zijn tonen
        ?>
        <form class="bs-example bs-example-form" role="form" method="POST"
              action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>">
            <div class="container">
                <div class="div-group row" id="vraagDiv">
                    <!--TODO thema toevoegen aan database?  -->
                    <p id="thema"><?= $vraag["Thema"]?> </p>

                    <p id="vraag">Vraag <?php echo ($volgende) . ": " . $vraag["VraagStelling"] ?></p>
                    <img class="thumbnail" src="../Vragen/test.PNG" alt="...">
                </div>

                <div class="btn-group row" role="group" id="ervaring">
                    <p class="eVraag">Hoe ervaar ik dit onderdeel?</p>
                    <ul class="invullen">
                        <li class="col-lg-2 col-md-2 col-sm-2">
                            <label for="a1" class="btn btn-primary antwoordButton" id="antw11"
                                   onclick="hideDiv(); toggleActive('antw11')">
                                <input type="radio" id="a1" name="hinder" value="0"> Verloopt
                                naar
                                wens</input></label>
                        </li>
                        <li class="col-lg-2 col-md-2 col-sm-2">
                            <label for="a2" class="btn btn-primary antwoordButton" id="antw12"
                                   onclick="hideDiv(); toggleActive('antw12')">
                                <input type="radio" id="a2" name="hinder" value="1">Probleem
                                - niet
                                hinderlijk</input></label>
                        </li>
                        <li class="col-lg-2 col-md-2 col-sm-2">
                            <label for="a3" class="btn btn-primary antwoordButton" id="antw13"
                                   onclick="showDiv(); toggleActive('antw13')">
                                <input type="radio" id="a3" name="hinder" checked="checked" value="2"> Probleem
                                -
                                hinderlijk voor mij</input></label>
                        </li>
                        <li class="col-lg-2 col-md-2 col-sm-2">
                            <label for="a4" class="btn btn-primary antwoordButton" id="antw14"
                                   onclick="showDiv(); toggleActive('antw14')">
                                <input type="radio" id="a4" name="hinder" value="3"> Probleem
                                -
                                hinderlijk voor  <?php echo $patient ? "mantelzorger" : "patient"; ?></input></label>
                        </li>
                        <li class="col-lg-2 col-md-2 col-sm-2">
                            <label for="a5" class="btn btn-primary antwoordButton" id="antw15"
                                   onclick="showDiv(); toggleActive('antw15')">
                                <input type="radio" id="a5" name="hinder" value="4"> Probleem
                                -
                                hinderlijk voor beiden</input></label>
                        </li>
                        <li class="col-lg-1 col-md-1 col-sm-1">

                        </li>
                    </ul>
                </div>
                <div class="btn-group row" id="keuze">
                    <div id="keuze-content">
                        <p class="eVraag">Wilt u dat we hieraan werken?</p>
                        <ul class="invullen">
                            <li class="col-lg-2 col-md-2 col-sm-2">
                                <label for="h1" class="btn btn-primary antwoordButton" data-toggle="tab" id="antw21"
                                       onclick="toggleActiveExtra('antw21')">
                                    <input type="radio" id="h1" name="hulp" value="3"> Ja</input></label>
                            </li>
                            <li class="col-lg-2 col-md-2 col-sm-2">
                                <label for="h2" class="btn btn-primary antwoordButton" id="antw22"
                                       onclick="toggleActiveExtra('antw22')">
                                    <input type="radio" id="h2" name="hulp" selected=selected value="0">Nee</input>
                                </label>
                            </li>
                        </ul>
                    </div>
                </div>

                <input type="hidden" name="id" value="<?php echo $_POST["id"] ?>">
                <input type="hidden" name="volgendevraag" value="<?php echo $volgende ?>">
                <input type="hidden" name="patient" value="<?php echo $patient ?>">

                <div class="btn-group row" role="group" id="next">

                    <div id="divPrev" class="col-md-2">
                        <?php if ($volgende > 1) { ?>
                            <button type="submit" name="vorige" class="btn btn-primary prevButton">Vorige</button>
                        <?php } ?>
                    </div>

                    <div id="divNext" class="col-md-2">
                        <!--                        --><?php //if ($volgende > count($vragen[0])) { ?>
                        <button type="submit" name="volgende" class="btn btn-primary nextButton">Volgende</button>
                        <!--                        --><?php //} ?>
                    </div>
                </div>

                <div class="row progress">
                    <div class="progress-bar" role="progressbar" aria-valuenow="<?php echo $gedaan; ?>"
                         style="width:<?php echo $gedaan; ?>%" aria-valuemin="0"
                         aria-valuemax="100">
                        <p id="percentage"><?php echo $gedaan . "%" ?></p>
                    </div>
                </div>
            </div>
        </form>
    <?php } ?>
</body>
</html>