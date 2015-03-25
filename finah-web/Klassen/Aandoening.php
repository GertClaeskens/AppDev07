<?php

    /**
     * Created by PhpStorm.
     * User: Gert
     * Date: 24/03/2015
     * Time: 15:56
     */
//    http://stackoverflow.com/questions/7812198/array-of-objects-within-class-in-php
    class Aandoening extends SuperKlasseAandoeningPathologie
    {
        private $Patologieen;

        public function __construct(){
            $Pathologieen = [];
        }

        public function getPatologieen()
        {
            return $this->Patologieen;
        }

        public function setPatologieen($Patologieen)
        {
            $this->Patologieen = $Patologieen;
        }

        public function voegPathologieAanLijstToe($value){
            array_push($this->Patologieen,$value);
        }

    }

