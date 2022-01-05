  Highcharts.chart('container', {
    chart: {
        type: 'column'
    },
    title: {
        text: 'Stacked column chart'
    },
    xAxis: {
        categories: length
    },
    yAxis: {
        min: 0,
        title: {
            text: 'Amount'
        },
        stackLabels: {
            enabled: false,
        }
    },
    legend: {
        align: 'right',
        x: -30,
        verticalAlign: 'top',
        y: 25,
        floating: true,
        backgroundColor:
            Highcharts.defaultOptions.legend.backgroundColor || 'white',
        borderColor: '#CCC',
        borderWidth: 1,
        shadow: false
    },
    tooltip: {
        headerFormat: '<b>{point.x}</b><br/>',
        pointFormat: '{series.name}: £{point.y:,.2f}<br/>Total: £{point.stackTotal:,.2f}'
    },
    plotOptions: {
        column: {
            stacking: 'normal',
            dataLabels: {
                enabled: false
            }
        }
    },
    series: [{
        name: 'Interest Earned',
        data: bdcInterest
    }, {
        name: 'Initial Investment',
        data: initialInvestment
	}]
});