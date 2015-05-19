<?php

    /**
     * Created by PhpStorm.
     * User: Gert
     * Date: 26/03/2015
     * Time: 12:07
     */
    class FinahDAO
    {

        //const URL = "http://localhost:1695/";
        const URL = "http://finahbackend1920.azurewebsites.net/";
        public static function HaalOp($type, $id = null)
        {
            //TODO Werken met try catch zodat er een mededeling wordt meegegeven wanneer de database niet bereikbaar is
            $url = self::URL . $type . "/";
            if ($id == null) {
                $url .= "Overzicht";
            } else $url .= $id;
            // request list of contacts from Web API + deserialize data from JSON
            var_dump($url);
            $result = json_decode(file_get_contents($url), true);
            var_dump($result);
            return $result;
        }

        public static function SchrijfWeg($type, $data)
        {
            //TODO verder uitwerken
            //TODO misschien backend method overloaden met array van int om meerdere resultaten tegelijk binnen te halen
            $url = self::URL . $type . "/";
            //var_dump($data);
            $gegevens = json_encode($data);
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

        public static function PasAan($type, $id,$data)
        {
            $url = self::URL . $type . "/" .$id;
            //$curl = curl_init($url . "/Contacts/{$recordId}");
            $data_json = json_encode($data);

            $ch = curl_init();
            curl_setopt($ch, CURLOPT_URL, $url);
            curl_setopt($ch, CURLOPT_HTTPHEADER, ['Content-Type: application/json','Content-Length: ' . strlen($data_json)]);
            curl_setopt($ch, CURLOPT_CUSTOMREQUEST, 'PUT');
            //Geen output naar het scherm
            curl_setopt($ch, CURLOPT_VERBOSE, 0);
            curl_setopt($ch, CURLOPT_POSTFIELDS,$data_json);
            curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
            $response  = curl_exec($ch);
            curl_close($ch);
            return $response;
        }

        public static function Verwijder($type, $id)
        {
            $url = self::URL . $type . "/" .$id;
            //echo $id;
            //$curl = curl_init($url . "/Contacts/{$recordId}");
            //$data_json = json_encode($data);
            $ch = curl_init();
            curl_setopt($ch, CURLOPT_URL, $url);
            curl_setopt($ch, CURLOPT_CUSTOMREQUEST, "DELETE");
            //Geen output naar het scherm
            curl_setopt($ch, CURLOPT_VERBOSE, 0);
            //curl_setopt($ch, CURLOPT_POSTFIELDS,$data_json);
            curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
            $response  = curl_exec($ch);
            curl_close($ch);
            print_r($response);
            return $response;
        }
    }