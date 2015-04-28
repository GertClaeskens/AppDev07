<?php
    /**
     * Created by PhpStorm.
     * User: Brian
     * Date: 1/04/2015
     * Time: 10:20
     */
    require "../PHP/DAO/FinahDAO.php";
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
        $antwoorden = FinahDAO::HaalOp("Antwoordenlijst", $_GET["id"]);
        if (array_search("0", $antwoorden)) {
            $aantalingevuld = array_search(0, $antwoorden);
        }
        echo "test" . $aantalingevuld;
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

            Korte inleiding over de enquete</br></br>
            <!--        --><?php
                /*            $serialized =htmlspecialchars(serialize($vragen));
                        */ ?>

            <input type="hidden" name="id" id="id" value="<?php echo $_GET["id"] ?>">
            <input type="hidden" name="volgende" value="<?php echo $aantalingevuld ?>">
            <input type="hidden" name="patient" id="patient" value="<?php echo $patient ?>">
            <?php if ($aantalingevuld > 0) { ?>

                <input type="submit" name="volgende" value="Hervat Vragenlijst" class="btn btn-primary antwoordButton">
            <?php } else { ?>
                <input type="submit" name="volgende" value="Start Vragenlijst" class="btn btn-primary antwoordButton">
            <?php } ?>
            </div> <!-- einde pagina1 -->
        </form>
    <?php } elseif (isset($_POST["volgende"])) {

        $volgende = $_POST["volgende"];
        $vragen = FinahDAO::HaalOp("Onderzoek", $_POST["id"] . "/Vragen");
        $vraag = $vragen[0][$volgende];
        $patient = $_POST["patient"];
        $volgende += 1;
//TODO vorige antwoord opslaan
//TODO Zolang er vragen zijn tonen
        ?>
        <form class="bs-example bs-example-form" role="form" method="POST"
              action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>">
            <div class="container">
                <div class="div-group row" id="vraagDiv">
                    <!--TODO thema toevoegen aan database?  -->
                    <p id="thema">Leren en toepassen van kennis.</p>

                    <p id="vraag">Vraag <?php echo ($volgende) . ": " . $vraag["VraagStelling"]?></p>
                    <img class="thumbnail" src="../Vragen/test.PNG" alt="...">
                </div>

                <div class="btn-group row" role="group" id="ervaring">
                    <p class="eVraag">Hoe ervaar ik dit onderdeel?</p>

                    <div class="col-md-2">
                        <button type="button" class="btn btn-primary antwoordButton" onclick="hideDiv()">Verloopt naar
                            wens
                        </button>
                    </div>
                    <div class="col-md-2">
                        <button type="button" class="btn btn-primary antwoordButton" onclick="hideDiv()">Probleem - niet
                            hinderlijk
                        </button>
                    </div>
                    <div class="col-md-2">
                        <button type="button" class="btn btn-primary antwoordButton" onclick="showDiv()">Probleem -
                            hinderlijk voor mij
                        </button>
                    </div>
                    <div class="col-md-2">
                        <button type="button" class="btn btn-primary antwoordButton" onclick="showDiv()">Probleem -
                            hinderlijk voor <?php echo $patient ? "mantelzorger" : "patient"?>
                        </button>
                    </div>
                    <div class="col-md-2">
                        <button type="button" class="btn btn-primary antwoordButton" onclick="showDiv()">Probleem -
                            hinderlijk voor beiden
                        </button>
                    </div>
                </div>

                <div class="row" id="keuze">
                    <div class="btn-group" id="keuze-content">
                        <p class="eVraag">Wilt u dat we hieraan werken?</p>

                        <div class="col-md-2">
                            <button type="button" class="btn btn-primary antwoordButton">Nee</button>
                        </div>
                        <div class="col-md-2">
                            <button type="button" class="btn btn-primary antwoordButton">Ja</button>
                        </div>
                    </div>
                </div>
                <?php
                    $serialized = htmlspecialchars(serialize($vragen));
                ?>
                <input type="hidden" name="id" value="<?php echo $_POST["id"]?>">
                <input type="hidden" name="volgende" value="<?php echo $volgende?>">
                <input type="hidden" name="patient" value="<?php echo $patient?>">

                <div class="btn-group row" role="group" id="next">
                    <div id="vorige" class="col-md">
                        <button type="submit" name="vorige" class="btn btn-primary prevButton">Vorige</button>
                    </div>
                    <div id="volgende" class="col-md">
                        <button type="submit" name="volgende" class="btn btn-primary nextButton">Volgende</button>
                    </div>
                </div>

                <div class="row progress">
                    <div class="progress-bar" role="progressbar" aria-valuenow="70" aria-valuemin="0"
                         aria-valuemax="100">
                        <p id="percentage">70%</p>
                    </div>
                </div>
            </div>
        </form>
    <?php } ?>
</body>
</html>