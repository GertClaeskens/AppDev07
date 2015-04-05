<?php
/**
 * Created by PhpStorm.
 * User: Gert
 * Date: 25/03/2015
 * Time: 23:18
 */

class SuperKlasseAanvraagAccount {
    private $Id;
    private $Naam;
    private $Voornaam;
    private $RijksRegisterNr;
    private $Adres;
    private $Telnr;
    private $Gsm;
    private $Login;
    private $Passwd;
    private $Email;
    private $GeheimeVraag;
    private $GeheimAntwoord;
    private $TypeAccount;

    function __construct($Id=null, $Naam=null, $Voornaam=null, $RijksRegisterNr=null, $Adres=null, $Telnr=null, $Gsm=null, $Login=null, $Passwd=null, $Email=null, $GeheimeVraag=null, $GeheimAntwoord=null, $TypeAccount=null)
    {
        $this->Id = $Id;
        $this->Naam = $Naam;
        $this->Voornaam = $Voornaam;
        $this->RijksRegisterNr = $RijksRegisterNr;
        $this->Adres = $Adres;
        $this->Telnr = $Telnr;
        $this->Gsm = $Gsm;
        $this->Login = $Login;
        $this->Passwd = $Passwd;
        $this->Email = $Email;
        $this->GeheimeVraag = $GeheimeVraag;
        $this->GeheimAntwoord = $GeheimAntwoord;
        $this->TypeAccount = $TypeAccount;
    }


}