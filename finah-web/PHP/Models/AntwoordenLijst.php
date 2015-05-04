<?php

    /**
     * Created by PhpStorm.
     * User: Gert
     * Date: 25/03/2015
     * Time: 22:59
     */
    require "../Finah.php";
    class AntwoordenLijst implements JsonSerializable
    {
        public $Id;
        public $Datum;
        public $LeeftijdsCategorie;
        public $Antwoorden;
        public $Bevraging;

        function __construct($Id=null, $Antwoorden=null, $LeeftijdsCategorie=null, $Bevraging=null)
        {
            $this->Id = $Id;
            $this->Datum = new DateTime('now');
            $this->Antwoorden = $Antwoorden;
            $this->LeeftijdsCategorie = $LeeftijdsCategorie;
            $this->Bevraging = $Bevraging;
        }
        public function jsonSerialize() {
            return [
                'Id' => $this->getId(),
                'Datum' => $this->Datum->format(DateTime::ISO8601),
                'Antwoorden' => Finah::arrayToCsv($this->getAntwoorden()),
                'LeeftijdsCategorie' => $this->getLeeftijdsCategorie(),
                'Bevraging' => $this->getBevraging()
            ];
        }
        public function getId()
        {
            return $this->Id;
        }

        public function setId($Id)
        {
            $this->Id = $Id;
        }

        public function getDatum()
        {
            return $this->Datum;
        }

        public function setDatum($Datum)
        {
            $this->Datum = $Datum;
        }

        public function getLeeftijdsCategorie()
        {
            return $this->LeeftijdsCategorie;
        }

        public function setLeeftijdsCategorie($LeeftijdsCategorie)
        {
            $this->LeeftijdsCategorie = $LeeftijdsCategorie;
        }

        public function getAntwoorden()
        {
            return $this->Antwoorden;
        }

        public function setAntwoorden($Antwoorden)
        {
            $this->Antwoorden = $Antwoorden;
        }

        public function getBevraging()
        {
            return $this->Bevraging;
        }

        public function setBevraging($Bevraging)
        {
            $this->Bevraging = $Bevraging;
        }
    }