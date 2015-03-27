<?php
    /**
     * Created by PhpStorm.
     * User: Rafaël
     * Date: 27/03/2015
     * Time: 0:28
     */
    require "../DAO/FinahDAO.php";
?>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width"/>
    <title>Finah - Aandoening</title>
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
            <button onclick="location.href='PathologieOverzicht.php'">Pathologie</button>
            <button onclick="location.href='LeeftijdsCategorieOverzicht.php'">Leeftijdscategorie</button>
            <button onclick="location.href='VragenOverzicht.php'">Vragen</button>
            <button onclick="location.href='VragenlijstOverzicht.php'">Vragenlijsten</button>
            <button onclick="location.href='index.php'">Terug naar home</button>
        </div>
        <!--Closing DIV nav-bar-->
        <div id="body-container">
            <h3 id="Breadcrumb">Menu > Aandoening > Aanmaken</h3>

            <h2 id="Content-Title">Nieuwe aandoening</h2>
            <hr/>

            <form method="POST">
                <ul class="form-style"
                ">
                <li><label class="control-label">Kies een pathologie</label></li>
                <select class="form-control" name="pathologie">
                    <!--                        Pathologieen ophalen-->
                    echo "<option value=\"null\">Kies een pathologie</option>";
                    <?php
                        //$patologieen = new PathologieArray();
                        $patologieen = FinahDAO::HaalOp("Pathologie");

                        foreach($patologieen as $item){
                            $waarde= $item->Omschrijving;
                            echo "<option value='$value'>" . $item->Omschrijving . "</option>\r\n";
                        }
                        var_dump($patologieen);
//                        for ($a=0;$a<count($patologieen);$a++){
//                            echo "<option>" . $patologieen->Omschrijving . "</option>\r\n";
//                        }
                    ?>
<!--                    <option>Pathologie 1</option>
                    <option>Pathologie 2</option>
                    <option>Pathologie 3</option>
                    <option>Pathologie 4</option>-->
                </select>
                <li><label class="control-label">Omschrijving</label></li>
                <li><input class="form-control" type="text" name="omschrijving"/></li>
                <li><input type="submit" value="Create" class="createBtn"/></li>
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

</body>
</html>
