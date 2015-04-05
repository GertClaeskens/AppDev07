<?php
    // request list of contacts from Web API
    $json = file_get_contents('http://localhost:1695/Aandoening/Overzicht');
    // deserialize data from JSON
    $aandoening = json_decode($json);
    for ($a = 0; $a < count($aandoening); $a++) {
        echo $aandoening[$a]->Id . "\n";
        echo $aandoening[$a]->Omschrijving . "\n";
        for ($x = 0; $x < count($aandoening[$a]->Patologieen); $x++) {
            echo $aandoening[$a]->Patologieen[$x]->Id . "\n";
            echo $aandoening[$a]->Patologieen[$x]->Omschrijving . "\n";
        }
    }


?>