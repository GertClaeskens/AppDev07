<?php

    /**
     * Created by PhpStorm.
     * User: Gert
     * Date: 25/03/2015
     * Time: 23:10
     */
    abstract class SuperKlasseAandoeningPathologie
    {
        public $Id;
        public $Omschrijving;

        public function __construct($id = null, $omschrijving = null)
        {
            $this->Id = $id;
            $this->Omschrijving = $omschrijving;
        }

        public function getId()
        {
            return $this->Id;
        }

        public function setId($Id)
        {
            $this->Id = $Id;
        }

        public function getOmschrijving()
        {
            return $this->Omschrijving;
        }

        public function setOmschrijving($Omschrijving)
        {
            $this->Omschrijving = $Omschrijving;
        }

    }

?>