<?php
    /**
     * Created by PhpStorm.
     * User: Gert
     * Date: 22/05/2015
     * Time: 13:44
     */
    include_once "../PHP/DAO/FinahDAO.php";
    session_start();

    $rapportid = "4cb31482bfe143f0a90e408e86d8432c";
    $onderzoek = FinahDAO::HaalOp("Onderzoek/Rapport", $rapportid);
    $idMan = "2a0aa4c1264f401081e6db09d9a092f6";
    $idPat = "6fe059997e0643af91688084e2648c55";
    $bevrPat = FinahDAO::HaalOp("Bevraging", $idPat, $_SESSION["token"]);
    $bevrMan = FinahDAO::HaalOp("Bevraging", $idMan, $_SESSION["token"]);
    $reeks1 = $bevrPat["Antwoorden"];
    $reeks2 = $bevrMan["Antwoorden"];
    $arr1 = explode(",", $reeks1);
    $arr2 = explode(",", $reeks2);
    $vragen = FinahDAO::HaalOp("Onderzoek", $idPat . "/Vragen");
    $rapport = [];
    $nogene = [];
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

                    $rapport[$vraag["Thema"]["Naam"]][$teller]= $vrRap;
                    $teller++;
        }

    }
?>
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
        $i=0;
        foreach (array_keys($rapport) as $key) {
            ?>
            <tr>
                <td><b><?php echo $key ?> </b></td>

                <td colspan="5"></td>
            </tr>
            <?php
            for ($j = 0; $j < count($rapport[$key]); $j++) {
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
                $i++;
            }
        }
    ?>
</table>