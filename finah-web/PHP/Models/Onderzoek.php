<?php
/**
 * Created by PhpStorm.
 * User: Gert
 * Date: 22/04/2015
 * Time: 9:05
 */

class Onderzoek {
    public $Id;
    public $Informatie;
    public $Relatie;
    public $Vragen;
    public $AangemaaktDoor;
    public $Bevraging_Pat;
    public $Bevraging_Man;
    public $Aandoening;
    public $Pathologie;
    public $Datum;
    public $Rapport;

    function __construct($Id= null, $Informatie= null, $Relatie= null, $Vragen= null, $AangemaaktDoor= null, $Bevraging_Pat= null, $Bevraging_Man= null, $Aandoening= null, $Pathologie= null,$Rapport=null)
    {
        $this->Id = $Id;
        $this->Informatie = $Informatie;
        $this->Relatie = $Relatie;
        $this->Vragen = $Vragen;
        $this->AangemaaktDoor = $AangemaaktDoor;
        $this->Bevraging_Pat = $Bevraging_Pat;
        $this->Bevraging_Man = $Bevraging_Man;
        $this->Aandoening = $Aandoening;
        $this->Pathologie = $Pathologie;
        $this->Datum = new DateTime('now');
        $this->Rapport = $Rapport;
    }
    public function jsonSerialize() {
        return [
            'Id' => $this->getId(),
            'Aandoening' => $this->Aandoening,
            'AandoeningId' => $this->Aandoening["Id"],
            'Bevraging_Pat' => $this->Bevraging_Pat,
            'Bevraging_Man' => $this->Bevraging_Man,
            'Bevraging_PatId' => $this->Bevraging_Pat["Id"],
            'Bevraging_ManId' => $this->Bevraging_Man["Id"],
            'Datum' => $this->Datum->format(DateTime::ISO8601),
            'Pathologie' => $this->Pathologie,
            'PathologieId' => $this->Pathologie["Id"],
            'Antwoorden' => Finah::arrayToCsv($this->getAntwoorden()),
            'Vragen' => $this->getVragen(),
            'Relatie' => $this->getRelatie(),
            'VragenId' => $this->Vragen["Id"],
            'RelatieId' => $this->Relatie["Id"]
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

    public function getInformatie()
    {
        return $this->Informatie;
    }

    public function setInformatie($Informatie)
    {
        $this->Informatie = $Informatie;
    }

    public function getRelatie()
    {
        return $this->Relatie;
    }

    public function setRelatie($Relatie)
    {
        $this->Relatie = $Relatie;
    }

    public function getVragen()
    {
        return $this->Vragen;
    }

    public function setVragen($Vragen)
    {
        $this->Vragen = $Vragen;
    }

    public function getAangemaaktDoor()
    {
        return $this->AangemaaktDoor;
    }

    public function setAangemaaktDoor($AangemaaktDoor)
    {
        $this->AangemaaktDoor = $AangemaaktDoor;
    }

    public function getBevragingPat()
    {
        return $this->Bevraging_Pat;
    }

    public function setBevragingPat($Bevraging_Pat)
    {
        $this->Bevraging_Pat = $Bevraging_Pat;
    }

    public function getBevragingMan()
    {
        return $this->Bevraging_Man;
    }

    public function setBevragingMan($Bevraging_Man)
    {
        $this->Bevraging_Man = $Bevraging_Man;
    }

    public function getAandoening()
    {
        return $this->Aandoening;
    }

    public function setAandoening($Aandoening)
    {
        $this->Aandoening = $Aandoening;
    }

    public function getPathologie()
    {
        return $this->Pathologie;
    }

    public function setPathologie($Pathologie)
    {
        $this->Pathologie = $Pathologie;
    }

    public function getDatum()
    {
        return $this->Datum;
    }

    public function setDatum($Datum)
    {
        $this->Datum = $Datum;
    }

    public function getRapport()
    {
        return $this->Rapport;
    }

    public function setRapport($Rapport)
    {
        $this->Rapport = $Rapport;
    }




}