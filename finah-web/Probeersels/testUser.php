<?php
/**
 * Created by PhpStorm.
 * User: Gert
 * Date: 22/05/2015
 * Time: 13:02
 */
session_start();
    include_once '../Php/DAO/FinahDAO.php';

    var_dump(FinahDAO::HaalOp("api/Account/Rol",$username,$_SESSION["token"]));