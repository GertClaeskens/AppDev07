<?php

    /**
     * Created by PhpStorm.
     * User: Gert
     * Date: 24/03/2015
     * Time: 15:57
     */
    class Vraag
    {
        public $Id;
        public $Vraagstelling;
        public $Afbeelding;
        public $Geluid;


        public function __construct($id=null,$Vraagstelling=null,$Afbeelding=null,$Geluid=null)
        {
            $this->Id=$id;
            $this->Vraagstelling=$Vraagstelling;
            $this->Afbeelding=$Afbeelding;
            $this->Geluid=$Geluid;
        }

        public function getId()
        {
            return $this->Id;
        }


        public function getVraagstelling()
        {
            return $this->Vraagstelling;
        }

        public function setVraagstelling($Vraagstelling)
        {
            $this->Vraagstelling = $Vraagstelling;
        }
        public function getAfbeelding()
        {
            return $this->Afbeelding;
        }

        public function setAfbeelding($Afbeelding)
        {
            $this->Afbeelding = $Afbeelding;
        }
        public function getGeluid()
        {
            return $this->Geluid;
        }

        public function setGeluid($Geluid)
        {
            $this->Geluid = $Geluid;
        }
    }