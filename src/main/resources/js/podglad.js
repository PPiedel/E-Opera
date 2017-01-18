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
        var color  = $(this).css("background-color");
        console.log(color);

        if ($(this).css("background-color") == "rgba(0, 0, 0, 0)" ){
            console.log('zmieniam kolor na czerwony');
            $(this).addClass('active');
            $(this).css('backgroundColor', 'rgb(255, 0, 0)');
        }
        else if ($(this).css("background-color") == "rgb(255, 0, 0)" ) {
            console.log('zmieniam kolor na bialy');
            $(this).removeClass('active');
            $(this).css('backgroundColor', 'rgba(0, 0, 0, 0)');
        }

    })

}