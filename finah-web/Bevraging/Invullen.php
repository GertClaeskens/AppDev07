<?php
    /**
     * Created by PhpStorm.
     * User: Brian
     * Date: 1/04/2015
     * Time: 10:20
     */
    require "../PHP/DAO/FinahDAO.php";
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
    $bevraging=FinahDAO::HaalOp("Bevraging",$_GET["id"]);
    $antwoorden=FinahDAO::HaalOp("Antwoordenlijst",$_GET["id"]);
    $aandoening=FinahDAO::HaalOp("Onderzoek",$_GET["id"]);
    if (array_search(0,$antwoorden)){
        $aantalingevuld=array_search(0,$antwoorden);
    }
    $aantalingevuld-=1;
    //echo $bevraging["IsPatient"];
    $patient = ($bevraging["IsPatient"]==true)?true:false;
    if ($patient){
        echo "<h2>Enquete Patient</h2>";
    }else{
        echo "<h2>Enquete Mantelzorger</h2>";
    }
    $vrLijst = $aandoening["Id"] . "/Vragenlijst";
    $vragen = FinahDAO::HaalOp("Aandoening", $vrLijst);
    ?>
<!--    TODO als er al vragen zijn ingevuld moet er op de button staan hervatten vragenlijst-->
    <form name="myForm" method="POST" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>">

    Korte inleiding over de enquete</br></br>

        <input type="hidden" name="vragen[]" value="<?php echo $vragen?>">
        <input type="hidden" name="id" id="id" value="<?php echo $_GET["id"]?>">
        <input type="hidden" name="volgende" value="<?php echo $aantalingevuld?>">
        <input type="hidden" name="patient" id="patient" value="<?php echo $patient?>">
        <?php if ($aantalingevuld>0){?>

        <input type="submit" name="start" value="Hervat Vragenlijst" class="btn btn-primary antwoordButton">
        <?php }else{?>
	    <input type="submit" name="start" value="Start Vragenlijst" class="btn btn-primary antwoordButton">
        <?php }?>
</div> <!-- einde pagina1 -->
</form>
<?php }elseif (isset($_POST["start"])){
    var_dump($_POST["vragen"]);
    $vraag=array_shift($_POST["vragen"]);
    var_dump($vraag);
    $vragen = $_POST["vragen"];
    $patient = $_POST["patient"];
    $aantalingevuld = $_POST["volgende"]+1;
//TODO vorige antwoord opslaan
//TODO Zolang er vragen zijn tonen
    ?>
<form class="bs-example bs-example-form" role="form">
    <div class="container">
        <div class="div-group row" id="vraagDiv">
            <p id="thema">Leren en toepassen van kennis.</p>
            <?php var_dump($vraag);?>
            <p id="vraag">Vraag <?php echo ($aantalingevuld+1) . " " . $vraag->Vraagstelling?></p>
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
                    hinderlijk voor <?php echo $patient?"mantelzorger":"patient"?>
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

        <input type="hidden" name="vragen[]" value="<?php echo $vragen?>">
        <input type="hidden" name="id" id="id" value="<?php echo $_GET["id"]?>">
        <input type="hidden" name="volgende" value="<?php echo $aantalingevuld?>">
        <input type="hidden" name="patient" id="patient" value="<?php echo $patient?>">

        <div class="btn-group row" role="group" id="next">
            <div id="vorige" class="col-md">
                <button type="submit" class="btn btn-primary prevButton">Vorige</button>
            </div>
            <div id="volgende" class="col-md">
                <button type="submit" name="start" class="btn btn-primary nextButton">Volgende</button>
            </div>
        </div>

        <div class="row progress">
            <div class="progress-bar" role="progressbar" aria-valuenow="70" aria-valuemin="0" aria-valuemax="100">
                <p id="percentage">70%</p>
            </div>
        </div>
    </div>
</form>
<?php }?>
</body>
</html>