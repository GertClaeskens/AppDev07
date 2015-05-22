<?php
/**
 * Created by PhpStorm.
 * User: Gert
 * Date: 22/05/2015
 * Time: 19:11
 */

session_start(); //to ensure you are using same session
session_destroy(); //destroy the session
header("location:index.php"); //to redirect back to "index.php" after logging out
exit();
?>