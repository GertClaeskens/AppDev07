<?php

    class Bevraging
    {
        public $Id;
        public $IsPatient;

        public function __construct($id = null, $isPatient = null)
        {
            $this->Id = $id;
            $this->IsPatient = $isPatient;

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

    }
