<?php
/**
 * Created by PhpStorm.
 * User: Gert
 * Date: 26/03/2015
 * Time: 12:07
 */

class SharedDAO {

    public static function HaalOp($type,$id=null)
    {
        $url="http://localhost:1695/".$type."/";
        if ($id == null){
            $url .= "Overzicht";
        }else $url .= $id;
            // request list of contacts from Web API + deserialize data from JSON
        return json_decode(file_get_contents($url));
    }
}