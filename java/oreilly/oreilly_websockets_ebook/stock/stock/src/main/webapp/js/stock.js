(function() {
    'use strict';

    if ("WebSocket" in window) {

        var stockRequest = {"stocks" : ['AAPL', 'MSFT', 'AMZN', 'GOOG', 'YHOO']},
            stocks = {
                'AAPL' : 0,
                'MSFT' : 0,
                'AMZN' : 0,
                'GOOG' : 0,
                'YHOO' : 0
            };
        var changeStockEntry = function(symbol, originalValue, newValue) {
            var valElem = $('#' + symbol + ' h3 span');
            var evolutionElem = $('#' + symbol + '_e span.evolution').find('i');
            valElem.html(newValue.toFixed(2));
            if (newValue < originalValue) {
                valElem.addClass('label-danger');
                valElem.removeClass('label-success');
                evolutionElem.addClass('fa-arrow-down');
                evolutionElem.removeClass('fa-arrow-up');
            } else {
                valElem.removeClass('label-danger');
                valElem.addClass('label-success');
                evolutionElem.removeClass('fa-arrow-down');
                evolutionElem.addClass('fa-arrow-up');
            }
        };

        var ws = new WebSocket('ws://localhost:8080/stock/stockEndpoint');

        ws.onopen = function(e) {
            ws.send(JSON.stringify(stockRequest));
        };

        ws.onclose = function(e) {
            for (var symbol in stocks) {
                if (stocks.hasOwnProperty(symbol)) {
                    stocks[symbol] = 0;
                }
            }
        };

        ws.onmessage = function(e) {
            var stockData = JSON.parse(e.data);
            for (var symbol in stockData) {
                if (stockData.hasOwnProperty(symbol)) {
                    changeStockEntry(symbol, stocks[symbol], stockData[symbol]);
                    stocks[symbol] = stockData[symbol];
                }
            }
        };

        ws.onerror = function(e) {
            console.log('Error occured!', e);
        };
    } else {
        console.log('WebSockets not available!');
    }
})();