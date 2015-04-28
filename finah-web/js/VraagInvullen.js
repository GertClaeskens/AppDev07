/**
 * Created by Brian on 23/04/2015.
 */
function showDiv(){
    document.getElementById("keuze-content").style.visibility = 'visible';
}

function hideDiv(){
    document.getElementById("keuze-content").style.visibility = 'hidden';
    document.getElementById("antw21").className = document.getElementById("antw21").className.replace( /(?:^|\s)active(?!\S)/g , '' );
    document.getElementById("antw22").className = document.getElementById("antw22").className.replace( /(?:^|\s)active(?!\S)/g , '' );
}

function toggleActive(sndBtn){
    document.getElementById("antw11").className = document.getElementById("antw11").className.replace( /(?:^|\s)active(?!\S)/g , '' );
    document.getElementById("antw12").className = document.getElementById("antw12").className.replace( /(?:^|\s)active(?!\S)/g , '' );
    document.getElementById("antw13").className = document.getElementById("antw13").className.replace( /(?:^|\s)active(?!\S)/g , '' );
    document.getElementById("antw14").className = document.getElementById("antw14").className.replace( /(?:^|\s)active(?!\S)/g , '' );
    document.getElementById("antw15").className = document.getElementById("antw15").className.replace( /(?:^|\s)active(?!\S)/g , '' );

    document.getElementById(sndBtn).className += " active";
}

function toggleActiveExtra(sndBtn){
    document.getElementById("antw21").className = document.getElementById("antw21").className.replace( /(?:^|\s)active(?!\S)/g , '' );
    document.getElementById("antw22").className = document.getElementById("antw22").className.replace( /(?:^|\s)active(?!\S)/g , '' );

    document.getElementById(sndBtn).className += " active";
}