/**
 * Created by Pawel_Piedel on 2017-01-17.
 */

document.onreadystatechange = function () {
    if (document.readyState == "complete") {
        addListenersForPlaces();
        addListenerForPreviusButton();
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

function writeCookie(name,value,days) {
    var date, expires;
    if (days) {
        date = new Date();
        date.setTime(date.getTime()+(days*24*60*60*1000));
        expires = "; expires=" + date.toGMTString();
    }else{
        expires = "";
    }
    document.cookie = name + "=" + value + expires + "; path=/";
}

function readCookie(name) {
    var i, c, ca, nameEQ = name + "=";
    ca = document.cookie.split(';');
    for(i=0;i < ca.length;i++) {
        c = ca[i];
        while (c.charAt(0)==' ') {
            c = c.substring(1,c.length);
        }
        if (c.indexOf(nameEQ) == 0) {
            return c.substring(nameEQ.length,c.length);
        }
    }
    return '';
}