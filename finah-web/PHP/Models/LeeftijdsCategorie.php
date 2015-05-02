<?php

    /**
     * Created by PhpStorm.
     * User: Gert
     * Date: 24/03/2015
     * Time: 15:58
     */
    class LeeftijdsCategorie
    {
        public $Id;
        public $Van;
        public $Tot;

        public function __construct($id = null, $Van = null, $Tot = null)
        {
            $this->Id = $id;
            $this->Van = $Van;
            $this->Tot = $Tot;
        }

        public function getId()
        {
            return $this->Id;
        }

        public function setId($Id)
        {
            $this->Id = $Id;
        }

        public function getVan()
        {
            return $this->Van;
        }

        public function setVan($Van)
        {
            $this->Van = $Van;
        }

        public function getTot()
        {
            return $this->Tot;
        }

        public function setTot($Tot)
        {
            $this->Tot = $Tot;
        }
    }