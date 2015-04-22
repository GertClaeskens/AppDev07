//alert("Test");
var first = document.getElementById("aandoening"),
    second = document.getElementById("pathologie");
alert(first.value);
alert(second.value);
//function OnChange(e){
first.onchange = function (e) {
    var val = e.target.value;
    alert(val);
    empty(second);
    pat = loadData(val);
    for (var i = 0; i < 3; i += 1) {
        //gegevens ophalen

        addOption(pat[i].omschrijving,pat[i].id, second);
    }
};

function empty(select) {
    select.innerHTML = '';
}

function addOption(inhoud,waarde, select) {
    var option = document.createElement('option');
    option.value = waarde;
//            option.innerHTML = val;
    option.textContent = inhoud;
    option.innerText = inhoud;
    select.appendChild(option);
}
/*        function makeOption(inhoud, waarde) {
 var el;
 el = document.createElement("option");
 el.value = waarde;
 el.textContent = inhoud;
 return el;
 }*/
/*        function dataLoaded() {
 var el;
 var select;
 var teller;

 select = document.getElementById("pathologie");

 for (teller = 0; teller < data.length; teller++) {
 el = makeOption(data[teller].omschrijving, teller,second);
 select.appendChild(el);
 }

 }*/

function loadData(id) {
    var xhr;
    xhr = new XMLHttpRequest();
    xhr.overrideMimeType("application/json");
    alert(id);
    url = "http://localhost:1695/Aandoening/" + id + "/Pathologie";

    xhr.open("GET", url, true);

    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            data = JSON.parse(xhr.responseText);

        }
    };
    xhr.send(null);
    alert(data);
    return data;
}/**
 * Created by Gert on 22/04/2015.
 */
