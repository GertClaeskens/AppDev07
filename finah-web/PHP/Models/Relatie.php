<?php

    /**
     * Created by PhpStorm.
     * User: Gert
     * Date: 1/04/2015
     * Time: 21:46
     */
    class Relatie
    {
        private $Id;
        private $Naam;

        public function __construct($id = null, $naam = null)
        {
            $this->Id = $id;
            $this->Naam = $naam;
        }
    }