/**
 * Created by Pawel_Piedel on 2017-01-16.
 */

document.onreadystatechange = function () {
    console.log('onreadystate');
    if (document.readyState == "complete") {
        addListeners();
    }
};

function addListeners() {

    var l = document.getElementById("menuContainer").getElementsByTagName('li');

    for (var i=0; i<l.length; i++)
    {
        console.log('Dodaje listenera');
        date = l[i].value;
        console.log(date);
        l[i].addEventListener('click',
            function() {
                days_onlick(date);
            },
            false);
    }
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

function days_onlick(date) {
    var date = document.getEl
    location.href = add_url_parameter(location.href, 'date', date);
    console.log(location.href);

}
