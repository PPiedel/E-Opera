/**
 * Created by Pawel_Piedel on 2017-01-19.
 */

document.onreadystatechange = function () {
    if (document.readyState == "complete") {
       addOnlinePaymentButtonListener();
       addOnTheSpotPaymentListener();
       addListenerForCancelButton();
       addListenerForNextPaymentButton();
    }
};

function addOnlinePaymentButtonListener() {
    $('.payment-buttons #onlinePayment').click(function() {
        $('#onlinePaymentButtons').toggle('slow', function() {
        });
    })
}

function addOnTheSpotPaymentListener() {
    $('.payment-buttons #onTheSpotPayment').click(function() {
        if($('#onlinePaymentButtons').is(":visible") ){
            $('#onlinePaymentButtons').toggle('slow', function() {
            });
        }

    })

}

function addListenerForCancelButton() {
    $('.payment-summary-buttons #cancel_payment').click(function() {
        if (confirm('Czy jesteś pewien, że chcesz anulować transakcję ?')) {
            location.href = 'http://localhost:8080/repertuar';
        }

    })
}


function addListenerForNextPaymentButton() {
    $('.payment-summary-buttons #payment_next').click(function() {
        location.href = add_url_parameter('http://localhost:8080/podsumowanie/platnosc/end','status','success')
    });


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