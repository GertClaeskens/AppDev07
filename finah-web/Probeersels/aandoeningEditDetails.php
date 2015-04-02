<?php
    require "../DAO/FinahDAO.php";
    require_once "../Models/Aandoening.php";
    require_once "../Models/Pathologie.php";
?>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width" />
    <title>FINAH - Aandoening</title>
    <link rel="stylesheet" type="text/css" href="Stylesheet.css"/>
</head>
<body>
<div id="wrapper">
    <div id="page-header">
        <h1>FINAH</h1>
    </div> <!--Closing DIV page header-->
    <div id="inner-wrapper">
        <div id="nav-bar2">
            <h2> Beheren </h2>
            <button onclick="location.href='aandoeningOverzicht.php'">Aandoening</button>
            <button onclick="location.href='pathologieOverzicht.php'">Pathologie</button>
            <button onclick="location.href='leeftijdscategorieOverzicht.php'">Leeftijdscategorie</button>
            <button onclick="location.href='VragenOverzicht.php'">Vragen</button>
            <button onclick="location.href='VragenlijstOverzicht.php'">Vragenlijsten</button>
            <button onclick="location.href='index.php'">Terug naar home</button>
        </div><!--Closing DIV nav-bar-->
        <div id="body-container">
            <h3 id="Breadcrumb">Menu > Aandoening > Bewerken</h3>
            <h2 id="Content-Title">Aandoening bewerken</h2>
            <hr/>

            <?php
                    if (isset($_POST["edit"])) {

                            $aandoening = FinahDAO::HaalOp("Aandoening",$_POST["Id"]);
                        var_dump($aandoening["Omschrijving"]);
                        /*               foreach($_POST as $key => $value) {
                                           $pos = strpos($key , "edit_");
                                           if ($pos === 0){
                                               // do something with $value
                                           }
                                       }*/
                        ?>
                        <form method="POST">
                            <ul class="form-style">
                                <li><label class="control-label">Omschrijving</label></li>
                                <li><input class="form-control" type="text" name="omschrijving" value=<?php echo $aandoening["Omschrijving"]; ?>/></li>
                                <li><label class="control-label">Kies een pathologie</label></li>
                                <select class="form-control" name="pathologie[]" multiple="multiple">
                                    <!--                        Pathologieen ophalen-->
                                    <?php
                                        //$patologieen = new PathologieArray();
                                        //TODO omzetten naar Pathologie object
                                        $patologieen = FinahDAO::HaalOp("Pathologie");
                                        foreach ($patologieen as $item) {

                                            echo "<option value='".$item["Id"]."'>" . $item["Omschrijving"] . "</option>\r\n";
                                        }
                                        //var_dump($patologieen);
                                        //                        for ($a=0;$a<count($patologieen);$a++){
                                        //                            echo "<option>" . $patologieen->Omschrijving . "</option>\r\n";
                                        //                        }
                                    ?>

                                </select>

                                <li><input type="submit" value="Edit" class="createBtn" name="creeer"/></li>
                            </ul>
                        </form>
                    <?php
                    }elseif (isset($_POST["details"])){
                        ?>
                        <div class="Back">
                            <a href="aandoeningOverzicht.php">Terug naar overzicht</a>
                        </div>
                    <?php
                    };
            ?>
        </div><!--Closing DIV body containerr-->
    </div><!--Closing DIV innerwrapper-->
    <div id="page-footer">
        <p>&copy; Copyright 2015-2016. All Rights Reserved</p>
    </div>
</div><!--Closing DIV wrapper-->

</body>
</html>
