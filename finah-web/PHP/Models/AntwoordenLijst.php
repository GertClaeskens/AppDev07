<?php

    /**
     * Created by PhpStorm.
     * User: Gert
     * Date: 25/03/2015
     * Time: 22:59
     */
    class AntwoordenLijst
    {
        private $Id;
        private $Antwoorden;

        public function __construct($id = null, $antwoorden = null)
        {
            $this->Id = $id;
            $this->Antwoorden = ($antwoorden === null) ? new AntwoordArray() : $antwoorden;
        }
    }