<?php

    /**
     * Created by PhpStorm.
     * User: Gert
     * Date: 24/03/2015
     * Time: 15:56
     */
    class Foto extends Media
    {
        public function __construct($id = null, $omschrijving = null, $pad = null)
        {
            parent::__construct($id, $omschrijving, $pad);
        }
    }