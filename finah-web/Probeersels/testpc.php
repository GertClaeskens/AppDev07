<?php
    include_once '../Php/DAO/FinahDAO.php';
    $postcodes = FinahDAO::HaalOp("Postcode");
    foreach ($postcodes as $item) {
        echo "ID='" . $item["Id"] . " Gemeente = " . $item["Gemeente"] . "<br />";

    }
?>