<?php
    require_once "SuperklasseAanvraagAccount.php";

    /*
     * Created by PhpStorm.
     * User: Gert
     * Date: 24/03/2015
     * Time: 15:56
     */

    class Aanvraag extends SuperKlasseAanvraagAccount
    {
        private $Status;

        function __construct($Id = null, $Naam = null, $Voornaam = null, $RijksRegisterNr = null, $Adres = null, $Telnr = null, $Gsm = null, $Login = null, $Passwd = null, $Email = null, $GeheimeVraag = null, $GeheimAntwoord = null, $TypeAccount = null, $Status = null)
        {
            parent::__construct($Id, $Naam, $Voornaam, $RijksRegisterNr, $Adres, $Telnr, $Gsm, $Login, $Passwd, $Email, $GeheimeVraag, $GeheimAntwoord, $TypeAccount);
            $this->Status = $Status;
        }


    }