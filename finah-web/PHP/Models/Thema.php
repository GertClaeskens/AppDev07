<?php

    class Thema
    {
        public $Id;
        public $Naam;

        public function __construct($id = null, $naam = null)
        {
            $this->Id = $id;
            $this->Naam = $naam;
        }

        public function getId()
        {
            return $this->Id;
        }
        public function getNaam()
        {
            return $this->Naam;
        }
        public function setNaam($Naam)
        {
            $this->Naam = $Naam;

        }
    }