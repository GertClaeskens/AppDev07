<?php
/**
 * Created by PhpStorm.
 * User: Gert
 * Date: 24/03/2015
 * Time: 15:56
 */
    require_once "SuperKlasseAandoeningPathologie.php";

class Pathologie extends SuperKlasseAandoeningPathologie{

    public function __construct($id=null,$omschrijving=null){
        parent::__construct($id,$omschrijving);
    }
    public function kopieer(Pathologie $pat){
        $this->setId($pat->getId());
        $this->setOmschrijving($pat->getOmschrijving());
    }
}