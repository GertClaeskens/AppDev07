<?php
    /**
     * Created by PhpStorm.
     * User: Gert
     * Date: 24/03/2015
     * Time: 15:56
     */
    require_once "SuperKlasseAandoeningPathologie.php";

    class Pathologie extends SuperKlasseAandoeningPathologie
    {

        public $Aandoeningen;

        public function __construct($id = null, $omschrijving = null, $aandoeningen = null)
        {
            parent::__construct($id, $omschrijving);
            $this->Aandoeningen = ($aandoeningen === null) ? [] : $aandoeningen;
        }

        public function kopieer(Pathologie $pat)
        {
            $this->setId($pat->getId());
            $this->setOmschrijving($pat->getOmschrijving());
            $this->setAandoeningen($pat->getAandoeningen());
        }

        public function getAandoeningen()
        {
            return $this->Aandoeningen;
        }

        public function setAandoeningen($Aandoeningen)
        {
            $this->Aandoeningen = $Aandoeningen;
        }

        public function voegAandoeningAanPathologieToe($aand)
        {
            array_push($this->Aandoeningen, $aand);
        }
        public function getId()
        {
            parent::getId();
        }

        public function setId($Id)
        {
            parent::setId($Id);
        }

        public function getOmschrijving()
        {
            parent::getOmschrijving();
        }

        public function setOmschrijving($Omschrijving)
        {
            parent::setOmschrijving($Omschrijving);
        }
    }