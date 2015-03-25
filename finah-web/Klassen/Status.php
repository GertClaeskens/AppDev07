<?php
/**
 * Created by PhpStorm.
 * User: Gert
 * Date: 26/03/2015
 * Time: 0:12
 */

class Status {
    private $Id;
    private $BeoordeeldDoor;
    private $BeoordeeldOp;

    public function __construct(){
        $BeoordeeldDoor = new Account();
    }
}