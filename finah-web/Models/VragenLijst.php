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

        public function __construct($id=null,$Vragen=null,$Aandoe=null)
        {
            $this->Id=$id;
            $this->Vragen=$Vragen;
            $this->Aandoe=$Aandoe;

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
    }