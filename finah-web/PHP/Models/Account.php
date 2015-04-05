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
        private $EiD;

        public function __construct($Id = null, $Naam = null, $Voornaam = null, $RijksRegisterNr = null, $Adres = null, $Telnr = null, $Gsm = null, $Login = null, $Passwd = null, $Email = null, $GeheimeVraag = null, $GeheimAntwoord = null, $TypeAccount = null, $Eid = null)
    {
        parent::__construct($Id, $Naam, $Voornaam, $RijksRegisterNr, $Adres, $Telnr, $Gsm, $Login, $Passwd, $Email, $GeheimeVraag, $GeheimAntwoord, $TypeAccount);
        $this->Eid = $Eid;
    }
}