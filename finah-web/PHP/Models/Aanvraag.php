<?php
    require_once "SuperKlasseAanvraagAccount.php";

    /*
     * Created by PhpStorm.
     * User: Gert
     * Date: 24/03/2015
     * Time: 15:56
     */

    class Aanvraag extends SuperKlasseAanvraagAccount
    {
        private $Status;

        function __construct($Id = null, $Naam = null, $Voornaam = null, $Adres = null, $Postc=null, $Telnr = null, $Login = null, $Passwd = null, $Email = null, $GeheimeVraag = null, $GeheimAntwoord = null, $TypeAcc = null, $Status = null)
        {
            parent::__construct($Id, $Naam, $Voornaam, $Adres, $Postc, $Telnr, $Login, $Passwd, $Email, $TypeAcc);
            $this->Status = $Status;
        }

        public function getId()
        {
            return $this->Id;
        }

        public function setId($Id)
        {
            $this->Id = $Id;
        }

        public function getNaam()
        {
            return $this->Naam;
        }

        public function setNaam($Naam)
        {
            $this->Naam = $Naam;
        }

        public function getVoornaam()
        {
            return $this->Voornaam;
        }

        public function setVoornaam($Voornaam)
        {
            $this->Voornaam = $Voornaam;
        }

        public function getAdres()
        {
            return $this->Adres;
        }

        public function setAdres($Adres)
        {
            $this->Adres = $Adres;
        }

        public function getTelnr()
        {
            return $this->Telnr;
        }

        public function setTelnr($Telnr)
        {
            $this->Telnr = $Telnr;
        }

        public function getLogin()
        {
            return $this->Login;
        }

        public function setLogin($Login)
        {
            $this->Login = $Login;
        }

        public function getPasswd()
        {
            return $this->Passwd;
        }

        public function setPasswd($Passwd)
        {
            $this->Passwd = $Passwd;
        }

        public function getEmail()
        {
            return $this->Email;
        }

        public function setEmail($Email)
        {
            $this->Email = $Email;
        }

        public function getTypeAcc()
        {
            return $this->TypeAcc;
        }

        public function setTypeAcc($TypeAccount)
        {
            $this->TypeAcc = $TypeAccount;
        }

        public function getPostcd()
        {
            return $this->Postcd;
        }

        public function setPostc($Postcd)
        {
            $this->Postcd = $Postcd;
        }


    }