
<a href="https://gatescrypto.cfapps.io/">Live Demo on Cloud Foundry</a>
<br>

This is a front end and server that uses the [Cryptonator](https://www.cryptonator.com/api/) API to get information about five cryptocurrencies. The front end displays streaming (chart.js/moment.js) live updates of price and 24-hour trading volume for the selected currency/currencies. The backend periodically polls Cryptonator, using a scheduled thread, stores that data, and the front end uses periodic Ajax requests to access that data and update the chart.

### Use Notes
* The backend polls Cryptonator each minute for updates quotes for 5 cryptocurrencies
* It serves a view at `locaclhost:8080/`
* This view is a streaming chart of the value and 24-hour volume of some or all of the 5 cryptocurrencies; Cryptonator only updates every minute or two, so be patient
* Because the backend is H2, it will not be populated initially, but if you open the webpage after it has been running for a few minutes or more, you will see data
* You can turn the cryptos on and off via the buttons; the scales can be quite different, so this is very helpful

### Example
<img src="crypto.gif" width="600px">
