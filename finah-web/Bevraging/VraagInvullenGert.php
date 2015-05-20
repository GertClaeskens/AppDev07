<?php
    /**
     * Created by PhpStorm.
     * User: Brian
     * Date: 1/04/2015
     * Time: 10:20
     */

    require "../PHP/DAO/FinahDAO.php";
    require "../PHP/Finah.php";
?>
<html>
<head>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="../Css/StylesheetVragenInvullen.css"/>
    <script type="text/javascript" src="../js/VraagInvullen.js"></script>
    <script src="../js/jquery-2.1.3.min.js"></script>
    <script>
        /*        $(function () {
         $(':radio').on('change', function () {
         $(':radio').not(this).closest('li').removeClass('selected');
         $(this).closest('li').addClass('selected');
         });
         };*/
    </script>
    <title>FINAH - Bevraging</title>
</head>
<body>
<?php
    if (isset($_GET)){
        $bevraging = FinahDAO::HaalOp("Bevraging", $_GET["id"]);
        print_r($bevraging);
        $arr=explode(",",$bevraging["Antwoorden"]);
        var_dump($arr);
        //$antwoorden = Finah::csvToArray($bevraging["Antwoorden"]);
        //print_r($antwoorden);
    }
if (isset($_POST["volgende"])){
    print_r($_POST);
}else{
?>

<div class="wrapper">
    <div class="container">
        <form class="bs-example bs-example-form" role="form" method="POST" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>">
            <div class="div-group row" id="vraagDiv">
                <p id="thema">Leren en toepassen van kennis.</p>

                <p id="vraag">Iets nieuws leren.</p>
                <img class="thumbnail" src="../Vragen/test.png" alt="...">
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
                            hinderlijk voor  <?php /*echo $patient ? "mantelzorger" : "patient";*/ ?></input></label>
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
                <!--                <div class="col-lg-2 col-md-2 col-sm-2">
                    <button type="button" class="btn btn-primary antwoordButton" id="antw11" onclick="hideDiv(); toggleActive('antw11')">
                        Verloopt
                        naar
                        wens
                    </button>
                </div>
                <div class="col-lg-2 col-md-2 col-sm-2">
                    <button type="button" class="btn btn-primary antwoordButton" id="antw12" onclick="hideDiv(); toggleActive('antw12')">
                        Probleem
                        - niet
                        hinderlijk
                    </button>
                </div>
                <div class="col-lg-2 col-md-2 col-sm-2">
                    <button type="button" class="btn btn-primary antwoordButton" id="antw13" onclick="showDiv(); toggleActive('antw13')">
                        Probleem
                        -
                        hinderlijk voor mij
                    </button>
                </div>
                <div class="col-lg-2 col-md-2 col-sm-2">
                    <button type="button" class="btn btn-primary antwoordButton" id="antw14" onclick="showDiv(); toggleActive('antw14')">
                        Probleem
                        -
                        hinderlijk voor <?php /*echo $patient ? "mantelzorger" : "patient";*/ ?>
                    </button>
                </div>
                <div class="col-lg-2 col-md-2 col-sm-2">
                    <button type="button" class="btn btn-primary antwoordButton" id="antw15" onclick="showDiv(); toggleActive('antw15')">
                        Probleem
                        -
                        hinderlijk voor beiden
                    </button>
                </div> -->
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
                                <input type="radio" id="h2" name="hulp" value="0">Nee</input></label>
                        </li>
                    </ul>
                    <!--                        <div class="col-md-2">
                                                <button type="button" class="btn btn-primary antwoordButton" id="antw21"
                                                        onclick="toggleActiveExtra('antw21')">Nee
                                                </button>
                                            </div>
                                            <div class="col-md-2">
                                                <button type="button" class="btn btn-primary antwoordButton" id="antw22"
                                                        onclick="toggleActiveExtra('antw22')">Ja
                                                </button>
                                            </div>-->
                </div>
            </div>

            <div class="btn-group row" role="group" id="next">
                <div class="col-md-2" id="divPrev">
                    <button type="submit" name="vorige" class="btn btn-primary prevButton">Vorige</button>
                </div>
                <div class="col-md-2" id="divNext">
                    <button type="submit"  name="volgende" class="btn btn-primary nextButton">Volgende</button>
                </div>
            </div>

            <div class="row progress">
                <div class="progress-bar" role="progressbar" aria-valuenow="70" aria-valuemin="0"
                     aria-valuemax="100">
                    <p id="percentage">30%</p>
                </div>
            </div>
        </form>
    </div>
</div>
<?php } ?>
</body>
</html>