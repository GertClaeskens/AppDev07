<?php
/**
 * Created by PhpStorm.
 * User: Gert
 * Date: 22/04/2015
 * Time: 9:05
 */

class Onderzoek {
    private $Id;
    private $Aangevraagd;
    private $Informatie;
    private $Relatie;
    private $Vragen;
    private $AangemaaktDoor;
    private $Bevraging_Pat;
    private $Bevraging_Man;
    private $Aandoening;
    private $Pathologie;

    function __construct($Id= null, $Aangevraagd= null, $Informatie= null, $Relatie= null, $Vragen= null, $AangemaaktDoor= null, $Bevraging_Pat= null, $Bevraging_Man= null, $Aandoening= null, $Pathologie= null)
    {
        $this->Id = $Id;
        $this->Aangevraagd = ($Aangevraagd == null)? getdate(date("U")):$Aangevraagd;
        $this->Informatie = $Informatie;
        $this->Relatie = $Relatie;
        $this->Vragen = $Vragen;
        $this->AangemaaktDoor = $AangemaaktDoor;
        $this->Bevraging_Pat = $Bevraging_Pat;
        $this->Bevraging_Man = $Bevraging_Man;
        $this->Aandoening = $Aandoening;
        $this->Pathologie = $Pathologie;
    }




}