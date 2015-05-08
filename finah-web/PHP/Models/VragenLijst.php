<?php

    /**
     * Created by PhpStorm.
     * User: Gert
     * Date: 24/03/2015
     * Time: 15:57
     */
    class VragenLijst
    {
        public $Id;
        public $Vragen;
        public $Aandoe;
        //public $Titel;
        public $Omschrijving;

        public function __construct($id = null, $Vragen = null, $Aandoe = null, $Omschrijving=null)//$Titel = null)
        {
            $this->Id = $id;
//            $this->Titel = $Titel;
            $this->Omschrijving = $Omschrijving;
            $this->Vragen = $Vragen;
            $this->Aandoe = $Aandoe;

        }

        public function getId()
        {
            return $this->Id;
        }


        public function getVragen()
        {
            return $this->Vragen;
        }

        public function setVragen($Vragen)
        {
            $this->Vragen = $Vragen;
        }

        public function getAandoe()
        {
            return $this->Aandoe;
        }

        public function setAandoe($Aandoe)
        {
            $this->Aandoe = $Aandoe;
        }

        public function getOmschrijving()
        {
            return $this->Omschrijving;
        }

        public function setOmschrijving($Omschrijving)
        {
            $this->Omschrijving = $Omschrijving;
        }
/*        public function setTitel($Titel)
        {
            $this->Titel = $Titel;
        }
        public function getTitel()
        {
            return $this->Titel;
        }*/
    }