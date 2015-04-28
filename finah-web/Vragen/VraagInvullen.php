<?php
/**
 * Created by PhpStorm.
 * User: Brian
 * Date: 1/04/2015
 * Time: 10:20
 */
?>
<html>
<head>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="../Css/StylesheetVragenInvullen.css"/>
    <script type="text/javascript" src="../js/VraagInvullen.js"></script>
    <title>FINAH - Bevraging</title>
</head>
<body>
<div class="wrapper">
    <div class="container">
        <form class="bs-example bs-example-form" role="form">
            <div class="div-group row" id="vraagDiv">
                <p id="thema">Leren en toepassen van kennis.</p>

                <p id="vraag">Iets nieuws leren.</p>
                <img class="thumbnail" src="../Vragen/test.png" alt="...">
            </div>

            <div class="btn-group row" role="group" id="ervaring">
                <p class="eVraag">Hoe ervaar ik dit onderdeel?</p>

                <div class="col-lg-2 col-md-2 col-sm-2">
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
                        hinderlijk voor mantelzorger
                    </button>
                </div>
                <div class="col-lg-2 col-md-2 col-sm-2">
                    <button type="button" class="btn btn-primary antwoordButton" id="antw15" onclick="showDiv(); toggleActive('antw15')">
                        Probleem
                        -
                        hinderlijk voor beiden
                    </button>
                </div>
            </div>

            <div class="row" id="keuze">
                <div class="btn-group" id="keuze-content">
                    <p class="eVraag">Wilt u dat we hieraan werken?</p>

                    <div class="col-md-2">
                        <button type="button" class="btn btn-primary antwoordButton" id="antw21" onclick="toggleActiveExtra('antw21')">Nee</button>
                    </div>
                    <div class="col-md-2">
                        <button type="button" class="btn btn-primary antwoordButton" id="antw22" onclick="toggleActiveExtra('antw22')">Ja</button>
                    </div>
                </div>
            </div>

            <div class="btn-group row" role="group" id="next">
                <div class="col-md-2" id="divPrev">
                    <button type="submit" class="btn btn-primary prevButton">Vorige</button>
                </div>
                <div class="col-md-2" id="divNext">
                    <button type="submit" class="btn btn-primary nextButton">Volgende</button>
                </div>
            </div>

            <div class="row progress">
                <div class="progress-bar" role="progressbar" aria-valuenow="70" aria-valuemin="0" aria-valuemax="100">
                    <p id="percentage">70%</p>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>