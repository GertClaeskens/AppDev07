<?php
    require "../PHP/DAO/FinahDAO.php";
    require_once "../PHP/Models/Aandoening.php";
    require_once "../PHP/Models/Pathologie.php";
?>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width"/>
    <title>FINAH - Aandoening</title>
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
            <button onclick="location.href='Overzicht.php'">Pathologie</button>
            <button onclick="location.href='../LeeftijdsCategorie/Overzicht.php'">Leeftijdscategorie</button>
            <button onclick="location.href='../Vragen/Overzicht.php'">Vragen</button>
            <button onclick="location.href='../VragenLijst/Overzicht.php'">Vragenlijsten</button>
            <button onclick="location.href='../index.php'">Terug naar home</button>
        </div>
        <!--Closing DIV nav-bar-->
        <div id="body-container">
            <?php
                if (isset($_POST)) {
                    $pathologie = FinahDAO::HaalOp("Pathologie", $_POST["Id"]);
                    $naam = $pathologie["Omschrijving"];
                    if (isset($_POST["bewerk"])) {

                        echo "<h3 id = 'Breadcrumb' > Menu > Pathologie > Bewerken</h3 >";
                        echo "<h2 id = 'Content-Title' > Bewerken : " . $naam . "  </h2 >";
                    } elseif (isset($_POST["details"])) {
                        echo "<h3 id = 'Breadcrumb' > Menu > Pathologie > Details</h3 >";
                        echo "<h2 id = 'Content-Title' > Details : " . $naam . " </h2 >";
                    }
                }

            ?>
            <hr/>
            <form method="POST">
                <ul class="form-style">
                    <li><label class="control-label">Omschrijving</label></li>
                    <?php
                        if (isset($_POST["bewerk"])) {


                        //var_dump($aandoening["Omschrijving"]);
                        /*               foreach($_POST as $key => $value) {
                                           $pos = strpos($key , "edit_");
                                           if ($pos === 0){
                                               // do something with $value
                                           }
                                       }*/
                        ?>

                        <li><input class="form-control" type="text" name="omschrijving"
                                   value=<?php echo $pathologie["Omschrijving"]; ?>/></li>
                        <li><label class="control-label">Ken toe aan een aandoening</label></li>
                        <select class="form-control" name="aandoeningen[]" multiple="multiple">
                            <!--                        Pathologieen ophalen-->
                            <?php
                                //$patologieen = new PathologieArray();
                                //TODO omzetten naar Pathologie object
                                $aandoeningen = FinahDAO::HaalOp("Aandoening");
                                foreach ($aandoeningen as $item) {

                                    echo "<option value='" . $item["Id"] . "'>" . $item["Omschrijving"] . "</option>\r\n";
                                }
                                //var_dump($patologieen);
                                //                        for ($a=0;$a<count($patologieen);$a++){
                                //                            echo "<option>" . $patologieen->Omschrijving . "</option>\r\n";
                                //                        }

                                //TODO Opslaan gegevens van Edit implementeren
                                //TODO gegevens tonen van Geluidsfragment
                                //TODO gegevens tonen van Afbeelding
                            ?>

                        </select>

                        <li>
                            <button class="actieBtn" onclick="window.location='Overzicht.php';return false;">
                                Terug
                            </button>
                            <input type="submit" value="Edit" class="actieBtn" name="edit"/></li>

                    <?php
                    }elseif (isset($_POST["details"]))
                        {
                    ?>

                    <li><?php echo $pathologie["Omschrijving"]; ?></li>
                    <li><label class="control-label">Bijhorende Aandoeningen</label></li>
                    <?php
                        foreach ($pathologie["Aandoeningen"] as $aand) {
                            echo "<li> " . $aand["Omschrijving"] . "</li>";
                        }
                    ?>
                    <li>
                        <button class="actieBtn" onclick="window.location='Overzicht.php';return false;">
                            Terug
                        </button>
                    </li>


                </ul>
            </form>
        <?php
            } elseif (isset($_POST["details"])) {
            ?>
            <div class="Back">
                <a href="Overzicht.php">Terug naar overzicht</a>
            </div>
        <?php
        };
        ?>
        </div>
        <!--Closing DIV body containerr-->
    </div>
    <!--Closing DIV innerwrapper-->
    <div id="page-footer">
        <p>&copy; Copyright 2015-2016. All Rights Reserved</p>
    </div>
</div>
<!--Closing DIV wrapper-->

</body>
</html>
