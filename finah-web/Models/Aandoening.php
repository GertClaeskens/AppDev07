<?php

    require_once "SuperklasseAandoeningPathologie.php";
    require_once "Pathologie.php";
    require_once "../CustomDataTypes/PathologieArray.php";

    /**
     * Created by PhpStorm.
     * User: Gert
     * Date: 24/03/2015
     * Time: 15:56
     */
//    http://stackoverflow.com/questions/7812198/array-of-objects-within-class-in-php
    class Aandoening extends SuperKlasseAandoeningPathologie
    {
        public $Patologieen;

        public function __construct($id=null,$omschrijving=null,$patologieen=null)
        {
            parent::__construct($id,$omschrijving);
            $this->Patologieen = ($patologieen === null)?[]:$patologieen;
        }

        public function kopieer(Aandoening $aand)
        {
            $this->setId($aand->getId());
            $this->setOmschrijving($aand->getOmschrijving());
            $this->setPatologieen($aand->getPatologieen());
        }

        public function getPatologieen()
        {
            return $this->Patologieen;
        }

        public function setPatologieen($Patologieen)
        {

            $this->Patologieen = $Patologieen;
        }

        public function voegPathologieAanLijstToe($value)
        {
            array_push($this->Patologieen, $value);
        }

    }

