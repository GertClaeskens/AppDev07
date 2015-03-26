<?php
/**
 * Created by PhpStorm.
 * User: Gert
 * Date: 24/03/2015
 * Time: 15:56
 */

class PathologieDAO {
    public static function HaalLeeftijdsCategorieen()
    {

        // request list of contacts from Web API
        $json = file_get_contents('http://localhost:1695/LeeftijdsCategorie/Overzicht');
        // deserialize data from JSON
        return json_decode($json);

    }

    public static function HaalLeeftijdsCategorie($id)
    {
        $json = file_get_contents('http://localhost:1695/LeeftijdsCategorie/' . $id);
        // deserialize data from JSON
        return json_decode($json);

    }
}