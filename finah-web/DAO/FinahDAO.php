<?php
/**
 * Created by PhpStorm.
 * User: Gert
 * Date: 26/03/2015
 * Time: 12:07
 */

class FinahDAO {

    public static function HaalOp($type,$id=null)
    {
        //TODO Werken met try catch zodat er een mededeling wordt meegegeven wanneer de database niet bereikbaar is
        $url="http://localhost:1695/".$type."/";
        if ($id == null){
            $url .= "Overzicht";
        }else $url .= $id;
            // request list of contacts from Web API + deserialize data from JSON
        //var_dump($url);
        $result= json_decode(file_get_contents($url));
        //var_dump($result);
        return $result;
    }
    public static function SchrijfWeg($type,$data){
        //TODO verder uitwerken
        $url="http://localhost:1695/".$type."/";
        $gegevens = json_encode($data);
        var_dump($gegevens);
    }
}