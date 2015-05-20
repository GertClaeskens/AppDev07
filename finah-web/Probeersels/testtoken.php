<?php
/**
 * Created by PhpStorm.
 * User: Gert
 * Date: 20/05/2015
 * Time: 23:57
 */

include_once "../PHP/DAO/FinahDAO.php";

    $username = "TestProfileAdmin";
    $password="S3cur3P@ssw0rd";

    FinahDAO::GetToken($username,$password);