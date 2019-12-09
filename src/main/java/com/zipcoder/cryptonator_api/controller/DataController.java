package com.zipcoder.cryptonator_api.controller;

import com.zipcoder.cryptonator_api.domain.Datum;
import com.zipcoder.cryptonator_api.services.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DataController {

    @Autowired
    DataService dataService;

    @GetMapping("/data")
    public ResponseEntity<Iterable<Datum>> getAllData () {
        return new ResponseEntity<>(dataService.getAllData(), HttpStatus.OK);
    }

    @GetMapping(value = "/", params = "crypto")
    public ResponseEntity<Iterable<Datum>> getDataForCrypto (@RequestParam String crypto) {
        return new ResponseEntity<>(dataService.getDataForCrypto(crypto), HttpStatus.OK);
    }

    @GetMapping(value = "/", params = {"crypto","timestamp"})
    public ResponseEntity<Iterable<Datum>> getDataForCryptoSince (@RequestParam String crypto, @RequestParam Long timestamp) {
        return new ResponseEntity<>(dataService.getDataForCryptoAndSince(crypto, timestamp), HttpStatus.OK);
    }

    @GetMapping(value = "/", params = "timestamp")
    public ResponseEntity<Iterable<Datum>> getAllDataSince (@RequestParam Long timestamp) {
        return new ResponseEntity<>(dataService.getDataSince(timestamp), HttpStatus.OK);
    }

    @GetMapping("/")
    public String index () {
        return "index";
    }
}
