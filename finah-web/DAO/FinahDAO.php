<?php

    /**
     * Created by PhpStorm.
     * User: Gert
     * Date: 26/03/2015
     * Time: 12:07
     */
    class FinahDAO
    {

        public static function HaalOp($type, $id = null)
        {
            //TODO Werken met try catch zodat er een mededeling wordt meegegeven wanneer de database niet bereikbaar is
            $url = "http://localhost:1695/" . $type . "/";
            if ($id == null) {
                $url .= "Overzicht";
            } else $url .= $id;
            // request list of contacts from Web API + deserialize data from JSON
            //var_dump($url);
            $result = json_decode(file_get_contents($url));
            //var_dump($result);
            return $result;
        }

        public static function SchrijfWeg($type, $data)
        {
            //TODO verder uitwerken
            //TODO misschien backend method overloaden met array van int om meerdere resultaten tegelijk binnen te halen
            $url = "http://localhost:1695/" . $type . "/";
            $gegevens = json_encode($data);
    //print_r($gegevens);
//            var_dump($gegevens);
            //Initiate cURL.
            $ch = curl_init($url);

            //Tell cURL that we want to send a POST request.
            curl_setopt($ch, CURLOPT_POST, 1);

            //Attach our encoded JSON string to the POST fields.
            curl_setopt($ch, CURLOPT_POSTFIELDS, $gegevens);

            //Geen output naar het scherm
            curl_setopt($ch, CURLOPT_VERBOSE, 0);

            //Set the content type to application/json
            curl_setopt($ch, CURLOPT_HTTPHEADER, ['Content-Type: application/json']);

            //Execute the request
            $result = curl_exec($ch);

            return $result;
        }
    }