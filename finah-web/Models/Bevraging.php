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
        private $Antwoorden;

        public function __construct($id=null,$leeftijdsCategorie=null,$informatie=null,$relatie=null,$aangemaaktDoor=null,$vragen=null,$isPatient=null,$antwoorden=null)
        {
            $this->Id=$id;
            $this->Informatie= $informatie;
            $this->Relatie=$relatie;
            $this->IsPatient=$isPatient;
            $this->Antwoorden = $antwoorden;

            $this->Aangevraagd = getdate(date("U"));
            $this->LeeftijdsCategorie = ($leeftijdsCategorie === null)?new LeeftijdsCategorie():$leeftijdsCategorie;
            $this->AangemaaktDoor = ($aangemaaktDoor === null)?new Account():$aangemaaktDoor;
            $this->Vragen = ($vragen===null)? new VraagArray():$vragen;
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

        public function getAntwoorden()
        {
            return $this->Antwoorden;
        }

        public function setAntwoorden($antwoorden)
        {
            $this->Antwoorden = $antwoorden;
        }


    }
