
var chartColors = {
    orange: 'rgb(255, 159, 64)',
    green: 'rgb(50, 150, 110)',
    blue: 'rgb(44, 142, 220)',
    purple: 'rgb(153, 102, 255)',
    grey: 'rgb(101, 103, 107)'
};

var duration = 1200000;
var refresh = 30000;
var delay = 1000;

function onRefresh() {
    getDataUpdate();
}

var color = Chart.helpers.color;
var config1 = {
    type: 'line',
    data: {
        datasets: [{
            label: 'BTC',
            backgroundColor: color(chartColors.green).alpha(0.5).rgbString(),
            borderColor: chartColors.green,
            fill: false,
            cubicInterpolationMode: 'monotone',
            data: []
        }, {
            label: 'BCH',
            backgroundColor: color(chartColors.blue).alpha(0.5).rgbString(),
            borderColor: chartColors.blue,
            fill: false,
            cubicInterpolationMode: 'monotone',
            data: []
        }, {
            label: 'EOS',
            backgroundColor: color(chartColors.orange).alpha(0.5).rgbString(),
            borderColor: chartColors.orange,
            fill: false,
            cubicInterpolationMode: 'monotone',
            data: []
        }, {
            label: 'XRP',
            backgroundColor: color(chartColors.gray).alpha(0.5).rgbString(),
            borderColor: chartColors.gray,
            fill: false,
            cubicInterpolationMode: 'monotone',
            data: []
        }, {
            label: 'ETH',
            backgroundColor: color(chartColors.purple).alpha(0.5).rgbString(),
            borderColor: chartColors.purple,
            fill: false,
            cubicInterpolationMode: 'monotone',
            data: []
        }]
    },
    options: {
        title: {
            display: true,
            text: 'Value'
        },
        scales: {
            xAxes: [{
                type: 'realtime',
                realtime: {
                    duration: duration,
                    refresh: refresh,
                    delay: delay,
                    onRefresh: onRefresh
                }
            }],
            yAxes: [{
                scaleLabel: {
                    display: true,
                    labelString: 'Value ($)'
                }
            }]
        },
        tooltips: {
            mode: 'nearest',
            intersect: false
        },
        hover: {
            mode: 'nearest',
            intersect: false
        },
        legend: {
            display: false,
            onClick: function(e) {e.stopPropagation()}
        },
        maintainAspectRatio: false
    }
};


var config2 = {
    type: 'line',
    data: {
        datasets: [{
            label: 'BTC',
            backgroundColor: color(chartColors.green).alpha(0.5).rgbString(),
            borderColor: chartColors.green,
            fill: false,
            cubicInterpolationMode: 'monotone',
            data: []
        }, {
            label: 'BCH',
            backgroundColor: color(chartColors.blue).alpha(0.5).rgbString(),
            borderColor: chartColors.blue,
            fill: false,
            cubicInterpolationMode: 'monotone',
            data: []
        }, {
            label: 'EOS',
            backgroundColor: color(chartColors.orange).alpha(0.5).rgbString(),
            borderColor: chartColors.orange,
            fill: false,
            cubicInterpolationMode: 'monotone',
            data: []
        }, {
            label: 'XRP',
            backgroundColor: color(chartColors.gray).alpha(0.5).rgbString(),
            borderColor: chartColors.gray,
            fill: false,
            cubicInterpolationMode: 'monotone',
            data: []
        }, {
            label: 'ETH',
            backgroundColor: color(chartColors.purple).alpha(0.5).rgbString(),
            borderColor: chartColors.purple,
            fill: false,
            cubicInterpolationMode: 'monotone',
            data: []
        }]
    },
    options: {
        title: {
            display: true,
            text: 'Volume'
        },
        scales: {
            xAxes: [{
                type: 'realtime',
                realtime: {
                    duration: duration,
                    refresh: refresh,
                    delay: delay,
                    onRefresh: onRefresh
                }
            }],
            yAxes: [{
                scaleLabel: {
                    display: true,
                    labelString: '24-hr Trade Volume'
                }
            }]
        },
        tooltips: {
            mode: 'nearest',
            intersect: false
        },
        hover: {
            mode: 'nearest',
            intersect: false
        },
        legend: {
            display: false,
            onClick: function(e) {e.stopPropagation()}
        },
        maintainAspectRatio: false
    }
};
