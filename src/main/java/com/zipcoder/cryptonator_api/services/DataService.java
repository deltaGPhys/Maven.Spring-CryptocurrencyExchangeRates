package com.zipcoder.cryptonator_api.services;

import com.zipcoder.cryptonator_api.domain.Datum;
import com.zipcoder.cryptonator_api.repositories.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataService {

    @Autowired
    DataRepository dataRepository;

    public Datum addDatum (Datum datum) {
        return (uniqueDatum(datum)) ? dataRepository.save(datum) : null;
    }

    public boolean uniqueDatum (Datum datum) {
        Datum retrievedDatum = dataRepository.findDatumByCryptoAndTimestamp(datum.getCrypto(),datum.getTimestamp());
        return (retrievedDatum == null) ? true : false;
    }

    public Iterable<Datum> getAllData () {
        return dataRepository.findAll();
    }

    public Iterable<Datum> getDataForCrypto (String crypto) {
        return dataRepository.findDataByCrypto(crypto);
    }

    public Iterable<Datum> getDataForCryptoAndSince (String crypto, Long timestamp) {
        return dataRepository.findDataByCryptoAndTimestampGreaterThanEqual(crypto, timestamp);
    }

    public Iterable<Datum> getDataSince (Long timestamp) {
        return dataRepository.findDataByTimestampGreaterThanEqual(timestamp);
    }


}
