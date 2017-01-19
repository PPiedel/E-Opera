/**
 * Created by Pawel_Piedel on 2017-01-16.
 */

document.onreadystatechange = function () {
    console.log('onreadystate');
    if (document.readyState == "complete") {
        /*addListeners();*/
        addListenersForDays();
        addListenersForSpectacleHours()
    }
};

function addListenersForDays() {
    $('#menuContainer li').click(function() {
        var value = $(this).attr('data-value');
        location.href = add_url_parameter(location.href, 'date', value);
    })
}

function addListenersForSpectacleHours() {
    $('.list-inline li').click(function() {
        var value = $(this).attr('value');
        console.log(location.href);
        location.href = add_url_parameter('http://localhost:8080/repertuar/podglad_sali','performance_id',value)
    })
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
