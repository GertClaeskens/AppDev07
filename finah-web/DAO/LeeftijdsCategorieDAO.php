<?php
/**
 * Created by PhpStorm.
 * User: Gert
 * Date: 24/03/2015
 * Time: 15:58
 */

class LeeftijdsCategorieDAO {
    public static function HaalLeeftijdsCategorieen()
    {

        // request list of contacts from Web API
        $json = file_get_contents('http://localhost:1695/LeeftijdsCategorie/Overzicht');
        // deserialize data from JSON
        $leeftijdsCategorie = json_decode($json);
        return $leeftijdsCategorie;

    }

    public static function HaalLeeftijdsCategorie($id)
    {
        $json = file_get_contents('http://localhost:1695/LeeftijdsCategorie/' . $id);
        // deserialize data from JSON
        $result = json_decode($json);
        return $result;
    }
}