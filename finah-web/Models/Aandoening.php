<?php

    require_once "SuperklasseAandoeningPathologie.php";

    /**
     * Created by PhpStorm.
     * User: Gert
     * Date: 24/03/2015
     * Time: 15:56
     */
//    http://stackoverflow.com/questions/7812198/array-of-objects-within-class-in-php
    class Aandoening extends SuperKlasseAandoeningPathologie
    {
        private $patologieen;

        public function __construct(){
            $patologieen = new PathologieArray();
        }

//        public function getPatologieen()
//        {
//            return $this->patologieen;
//        }
//
//        public function setPatologieen($Patologieen)
//        {
//
//            $this->patologieen = $Patologieen;
//        }

        public function voegPathologieAanLijstToe($value){
            array_push($this->patologieen,$value);
        }

    }

