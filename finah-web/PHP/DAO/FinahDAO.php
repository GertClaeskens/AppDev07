<?php

    /**
     * Created by PhpStorm.
     * User: Gert
     * Date: 26/03/2015
     * Time: 12:07
     */
    class FinahDAO
    {

        const URL = "http://localhost:1695/";
        //const URL = "http://finahbackend1920.azurewebsites.net/";

        public static function GetToken($username, $password)
        {
            try {
                $url = self::URL . "token";

                $data["username"] = $username;
                $data["password"] = $password;
                $data["grant_type"] = "password";
                $gegevens = 'username=' . $username . '&password=' . $password . '&grant_type=password';

                $options = [
                    'http' => [
                        'method' => 'POST',
                        'header' => 'Content-Type: application/x-www-form-urlencoded',
                        'content' => $gegevens,
                    ],
                ];
                $context = stream_context_create($options);
                $result = json_decode(@file_get_contents($url, false, $context), true);

                return $result;
            } catch (Exception $ex) {
                header("Location: /Index.php");
                return null;
            }
        }


        public static function HaalOp($type, $id = null, $token = null)
        {
            try {
                if ($token != null) {
                    //TODO Werken met try catch zodat er een mededeling wordt meegegeven wanneer de database niet bereikbaar is
                    $url = self::URL . $type . "/";
                    if ($id == null) {
                        $url .= "Overzicht";
                    } else $url .= $id;
                    $ch = curl_init();
                    curl_setopt($ch, CURLOPT_VERBOSE, 1);
                    curl_setopt($ch, CURLOPT_URL, $url);
                    curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
                    curl_setopt($ch, CURLOPT_HEADER, 1);
                    curl_setopt($ch, CURLOPT_HTTPHEADER, ['Content-Type: application/json', 'Authorization: Bearer ' . $token]);
                    // execute the request
                    $output = curl_exec($ch);
                    //var_dump($output);
                    if ($id == null) {
                        $pos = strpos($output, '[');
                        $rest = substr($output, $pos);
                        $result = json_decode($rest, true);
                    } else {
                        $pos = strpos($output, '{');
                        $rest = substr($output, $pos);
                        $result = json_decode($rest, true);
                    }
                    // close curl resource to free up system resources

                    //var_dump($result);
                    $info = curl_getinfo($ch);
                    curl_close($ch);
                    return $result;
                } else {
<<<<<<< HEAD
                    $pos = strpos($output, '{');
                    $rest = substr($output, $pos);
                    $result = json_decode($rest, true);
                }
                // close curl resource to free up system resources

                //var_dump($output);
                $info = curl_getinfo($ch);
                curl_close($ch);
                return $result;
            } else {
                $url = self::URL . $type . "/";
                if ($id == null) {
                    $url .= "Overzicht";
                } else $url .= $id;
=======
                    $url = self::URL . $type . "/";
                    if ($id == null) {
                        $url .= "Overzicht";
                    } else $url .= $id;
>>>>>>> 6aba907f3911c37996d4446a73b3b7e9a5d3607f

                    // request list of contacts from Web API + deserialize data from JSON
                    //var_dump($url);
                    $result = json_decode(file_get_contents($url), true);

                    //var_dump($result);
                    return $result;
                }
            } catch (Exception $ex) {
                header("Location: /Index.php");
                return null;
            }
            //TODO Werken met try catch zodat er een mededeling wordt meegegeven wanneer de database niet bereikbaar is

        }

<<<<<<< HEAD
        public static function HaalUsersOp($type, $id = null, $token = null)
        {
            if ($token != null) {
                //TODO Werken met try catch zodat er een mededeling wordt meegegeven wanneer de database niet bereikbaar is
                $url = self::URL . $type . "/";
                if ($id == null) {
                    $url .= "Overzicht";
                } else $url .= $id;
                $ch = curl_init();
                curl_setopt($ch, CURLOPT_VERBOSE, 1);
                curl_setopt($ch, CURLOPT_URL, $url);
                curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
                curl_setopt($ch, CURLOPT_HEADER, 1);
                curl_setopt($ch, CURLOPT_HTTPHEADER, ['Content-Type: application/json', 'Authorization: Bearer ' . $token]);
                // execute the request
                $output = curl_exec($ch);
                //var_dump($output);
                $pos = strpos($output, '[');
                $rest = substr($output, $pos);
                $result = json_decode($rest, true);
                // close curl resource to free up system resources

                //var_dump($output);
                $info = curl_getinfo($ch);
                curl_close($ch);
                return $result;
            }
            //TODO Werken met try catch zodat er een mededeling wordt meegegeven wanneer de database niet bereikbaar is

        }

        public static function SchrijfWeg($type, $data,$token=null)
=======
        public static function SchrijfWeg($type, $data, $token = null)
>>>>>>> 6aba907f3911c37996d4446a73b3b7e9a5d3607f
        {
            try {
                if ($token != null) {
                    $url = self::URL . $type . "/";
                    //var_dump($data);
                    $gegevens = json_encode($data);
                    //Initiate cURL.
                    $ch = curl_init();

                    //Tell cURL that we want to send a POST request.
                    curl_setopt($ch, CURLOPT_POST, 1);

                    //Attach our encoded JSON string to the POST fields.
                    curl_setopt($ch, CURLOPT_POSTFIELDS, $gegevens);

                    //Geen output naar het scherm
                    curl_setopt($ch, CURLOPT_VERBOSE, 1);
                    curl_setopt($ch, CURLOPT_URL, $url);
                    //curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
                    curl_setopt($ch, CURLOPT_HEADER, 1);
                    curl_setopt($ch, CURLOPT_HTTPHEADER, ['Content-Type: application/json', 'Authorization: Bearer ' . $token]);
                    //Set the content type to application/json
                    //curl_setopt($ch, CURLOPT_HTTPHEADER, ['Content-Type: application/json','Authorization: Bearer '.$token]);

                    //Execute the request
                    $result = curl_exec($ch);
                    //var_dump($result);
                    return $result;
                } else {
                    $url = self::URL . $type . "/";
                    //var_dump($data);
                    $gegevens = json_encode($data);
                    //Initiate cURL.
                    $ch = curl_init();

                    //Tell cURL that we want to send a POST request.
                    curl_setopt($ch, CURLOPT_POST, 1);

                    //Attach our encoded JSON string to the POST fields.
                    curl_setopt($ch, CURLOPT_POSTFIELDS, $gegevens);

                    //Geen output naar het scherm
                    curl_setopt($ch, CURLOPT_VERBOSE, 1);
                    curl_setopt($ch, CURLOPT_URL, $url);
                    curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
                    curl_setopt($ch, CURLOPT_HEADER, 1);
                    curl_setopt($ch, CURLOPT_HTTPHEADER, ['Content-Type: application/json']);

                    //Execute the request
                    $result = curl_exec($ch);
                    $info = curl_getinfo($ch);
                    curl_close($ch);
                    //var_dump($result);
                    return $result;
                }
            } catch (Exception $ex) {
                header("Location: /Index.php");
                return null;
            }
        }

        public static function PasAan($type, $id, $data, $token)
        {
            try {
                $url = self::URL . $type . "/" . $id;
                //$curl = curl_init($url . "/Contacts/{$recordId}");
                $data_json = json_encode($data);

                $ch = curl_init();
                curl_setopt($ch, CURLOPT_URL, $url);
                curl_setopt($ch, CURLOPT_HTTPHEADER, ['Content-Type: application/json', 'Content-Length: ' . strlen($data_json), 'Authorization: Bearer ' . $token]);
                curl_setopt($ch, CURLOPT_CUSTOMREQUEST, 'PUT');
                //Geen output naar het scherm
                curl_setopt($ch, CURLOPT_HEADER, 1);

                curl_setopt($ch, CURLOPT_VERBOSE, 1);
                curl_setopt($ch, CURLOPT_POSTFIELDS, $data_json);
                curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
                $response = curl_exec($ch);
                curl_close($ch);
                return $response;
            } catch (Exception $ex) {
                header("Location: /Index.php");
                return null;
            }
        }

        public static function Verwijder($type, $id, $token)
        {
            try {
                $url = self::URL . $type . "/" . $id;
                //echo $id;
                //$curl = curl_init($url . "/Contacts/{$recordId}");
                //$data_json = json_encode($data);
                $ch = curl_init();
                curl_setopt($ch, CURLOPT_URL, $url);
                curl_setopt($ch, CURLOPT_HEADER, 1);
                curl_setopt($ch, CURLOPT_HTTPHEADER, ['Content-Type: application/json', 'Authorization: Bearer ' . $token]);
                curl_setopt($ch, CURLOPT_CUSTOMREQUEST, "DELETE");
                //Geen output naar het scherm
                curl_setopt($ch, CURLOPT_VERBOSE, 1);
                //curl_setopt($ch, CURLOPT_POSTFIELDS,$data_json);
                curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);

                $response = curl_exec($ch);
                curl_close($ch);
                print_r($response);
                return $response;
            } catch (Exception $ex) {
                header("Location: /Index.php");
                return null;
            }
        }
    }