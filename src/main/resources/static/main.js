var baseUrl = "https://gatescrypto.cfapps.io/";

function timestampToDate (timestamp) {
    return Math.round(timestamp*1000);
}

function dateToTimestamp (date) {
    return Math.round(date/1000);
}

function mapCryptoToArray (crypto) {
    var map = {"BTC":0,"BCH":1,"EOS":2,"XRP":3,"ETH":4};
    return map[crypto];
}


function getDataUpdate () {
    var timestamp = dateToTimestamp(new Date() - duration);
    $.ajax({ // get the last (duration interval)'s worth of data
        data: {"timestamp":timestamp},
        type: 'GET',
        url: baseUrl + '/',
        dataType: 'json',
    }).then(function (response) {
        console.log(response);
        for (var i=0; i<5; i++) {
            config1.data.datasets[i].data = [];
            config2.data.datasets[i].data = [];
        }
        response.forEach(function(data) {
            var index = mapCryptoToArray(data["base"]);
            config1.data.datasets[index].data.push({
                x: timestampToDate(data["timestamp"]),
                y: data["price"]
            });
            config2.data.datasets[index].data.push({
                x: timestampToDate(data["timestamp"]),
                y: data["volume"]
            });
        });
        window.myChart.update();
        window.myChart2.update();
    });
}

function getCheckedCryptos () {
    var checked = [];
    $.each($("input[name='crypto']:checked"), function() {
        checked.push($(this).val());
    });
    return checked;
}

function getUncheckedCryptos () {
    var unchecked = [];
    $.each($("input[name='crypto']:not(:checked)"), function() {
        unchecked.push($(this).val());
    });
    return unchecked;
}

function updateSelectedGraphs () {
    var toShow = getCheckedCryptos();
    toShow.forEach(function(crypto) {
        config1.data.datasets[mapCryptoToArray(crypto)].hidden = false;
        config2.data.datasets[mapCryptoToArray(crypto)].hidden = false;
    });
    var toHide = getUncheckedCryptos();
    toHide.forEach(function(crypto) {
        config1.data.datasets[mapCryptoToArray(crypto)].hidden = true;
        config2.data.datasets[mapCryptoToArray(crypto)].hidden = true;
    });
    window.myChart.update();
    window.myChart2.update();
}



$(document).ready (function() {
    var ctx1 = document.getElementById('myChart').getContext('2d');
    window.myChart = new Chart(ctx1, config1);
    var ctx2 = document.getElementById('myChart2').getContext('2d');
    window.myChart2 = new Chart(ctx2, config2);


    updateSelectedGraphs();
    getDataUpdate();

    $('.check').change(function () {
        console.log('click');
        updateSelectedGraphs();
    });

});

