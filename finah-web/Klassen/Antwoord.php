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

        public function __constructor__()
        {

        }
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