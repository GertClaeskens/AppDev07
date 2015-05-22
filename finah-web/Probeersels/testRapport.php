<?php
    /**
     * Created by PhpStorm.
     * User: Gert
     * Date: 22/05/2015
     * Time: 13:44
     */
    include_once "../PHP/DAO/FinahDAO.php";
    session_start();

    //var_dump($_SESSION);
    /*    $reeks1 = "1,2,3,4,5,6,5,4,3,2";
        $reeks2 = "1,2,3,4,5,6,0,0,0,0";

        $arr1 = explode(",", $reeks1);
        $arr2 = explode(",", $reeks2);
        $bom1 = in_array(0, $arr1);
        $bom2 = in_array(0, $arr2);

        //geef index weer en anders Alles Ingevuld.
        if (!$bom1) {
            echo "Alles ingevuld. <br/>";
        } else {
            echo array_search(0, $arr1) . "<br />";
        }
        if (!$bom2) {
            echo "Alles ingevuld. <br/>";
        } else {
            echo array_search(0, $arr2) . "<br />";
        }*/
    $onderzoek = FinahDAO::HaalOp("Onderzoek", 2);
    //var_dump(FinahDAO::HaalOp("Onderzoek", 2, $_SESSION["token"]));
    //var_dump($onderzoek);
    $idPat = "2a0aa4c1264f401081e6db09d9a092f6";
    $idMan = "6fe059997e0643af91688084e2648c55";
    //$bevrPat = FinahDAO::HaalOp("Bevraging", $idPat, $_SESSION["token"]);
    //$bevrMan = FinahDAO::HaalOp("Bevraging", $idMan, $_SESSION["token"]);
    //$reeks1 = $bevrPat["Antwoorden"];
    //$reeks2 = $bevrMan["Antwoorden"];
    $reeks1 = "2,3,4,7,6,4,3,7,4,1,4,5,3,7,3,2,3,4,2,3,1,4,7,3,5,4,5,4,3,4,3,4,6,5,6,4,2,2,1,3,5,4,2,4,3,2,4,4,5,3,2,3";
    $reeks2 = "6,7,5,2,3,4,6,1,2,7,5,6,3,2,3,6,7,2,2,7,2,7,5,2,6,4,2,2,2,2,6,3,7,8,6,8,2,2,2,6,7,2,4,8,6,5,3,4,7,3,7,2";
    $arr1 = explode(",", $reeks1);
    $arr2 = explode(",", $reeks2);
    //var_dump($onderzoek["Vragen"]);
    //$vragen = FinahDAO::HaalOp("Vragenlijst", $onderzoek["Vragen"], $_SESSION["token"]);
    $vragen = FinahDAO::HaalOp("Onderzoek", $idPat . "/Vragen");
    //var_dump($vragen[0]);
    //var_dump($arr1[0]);
    $rapport = [];
$teller=0;
    for ($i = 0; $i < count($vragen[0]); $i++) {
        $vraag = $vragen[0][$i];
        $vrRap["hinderPat"] = 0;
        $vrRap["hinderMan"] = 0;
        $vrRap["hulp"] = 0;

        if ($arr1[$i] > 2 || $arr2[$i] > 2) { //er is hinder
            //vraag al bewaren
            $vrRap["Vraag"] = $vraag["VraagStelling"];
            $vrRap["hinderPat"] = 0;
            $vrRap["hinderMan"] = 0;
            $vrRap["hulp"] = 0;

            //Patient
            if ($arr1[$i] == 3) { //hinder voor de patient geen hulp
                $vrRap["hinderPat"] = 1;
            }
            if ($arr1[$i] == 4) { //hinder voor de mantel geen hulp
                $vrRap["hinderMan"] = 1;
            }
            if ($arr1[$i] == 5) { //hinder voor beide geen hulp
                $vrRap["hinderPat"] = 1;
                $vrRap["hinderMan"] = 1;
            }
            if ($arr1[$i] == 6) { //hinder voor de patient hulp
                $vrRap["hinderPat"] = 1;
                $vrRap["hulp"] = 1;
            }
            if ($arr1[$i] == 7) { //hinder voor de patient hulp
                $vrRap["hinderMan"] = 1;
                $vrRap["hulp"] = 1;
            }
            if ($arr1[$i] == 8) { //hinder voor de patient hulp
                $vrRap["hinderPat"] = 1;
                $vrRap["hinderMan"] = 1;
                $vrRap["hulp"] = 1;
            }
            //Mantelzorger
            if ($arr2[$i] == 3) { //hinder voor de patient geen hulp
                $vrRap["hinderPat"] += 2;
            }
            if ($arr2[$i] == 4) { //hinder voor de mantel geen hulp
                $vrRap["hinderMan"] += 2;
            }
            if ($arr2[$i] == 5) { //hinder voor beide geen hulp
                $vrRap["hinderPat"] += 2;
                $vrRap["hinderMan"] += 2;
            }
            if ($arr2[$i] == 6) { //hinder voor de patient hulp
                $vrRap["hinderPat"] += 2;
                $vrRap["hulp"] += 2;
            }
            if ($arr2[$i] == 7) { //hinder voor de patient hulp
                $vrRap["hinderMan"] += 2;
                $vrRap["hulp"] += 2;
            }
            if ($arr2[$i] == 8) { //hinder voor de patient hulp
                $vrRap["hinderPat"] += 2;
                $vrRap["hinderMan"] += 2;
                $vrRap["hulp"] += 2;
            }

            if (!array_key_exists($rapport, $vraag["Thema"]["Naam"])) {
                $rapport[$vraag["Thema"]["Naam"]] = [];
                if (!($vrRap["hinderPat"] == 0 && $vrRap["hinderMan"] == 0 && $vrRap["hulp"] == 0)) {
                    var_dump($vrRap);
                    $teller++;
                    array_push($rapport[$vraag["Thema"]["Naam"]], $vrRap);
                }
                //echo $vraag["Thema"]["Naam"];
            }
        }

    }
    echo "<br/>".$teller."<br/>";
    var_dump($rapport); ?>
<table border="1">
    <tr>
        <td>Vraag</td>
        <td colspan="2">Hinder voor Patient</td>
        <td colspan="2">Hinder voor Mantelzorger</td>
        <td>Hulpvraag</td>
    </tr>
    <tr>
        <td></td>
        <td>Patient</td>
        <td>Mantelzorger</td>
        <td>Patient</td>
        <td>Mantelzorger</td>
        <td>Gesteld door</td>
    </tr
    <?php
        foreach (array_keys($rapport) as $key) {

            ?>
            <tr>
                <td><b><?php echo $key ?> </b></td>

                <td colspan="5"></td>
            </tr>
            <?php for ($i = 0; $i < count($rapport[$key]); $i++) {
                echo "<tr><td>" . $rapport[$key][$i]["Vraag"] . "</td>";
                switch ($rapport[$key][$i]["hinderPat"]) {
                    case 0:
                        echo "<td></td><td></td>";
                        break;
                    case 1:
                        echo "<td>X</td><td></td>";
                        break;
                    case 2:
                        echo "<td></td><td>X</td>";
                        break;

                    case 3:
                        echo "<td>X</td><td>X</td>";
                        break;
                }
                switch ($rapport[$key][$i]["hinderMan"]) {
                    case 0:
                        echo "<td></td><td></td>";
                        break;
                    case 1:
                        echo "<td>X</td><td></td>";
                        break;
                    case 2:
                        echo "<td></td><td>X</td>";
                        break;

                    case 3:
                        echo "<td>X</td><td>X</td>";
                        break;
                }
                switch ($rapport[$key][$i]["hulp"]) {
                    case 0:
                        echo "<td>Nee</td>";
                        break;
                    case 1:
                        echo "<td>Patient</td>";
                        break;
                    case 2:
                        echo "<td>Mantelzorger</td>";
                        break;

                    case 3:
                        echo "<td>Beiden</td>";
                        break;
                }
                echo "</tr>";
                //echo ($rapport[$key][$i]["hinderPat"] > 1) ? "<td></td><td></td>" : "<td></td><td></td>";
            }
        }
    ?>
</table>