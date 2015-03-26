<?php

/**
 * Created by PhpStorm.
 * User: Gert
 * Date: 24/03/2015
 * Time: 15:56
 */
class AandoeningDAO
{
    public static function HaalAandoeningen()
    {

        // request list of contacts from Web API
        $json = file_get_contents('http://localhost:1695/Aandoening/Overzicht');
        // deserialize data from JSON
        $aandoening = json_decode($json);
        return $aandoening;
  /*      $aandoeningenLijst = [];
        for ($a = 0; $a < count($aandoening); $a++) {
            $aandoening[$a]->Id;
            $aandoening[$a]->Omschrijving;
            for ($x = 0; $x < count($aandoening[$a]->Patologieen); $x++) {
                $aandoening[$a]->Patologieen[$x]->Id;
                $aandoening[$a]->Patologieen[$x]->Omschrijving;
            }

        }*/
    }

    public static function HaalAandoening($id)
    {
        $json = file_get_contents('http://localhost:1695/Aandoening/' . $id);
        // deserialize data from JSON
        $result = json_decode($json);
 /*       echo $result->Id;
        echo $result->Omschrijving;
        for ($x = 0; $x < count($result->Patologieen); $x++) {
            echo $result->Patologieen[$x]->Id;
            echo $result->Patologieen[$x]->Omschrijving;
        }*/
        return $result;
    }
}