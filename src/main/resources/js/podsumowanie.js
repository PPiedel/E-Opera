/**
 * Created by Pawel_Piedel on 2017-01-19.
 */
document.onreadystatechange = function () {

    if (document.readyState == "complete") {
        addListenerForCancelButton();
        addListenerForPayButton();
    }
};


function addListenerForCancelButton() {
    $('.summary-buttons #cancelButton').click(function() {
        if (confirm('Czy jesteś pewien, że chcesz anulować transakcję ?')) {
            console.log('cancelButton');
            location.href = 'http://localhost:8080/repertuar';
            console.log(location.href)
        }


    })
}

function addListenerForPayButton() {
    $('.summary-buttons #payButton').click(function() {
        location.href = 'http://localhost:8080/podsumowanie/platnosc';
    })
}

