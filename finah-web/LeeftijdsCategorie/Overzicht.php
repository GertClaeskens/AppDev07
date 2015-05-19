<?php
    require_once "../PHP/DAO/FinahDAO.php";
    require_once "../PHP/Models/LeeftijdsCategorie.php";
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>FINAH - Leeftijdscategorie</title>
    <link rel="stylesheet" type="text/css" href="../Css/Stylesheet.css"/>
    <link rel="stylesheet" type="text/css" href="../Css/bootstrap.css"/>
    <script src="../js/finah.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
 <!--   <script> // poging tot id doorgeven aan modal. Lukt wanneer id manueel is ingegeven maar niet met item[id]

        $('#deleteModal').on('show.bs.modal', function (e) {
            alert("test");
            var $modal = $(this),
                ed = e.relatedTarget.id;
            alert(ed);
            $("#deleteBtn").attr("value", ed);
            $("#modalForm").submit();

        });

        $(function () {
            $('button[name = "verwijderBtn"]').click(function (e) {
                e.preventDefault();
                alert('test');
                //eid = $(this).attr('value'); // This will give the ID of the button clicked.
                var eid = $(this).data('waarde');
                $('#cn').html(eid);
                $("#deleteBtn").attr("value", eid);
                $("#modalForm").submit();
            });

            /*
             $("#verwijderBtn").click(function () {
             alert("hlp");
             e.preventDefault();
             var eid = $(this).data('waarde');
             $('#cn').html(eid);
             $("#deleteBtn").attr("value", eid);
             $('#waarden').html('<input type="hidden" name="eid" value="' + eid + '" />');
             $("#modalForm").submit();
             });
             }*/
        }
    </script>-->
</head>
<body>
<div id="dialogoverlay"></div>
<div id="dialogbox">
    <div>
        <div id="dialogboxhead"></div>
        <div id="dialogboxbody"></div>
        <div id="dialogboxfoot"></div>
    </div>
</div>
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="navbar-header pull-left">

        <a href="#menu-toggle" id="menu-toggle" class="btn-toggle">
            <span id="side-toggle" class="glyphicon glyphicon-option-horizontal"></span>
        </a>
        <a class="navbar-brand header" href="#"> Finah</a>
    </div>
    <div class="dropdown navbar-header pull-right nav-right">
        <span class="img-circle"><img src="../Images/blank-avatar.png"/></span><!--TODO  PHP if'ke maken voor als er een avatar/profiel foto beschikbaar is in database of niet ( dan blank-avatar gebruiken) -->
        <a class="btn dropdown-toggle pull-left" type="button" id="menu1" data-toggle="dropdown">Rafaël.Sarrechia
            <span class="caret"></span>
        </a>
        <ul class="dropdown-menu " role="menu" aria-labelledby="menu1">
            <li role="presentation">
                <a role="menuitem" tabindex="0" href="../Account/Edit.php">
                    <span class="glyphicon glyphicon-user"></span> &nbsp Mijn account
                </a>
            </li>
            <li role="presentation" class="divider">
            </li>
            <li role="presentation">
                <a role="menuitem" tabindex="-1" href="#">
                    <span class="glyphicon glyphicon-log-out"></span> &nbsp Uitloggen
                </a>
            </li>
        </ul>
    </div>
</nav>
<div id="wrapper">
    <!-- Sidebar -->
    <div id="sidebar-wrapper">
        <ul class="sidebar-nav">
            <br/>
            <br/>
            <li class="sidebar-brand">
                <h4>
                    MENU
                </h4>
            </li>
            <li>
                <a href="../index.php"> Home </a>
            </li>
            <li>
                <a href="../Bevraging/Overzicht.php"> Bevraging</a>
            </li>
            <br/>
            <li class="sidebar-brand">
                <h4>
                    BEHEER
                </h4>
            </li>
            <li>
                <a href="../AccountAanvraag/Overzicht.php">Aanvragen</a>
            </li>
            <li>
                <a href="../Aandoening/Overzicht.php"> Aandoening </a>
            </li>
            <li>
                <a href="../Pathologie/Overzicht.php"> Pathologie</a>
            </li>
            <li>
                <a href="Overzicht.php"> Leeftijdscategorie</a>
            </li>
            <li>
                <a href="../Vragen/Overzicht.php"> Vragen</a>
            </li>
            <li>
                <a href="../VragenLijst/Overzicht.php"> Vragenlijsten</a>
            </li>
            <li>
                <a href="../Thema/Overzicht.php"> Thema's</a>
            </li>
        </ul>
    </div>
    <div id="page-content-wrapper">
        <div class="breadcrumb">
            <a href="../index.php"><span class="glyphicon glyphicon-home"> </a></span> <span class="breadcrumb-font"> &nbsp/ Home / Leeftijdscategorie </span>
        </div>
        <div class="container-fluid">
            <div class="row">
                <?php
                    if (isset($_POST["delete"])) {
                        $id = $_POST["delete"];
                        echo $_POST['eid'];
                        print_r($_POST);
                        $LeeftijdsCat = FinahDAO::HaalOp("LeeftijdsCategorie", $id);
                        if (FinahDAO::Verwijder("LeeftijdsCategorie", $id)) {
                        }
                    }
                ?>
                <div class="col-lg-12 col-md-12 col-sm-12">
                    <h1>Overzicht</h1>

                    <form action="CreeerEdit.php" method="post">
                        <button class="btn btn-primary createbtn " type="submit" name="creeer">
                            Maak een nieuwe leeftijdscategorie aan
                        </button>

                        <table class="table table-bordered table-striped" id="overzicht">
                            <thead>
                            <tr>
                                <th>
                                    Van
                                </th>
                                <th>
                                    Tot
                                </th>
                                <th>Actie</th>
                            </thead>
                            <tbody>
                            <?php
                                $leeftijdCategorieLijst = FinahDAO::HaalOp("LeeftijdsCategorie");
                                foreach ($leeftijdCategorieLijst as $item) {
                                    $teller=0;
                                echo "<tr>"?>
                            <td class='col-sm-5 col-md-5 col-lg-5 text-center'><?php echo $item["Van"] ?></td>
                            <td class='col-sm-5 col-md-5 col-lg-5 text-center'><?php echo $item["Tot"] ?></td>
                            <td class='action-column col-sm-1 col-md-2 col-lg-2'>
                                <button type='submit' name='details' id='<?php echo "Dt".$item["Id"] ?>'
                                        class='btn btn-primary' value='<?php echo $item["Id"] ?>'>
                                    <span class='glyphicon glyphicon-list-alt'></span>&nbsp;
                                </button>
                                <button type='submit' name='bewerk' id='<?php echo "Bw". $item["Id"] ?>'
                                        class='btn btn-primary' value="<?php echo $item["Id"] ?>">
                                    <span class='glyphicon glyphicon-pencil'></span>&nbsp;
                                </button>
                                <?php $verw = $item["Id"]; ?>
                                <button type='button' title='Verwijderen' id='<?php echo "Del". $item["Id"] ?>'
                                        name='verwijder<?php echo $teller;?>' value="<?php echo $item["Id"] ?>"
                                        class='delBtn btn btn-primary'
                                        onclick="Confirm.render('Verwijder LeeftijdsCategorie?','delete_lft',<?php echo $verw ?>,'LeeftijdsCategorie',this)">
                                    <!--  TODO item id doorgeven aan modal ?? -->
                                    <span class='glyphicon glyphicon-remove'></span>&nbsp;
                                </button>
                                <!-- TODO DeleteButton alert window voor bevestiging (JavaScript modal bootstrap hebben we gezien bij .net) -->
                            </td>
                            </tr>
                            <?php $teller+=1;}?>
                            </tbody>
                        </table>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<!--<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel"-->
<!--     aria-hidden="true">-->
<!--    <div class="modal-dialog modal-md">-->
<!--        <div class="modal-content">-->
<!--            <div class="modal-header">-->
<!--                <h4 class="modal-title" id="myModalLabel">Verwijder bevestiging</h4>-->
<!--            </div>-->
<!--            <div class="modal-body">-->
<!--                <p>Weet u zeker dat u deze leeftijdscategorie (<span id='cn'></span>) wilt verwijderen?</p>-->
<!--            </div>-->
<!--            <div class="modal-footer">-->
<!--                <form id="modalForm" action="#" method="post">-->
<!--                    <div id="waarden"></div>-->
<!--                    <button type="button" class="btn btn-default" data-dismiss="modal">Annuleren</button>-->
<!--                    <button type="submit" name="delete" id="deleteBtn" class="btn btn-primary">Toepassen</button>-->
<!--                </form>-->
<!--            </div>-->
<!--        </div>-->
<!--    </div>-->
<!--</div>-->
<script>
    $("#menu-toggle").click(function (e) {
        e.preventDefault();
        $("#wrapper").toggleClass("toggled");
        if ($("#side-toggle").hasClass("glyphicon-option-vertical")) {
            $("#side-toggle").removeClass("glyphicon-option-vertical");
            $("#side-toggle").addClass("glyphicon-option-horizontal");
        } else {
            $("#side-toggle").removeClass("glyphicon-option-horizontal");
            $("#side-toggle").addClass("glyphicon-option-vertical");
        }
    });
</script>

</body>
</html>

