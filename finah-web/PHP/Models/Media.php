<?php

    /**
     * Created by PhpStorm.
     * User: Gert
     * Date: 24/03/2015
     * Time: 15:56
     */
    class Media
    {
        private $Id;
        private $Omschrijving;
        private $Pad;

        public function __construct($id = null, $omschrijving = null, $pad = null)
        {
            $this->Id = $id;
            $this->Omschrijving = $omschrijving;
            $this->Pad = $pad;
        }
    }