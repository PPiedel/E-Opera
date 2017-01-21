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
        location.href = "http://localhost:8080/repertuar"
    })
}

function addListenerForNextButton() {
    $('.buttons #nextButton').click(function() {
        addPlacesToBasket();
        var performance_id = $('#places').attr('value');
        console.log(performance_id);
        var places = countActivePlaces();
        console.log(places);

        var first_param = add_url_parameter('http://localhost:8080/podsumowanie','performance_id',performance_id);
        console.log(first_param);
        location.href = add_url_parameter(first_param,'places',places);
        console.log(location.href)
    })
}

function countActivePlaces() {
    var count = 0;
    $('#places').find('tr').each(function(){
        $(this).find('td.active').each(function(){
          count++;
        })
    });
    return count;
}

function addPlacesToBasket() {
    $('#places').find('tr').each(function(){
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

function add_url_parameter(url, param, value){
    console.log('Zmieniam URL');
    var hash       = {};
    var parser     = document.createElement('a');

    parser.href    = url;

    var parameters = parser.search.split(/\?|&/);

    for(var i=0; i < parameters.length; i++) {
        if(!parameters[i])
            continue;

        var ary      = parameters[i].split('=');
        hash[ary[0]] = ary[1];
    }

    hash[param] = value;

    var list = [];
    Object.keys(hash).forEach(function (key) {
        list.push(key + '=' + hash[key]);
    });

    parser.search = '?' + list.join('&');
    return parser.href;
}