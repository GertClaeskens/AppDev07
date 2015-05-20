<?php
/**
 * Created by PhpStorm.
 * User: Gert
 * Date: 20/05/2015
 * Time: 23:57
 */

include_once "../PHP/DAO/FinahDAO.php";
session_start();
    $username = "TestProfileAdmin";
    $password="S3cur3P@ssw0rd";

    $inlog = FinahDAO::GetToken($username,$password);
    $_SESSION["token"] = $inlog["access_token"];
    print_r($inlog);
    var_dump($inlog);