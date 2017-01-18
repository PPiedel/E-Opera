/**
 * Created by Pawel_Piedel on 2017-01-17.
 */

document.onreadystatechange = function () {
    if (document.readyState == "complete") {
        addListenersForPlaces();
        addListenerForPreviusButton();
        addListenerForNextButton();
    }
};

function addListenersForPlaces() {
    $('.table-row td').click(function() {
        var value = this.getAttribute('value');

        if ($(this).css("background-color") == "rgba(0, 0, 0, 0)" ){
            $(this).addClass('active');
            $(this).css('backgroundColor', 'rgb(255, 0, 0)');
        }
        else if ($(this).css("background-color") == "rgb(255, 0, 0)" ) {
            $(this).removeClass('active');
            $(this).css('backgroundColor', 'rgba(0, 0, 0, 0)');
        }

    })

}

function addListenerForPreviusButton() {
    $('.buttons #previousButton').click(function() {
        window.history.back();
    })
}

function addListenerForNextButton() {
    $('.buttons #nextButton').click(function() {
        addToBasket();
    })
}

function addToBasket() {
    $('#places tr').each(function(){
        $(this).find('td.active').each(function(){
            setCookie(this.getAttribute('value'),1,1);
        })
    })
    
}

function setCookie(cname, cvalue, exdays) {
    var d = new Date();
    d.setTime(d.getTime() + (exdays*24*60*60*1000));
    var expires = "expires="+ d.toUTCString();
    document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
}

function getCookie(cname) {
    var name = cname + "=";
    var decodedCookie = decodeURIComponent(document.cookie);
    var ca = decodedCookie.split(';');
    for(var i = 0; i <ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0) == ' ') {
            c = c.substring(1);
        }
        if (c.indexOf(name) == 0) {
            return c.substring(name.length, c.length);
        }
    }
    return "";
}