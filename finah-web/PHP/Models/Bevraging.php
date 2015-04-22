<?php

    class Bevraging
    {
        private $Id;
        private $IsPatient;
        private $Antwoorden;

        public function __construct($id = null, $isPatient = null, $antwoorden = null)
        {
            $this->Id = $id;
            $this->IsPatient = $isPatient;
            $this->Antwoorden = $antwoorden;
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

        public function getAntwoorden()
        {
            return $this->Antwoorden;
        }

        public function setAntwoorden($antwoorden)
        {
            $this->Antwoorden = $antwoorden;
        }
    }
