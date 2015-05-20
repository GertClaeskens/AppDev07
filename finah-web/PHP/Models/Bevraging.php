<?php

    class Bevraging
    {
        public $Id;
        public $IsPatient;
        public $Datum;
        public $LeeftijdsCategorieId;
        public $Antwoorden;

        public function __construct($id = null, $isPatient = null,$Antwoorden=null, $LeeftijdsCategorieId=null)
        {
            $this->Id = $id;
            $this->IsPatient = $isPatient;
            //$this->Datum = new DateTime('now');
            $this->Antwoorden = $Antwoorden;
            $this->LeeftijdsCategorieId = $LeeftijdsCategorieId;
        }

        public function getId()
        {
            return $this->Id;
        }

        public function setId($Id)
        {
            $this->Id = $Id;
        }
        public function getIsPatient()
        {
            return $this->IsPatient;
        }

        public function setIsPatient($IsPatient)
        {
            $this->IsPatient = $IsPatient;
        }

        public function getDatum()
        {
            return $this->Datum;
        }

        public function setDatum($Datum)
        {
            $this->Datum = $Datum;
        }

        public function getLeeftijdsCategorieId()
        {
            return $this->LeeftijdsCategorieId;
        }

        public function setLeeftijdsCategorieId($LeeftijdsCategorieId)
        {
            $this->LeeftijdsCategorieId = $LeeftijdsCategorieId;
        }

        public function getAntwoorden()
        {
            return $this->Antwoorden;
        }

        public function setAntwoorden($Antwoorden)
        {
            $this->Antwoorden = $Antwoorden;
        }

    }
