/**
 * Created by Gert on 22/04/2015.
 */
/*$('#aandoening').change(function(e){
 var id= e.target.value;
 var urls = "http://localhost:1695/Aandoening/" + id + "/Pathologie";
 $.ajax({

 url: urls,
 success: function(data) {
 var sHtml = '';
 for(var idx = 0;idx < data.length;++idx){
 sHtml+= '<option value="'+ data[idx].Id +'">' + data[idx].Omschrijving +'</option>';
 }
 $('#pathologie').empty().append(sHtml);
 }
 });

 });*/

function deleteRow(r) {
    console.log(r.name);
    var id = r.name;
    var i = id.replace("verwijder", "");
    console.log(i);
    document.getElementById("overzicht").deleteRow(i);
}
function CustomAlert() {
    this.render = function (dialog) {
        var winW = window.innerWidth;
        var winH = window.innerHeight;
        var dialogoverlay = document.getElementById('dialogoverlay');
        var dialogbox = document.getElementById('dialogbox');
        dialogoverlay.style.display = "block";
        dialogoverlay.style.height = winH + "px";
        dialogbox.style.left = (winW / 2) - (550 * .5) + "px";
        dialogbox.style.top = "100px";
        dialogbox.style.display = "block";
        document.getElementById('dialogboxhead').innerHTML = "Acknowledge This Message";
        document.getElementById('dialogboxbody').innerHTML = dialog;
        document.getElementById('dialogboxfoot').innerHTML = '<button class="btn btn-primary" onclick="Alert.ok()">OK</button>';
    };
    this.ok = function () {
        document.getElementById('dialogbox').style.display = "none";
        document.getElementById('dialogoverlay').style.display = "none";
    }
}
var Alert = new CustomAlert();
function deletePost(id, type,tk,r) {
    //var db_id = id.replace("post_", "");
    // Run Ajax request here to delete post from database
    $.ajax({
        url: 'http://finahbackend1920.azurewebsites.net/' + type + '/' + id,
        //url: 'http://localhost:1695/' + type + '/' + id,
        type: 'DELETE',
        beforeSend: function (req) {
            req.setRequestHeader('Authorization','Bearer ' + tk);
        },
        contentType: 'application/json',
        success: function () {
            document.getElementById('mededeling').innerHTML = "<p class='gelukt'>De "+ type + " werd succesvol verwijderd.</p>";
            window.location = url + type + '/overzicht.php';
            return true;
            // Do something with the result
        },
        error: function (){

            document.getElementById('mededeling').innerHTML = "<p class='mislukt'>De " + type + " kon niet verwijderd worden. Deze " + type + " is nog gelinkt aan andere objecten";
            return false;
        }
    });

    return false;
    //document.body.removeChild(document.getElementById('rij' + id));
}
function CustomConfirm() {
    this.render = function (dialog, op, id, type, r,tk) {
        var winW = window.innerWidth;
        var winH = window.innerHeight;
        var dialogoverlay = document.getElementById('dialogoverlay');
        var dialogbox = document.getElementById('dialogbox');
        dialogoverlay.style.display = "block";
        dialogoverlay.style.height = winH + "px";
        dialogbox.style.left = (winW / 2) - (550 * .5) + "px";
        dialogbox.style.top = "100px";
        dialogbox.style.display = "block";
        document.getElementById('dialogboxhead').innerHTML = "Bevestig dit verzoek";
        document.getElementById('dialogboxbody').innerHTML = dialog;
        document.getElementById('dialogboxfoot').innerHTML = '<button class="btn btn-primary" onclick="Confirm.yes(\'' + op + '\',\'' + id + '\',\'' + type + '\',\'' + r + '\',\'' + tk + '\')">Yes'+'</button> <button class="btn btn-primary" onclick="Confirm.no()">No</button>';
    };
    this.no = function () {
        document.getElementById('dialogbox').style.display = "none";
        document.getElementById('dialogoverlay').style.display = "none";
    };
    this.yes = function (op, id, type, r,tk) {
        if (op == "delete_lft") {
            if (deletePost(id, type,tk,r)) {
                //deleteRow(r);
            }
        }
        document.getElementById('dialogbox').style.display = "none";
        document.getElementById('dialogoverlay').style.display = "none";
    }
}
var Confirm = new CustomConfirm();

