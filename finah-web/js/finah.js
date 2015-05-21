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
        document.getElementById('dialogboxfoot').innerHTML = '<button onclick="Alert.ok()">OK</button>';
    };
    this.ok = function () {
        document.getElementById('dialogbox').style.display = "none";
        document.getElementById('dialogoverlay').style.display = "none";
    }
}
var Alert = new CustomAlert();
function deletePost(id, type) {
    //var db_id = id.replace("post_", "");
    // Run Ajax request here to delete post from database
    $.ajax({
        url: 'http://finahbackend1920.azurewebsites.net/' + type + '/' + id,
        //url: 'http://localhost:1695/' + type + '/' + id,
        type: 'DELETE',
        contentType: 'application/json',
        success: function () {
            return true;
            // Do something with the result
        }
    });

    return false;
    //document.body.removeChild(document.getElementById('rij' + id));
}
function CustomConfirm() {
    this.render = function (dialog, op, id, type, r) {
        var winW = window.innerWidth;
        var winH = window.innerHeight;
        var dialogoverlay = document.getElementById('dialogoverlay');
        var dialogbox = document.getElementById('dialogbox');
        dialogoverlay.style.display = "block";
        dialogoverlay.style.height = winH + "px";
        dialogbox.style.left = (winW / 2) - (550 * .5) + "px";
        dialogbox.style.top = "100px";
        dialogbox.style.display = "block";
        document.getElementById('dialogboxhead').innerHTML = "Confirm that action";
        document.getElementById('dialogboxbody').innerHTML = dialog;
        document.getElementById('dialogboxfoot').innerHTML = '<button onclick="Confirm.yes(\'' + op + '\',\'' + id + '\',\'' + type + '\',\'' + r + '\')">Yes'+'</button> <button onclick="Confirm.no()">No</button>';
    };
    this.no = function () {
        document.getElementById('dialogbox').style.display = "none";
        document.getElementById('dialogoverlay').style.display = "none";
    };
    this.yes = function (op, id, type, r) {
        if (op == "delete_lft") {
            if (deletePost(id, type)) {
                deleteRow(r);
            }
        }
        document.getElementById('dialogbox').style.display = "none";
        document.getElementById('dialogoverlay').style.display = "none";
    }
}
var Confirm = new CustomConfirm();

