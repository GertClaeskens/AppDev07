<?php
/**
 * Created by PhpStorm.
 * User: Gert
 * Date: 24/03/2015
 * Time: 15:56
 */

class Aanvraag extends SuperKlasseAanvraagAccount{
    private $Status;

    public function __construct(){
        parent::__construct();
        $Status = new Status();
    }
}