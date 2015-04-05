<?php

    /**
     * Created by PhpStorm.
     * User: Gert
     * Date: 25/03/2015
     * Time: 22:02
     */
    class Antwoord
    {
        private $Id;
        private $Antword;

        public function __constructor__($id=null,$antword=null)
        {
            $this->Id=$id;
            $this->Antword=$antword;
        }
        //alternatieve manier voor getters en setters
        public function __get($property) {
            if (property_exists($this, $property)) {
                return $this->$property;
            }
            return null;
        }

        public function __set($property, $value) {
            if (property_exists($this, $property)) {
                $this->$property = $value;
            }

            return $this;
        }
    }