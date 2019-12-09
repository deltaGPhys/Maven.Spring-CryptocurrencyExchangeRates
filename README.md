# Use Notes
* The backend polls Cryptonator each minute for updates quotes for 5 cryptocurrencies
* It serves a view at `locaclhost:8080/`
* This view is a streaming chart of the value and 24-hour volume of some or all of the 5 cryptocurrencies; Cryptonator only updates every minute or two, so be patient
* Because the backend is H2, it will not be populated initially, but if you open the webpage after it has been running for a few minutes or more, you will see data
* You can turn the cryptos on and off via the buttons; the scales can be quite different, so this is very helpful

# Cryptocurrencies exchange rates API
* Using [Cryptonator](https://www.cryptonator.com/api/), create a REST resource which displays information about the specified crypto currency.
* The information should be updated every 5 minutes.
* Ensure that your project architecture is as clean as possible
    * **Note:**
        * `Repository` implements [CRUD](https://en.wikipedia.org/wiki/Create,_read,_update_and_delete) functionality.
        * `Service` implements business logic by manipulating a composite `Repository`
        * `Controller` hosts client-accessible [End Points](https://stackoverflow.com/questions/10799198/what-are-rest-resources)
        * `Domain` or `Model` are object-representations of our data 
