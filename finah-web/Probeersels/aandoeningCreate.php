<?php
    /**
     * Created by PhpStorm.
     * User: Rafaël
     * Date: 27/03/2015
     * Time: 0:28
     */
    require "../DAO/FinahDAO.php";
    require "../Models/Aandoening.php";
?>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width"/>
    <title>FINAH - Aandoening</title>
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
            <h2> Beheren </h2>
            <button onclick="location.href='aandoeningOverzicht.php'">Aandoening</button>
            <button onclick="location.href='pathologieOverzicht.php'">Pathologie</button>
            <button onclick="location.href='leeftijdscategorieOverzicht.php'">Leeftijdscategorie</button>
            <button onclick="location.href='VragenOverzicht.php'">Vragen</button>
            <button onclick="location.href='VragenlijstOverzicht.php'">Vragenlijsten</button>
            <button onclick="location.href='index.php'">Terug naar home</button>
        </div>
        <!--Closing DIV nav-bar-->
        <div id="body-container">
            <h3 id="Breadcrumb">Menu > Aandoening > Aanmaken</h3>

            <h2 id="Content-Title">Nieuwe aandoening</h2>
            <hr/>

            <form method="POST" <?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>>
                <?php
                    if (isset($_POST["creeer"])) {
                    var_dump($_POST);
                    $omschrijving = $_POST["omschrijving"];
                    $patologielijst = $_POST["pathologie"];
//TODO misschien alle objecten van Pathologie ophalen en dan uit die lijst selecteren
                    $aandoening = new Aandoening();
                    $aandoening->Id = 0;
                    $aandoening->setOmschrijving($omschrijving);
//                    $aandoening->setPatologieen($patologielijst);
                    for ($a = 0; $a < count($patologielijst); $a++) {
                        $aandoening->voegPathologieAanLijstToe(FinahDAO::HaalOp("Pathologie", $patologielijst[$a]));
                    };
                    //var_dump


                    if (FinahDAO::SchrijfWeg("Aandoening", $aandoening)) {
                        //Todo eventueel een exception toevoegen hier
                        //header("Location: aandoeningOverzicht.php");
                       echo "De aandoening werd succesvol opgeslagen";
                    }
                    //$aandoening->setPatologieen($patologielijst);
                    //var_dump($aandoening);

                }else {
                ?>


                <ul class="form-style">
                    <li><label class="control-label">Omschrijving</label></li>
                    <li><input class="form-control" type="text" name="omschrijving"/></li>
                    <li><label class="control-label">Kies een pathologie</label></li>
                    <select class="form-control" name="pathologie[]" multiple="multiple">
                        <!--                        Pathologieen ophalen-->
                        <?php
                            //$patologieen = new PathologieArray();
                            //TODO omzetten naar Pathologie object
                            $patologieen = FinahDAO::HaalOp("Pathologie");
                            foreach ($patologieen as $item) {
                                $waarde = $item->Omschrijving;
                                echo "<option value='$item->Id'>" . $item->Omschrijving . "</option>\r\n";
                            }
                            //var_dump($patologieen);
                            //                        for ($a=0;$a<count($patologieen);$a++){
                            //                            echo "<option>" . $patologieen->Omschrijving . "</option>\r\n";
                            //                        }
                        ?>

                    </select>

                    <li><input type="submit" value="Create" class="createBtn" name="creeer"/></li>
                </ul>
            </form>
            <div class="Back">
                <a href="aandoeningOverzicht.php">Terug naar overzicht</a>
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
