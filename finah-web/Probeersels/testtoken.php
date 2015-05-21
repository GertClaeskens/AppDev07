<?php
/**
 * Created by PhpStorm.
 * User: Gert
 * Date: 20/05/2015
 * Time: 23:57
 */

include_once "../PHP/DAO/FinahDAO.php";
session_start();
    var_dump($_SESSION);
    $username = "TestProfileAdmin";
    $password="S3cur3P@ssw0rd";

    /*    $inlog = implode(',',FinahDAO::GetToken($username,$password));
        //$_SESSION["token"] = $inlog["access_token"];
        print_r($inlog);
        var_dump($inlog);*/
    const URL = "http://finahbackend1920.azurewebsites.net/";

    $url = URL . "/token";

    $data["username"] = $username;
    $data["password"] = $password;
    $data["grant_type"] = "password";
    $gegevens = 'username=' . $username . '&password=' . $password . '&grant_type=password';
    //$data = $username.":".$password;
    //var_dump($data);
    //$gegevens = json_encode($data);
    //Initiate cURL.
    $options = array(
        'http' => array(
            'method' => 'POST',
            'header' => 'Content-Type: application/x-www-form-url encoded',
            'content' => $gegevens,
        ),
    );
    $context = stream_context_create($options);
    $result = json_decode(@file_get_contents($url, false, $context), true);
    $resarr = (array)$result;
    echo "TEst<br/>";
    if (isset($resarr["access_token"])) {
        echo "ja";
    } else echo "nee";
