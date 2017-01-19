/**
 * Created by Pawel_Piedel on 2017-01-19.
 */
document.onreadystatechange = function () {

    if (document.readyState == "complete") {
        addListenerForCancelButton();

    }
};


function addListenerForCancelButton() {
    $('.summary-buttons #cancelButton').click(function() {
        console.log('cancelButton');
        location.href = 'http://localhost:8080/repertuar';
        console.log(location.href)
    })
}