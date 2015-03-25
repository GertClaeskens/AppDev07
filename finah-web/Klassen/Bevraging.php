<?php
    class Bevraging
    {
        private $Id;
        private $Aangevraagd;
        private $LeeftijdsCategorie;
        private $Informatie;
        private $Relatie;
        private $AangemaaktDoor;
        private $Vragen;
        private $IsPatient;

        public function __construct()
        {
            $Aangevraagd = getdate(date("U"));
            $LeeftijdsCategorie = new LeeftijdsCategorie();
            $AangemaaktDoor = new Account();
            $Vragen = new VragenLijst;
        }

        public function getId()
        {
            return $this->Id;
        }

        public function setId($Id)
        {
            $this->Id = $Id;
        }

        public function getAangevraagd()
        {
            return $this->Aangevraagd;
        }

        public function setAangevraagd($Aangevraagd)
        {
            $this->Aangevraagd = $Aangevraagd;
        }

        public function getLeeftijdsCategorie()
        {
            return $this->LeeftijdsCategorie;
        }

        public function setLeeftijdsCategorie($LeeftijdsCategorie)
        {
            $this->LeeftijdsCategorie = $LeeftijdsCategorie;
        }

        public function getInformatie()
        {
            return $this->Informatie;
        }

        public function setInformatie($Informatie)
        {
            $this->Informatie = $Informatie;
        }

        public function getRelatie()
        {
            return $this->Relatie;
        }

        public function setRelatie($Relatie)
        {
            $this->Relatie = $Relatie;
        }

        public function getAangemaaktDoor()
        {
            return $this->AangemaaktDoor;
        }

        public function setAangemaaktDoor($AangemaaktDoor)
        {
            $this->AangemaaktDoor = $AangemaaktDoor;
        }

        public function getVragen()
        {
            return $this->Vragen;
        }

        public function setVragen($Vragen)
        {
            $this->Vragen = $Vragen;
        }

        public function getIsPatient()
        {
            return $this->IsPatient;
        }

        public function setIsPatient($IsPatient)
        {
            $this->IsPatient = $IsPatient;
        }



    }
