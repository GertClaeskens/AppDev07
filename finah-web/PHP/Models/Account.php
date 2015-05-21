<?php
    require_once "SuperKlasseAanvraagAccount.php";

    /**
     * Created by PhpStorm.
     * User: Gert
     * Date: 24/03/2015
     * Time: 15:57
     */
    class Account extends SuperKlasseAanvraagAccount
    {

        public function __construct($Id = null, $Naam = null, $Voornaam = null, $Adres = null, $Telnr = null, $Login = null, $Passwd = null, $Email = null, $TypeAcc = null)
        {
            parent::__construct($Id, $Naam, $Voornaam,$Adres, $Telnr, $Login, $Passwd, $Email, $TypeAcc);
        }
    }