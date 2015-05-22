<?php
    include_once '../Php/DAO/FinahDAO.php';
    include_once '../Php/Models/Bevraging.php';
    session_start();

    $bevraging_pat = [];

    $bevraging_man = new Bevraging();
    $bevraging_man->setIsPatient(false);
    $ids = FinahDAO::HaalOp("Bevraging", "UniekeIds");
    $bevraging_pat["Id"] = $ids[0];
    $bevraging_man->setId($ids[1]);
    var_dump($bevraging_pat);
?>