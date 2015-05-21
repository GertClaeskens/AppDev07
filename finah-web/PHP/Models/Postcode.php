<?php

    /**
     * Created by PhpStorm.
     * User: Gert
     * Date: 24/03/2015
     * Time: 15:57
     */
    class Postcode
    {
        public $Id;
        public $Postnr;
        public $Gemeente;

        public function getId()
        {
            return $this->Id;
        }

        public function setId($Id)
        {
            $this->Id = $Id;
        }

        public function getPostnr()
        {
            return $this->Postnr;
        }

        public function setPostnr($Postnr)
        {
            $this->Postnr = $Postnr;
        }

        public function getGemeente()
        {
            return $this->Gemeente;
        }

        public function setGemeente($Gemeente)
        {
            $this->Gemeente = $Gemeente;
        }


    }