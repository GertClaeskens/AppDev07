<?php

    /**
     * Created by PhpStorm.
     * User: Gert
     * Date: 25/03/2015
     * Time: 23:18
     */
    class SuperKlasseAanvraagAccount
    {
        public $Id;
        public $Naam;
        public $Voornaam;
        public $Adres;
        public $Postcd;
        public $Telnr;
        public $Login;
        public $Passwd;
        public $Email;
        public $TypeAcc;

        function __construct($Id = null, $Naam = null, $Voornaam = null, $Adres = null, $Postc=null,$Telnr = null, $Login = null, $Passwd = null, $Email = null, $TypeAccount = null)
        {
            $this->Id = $Id;
            $this->Naam = $Naam;
            $this->Voornaam = $Voornaam;
            $this->Adres = $Adres;
            $this->Postc = $Postc;
            $this->Telnr = $Telnr;
            $this->Login = $Login;
            $this->Passwd = $Passwd;
            $this->Email = $Email;
            $this->TypeAcc = $TypeAccount;
        }


    }