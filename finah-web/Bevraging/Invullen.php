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
    $aantalingevuld = 2;
    $bevraging=FinahDAO::HaalOp("Bevraging",$_GET["id"]);
    //echo $bevraging["IsPatient"];
    $patient = ($bevraging["IsPatient"]==true)?true:false;
    if ($patient){
        echo "<h2>Enquete Patient</h2>";
    }else{
        echo "<h2>Enquete Mantelzorger</h2>";
    }
    ?>
<!--    TODO als er al vragen zijn ingevuld moet er op de button staan hervatten vragenlijst-->
    <form name="myForm" method="POST" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>">

    Korte inleiding over de enquete</br></br>

        <input type="hidden" name="id" value="<?php echo $_GET["id"]?>">
        <input type="hidden" name="volgende" value="<?php echo $aantalingevuld?>">
        <?php if ($aantalingevuld>0){?>

        <input type="submit" name="volgende" value="Hervat Vragenlijst" class="btn btn-primary antwoordButton">
        <?php }else{?>
	    <input type="submit" name="volgende" value="Start Vragenlijst" class="btn btn-primary antwoordButton">
        <?php }?>
</div> <!-- einde pagina1 -->
</form>
<?php }else{?>
<form class="bs-example bs-example-form" role="form">
    <div class="container">
        <div class="div-group row" id="vraagDiv">
            <p id="thema">Leren en toepassen van kennis.</p>

            <p id="vraag">Iets nieuws leren.</p>
            <img class="thumbnail" src="../Vragen/test.png" alt="...">
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
                    hinderlijk voor mantelzorger
                </button>
            </div>
            <div class="col-md-2">
                <button type="button" class="btn btn-primary antwoordButton" onclick="showDiv()">Probleem -
                    hinderlijk voor beide
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

        <div class="btn-group row" role="group" id="next">
            <div id="vorige" class="col-md">
                <button type="submit" class="btn btn-primary prevButton">Vorige</button>
            </div>
            <div id="volgende" class="col-md">
                <button type="submit" class="btn btn-primary nextButton">Volgende</button>
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