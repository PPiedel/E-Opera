/**
 * Created by Pawel_Piedel on 2017-01-17.
 */

document.onreadystatechange = function () {
    console.log('podglad_sali_ready');
    if (document.readyState == "complete") {
        addListenersForPlaces();
    }
};

function addListenersForPlaces() {
    $('.table-row td').click(function() {
        var value = this.getAttribute('value');
    })

}