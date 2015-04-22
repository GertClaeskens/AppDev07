/**
 * Created by Gert on 22/04/2015.
 */
$('#aandoening').change(function(e){
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

});