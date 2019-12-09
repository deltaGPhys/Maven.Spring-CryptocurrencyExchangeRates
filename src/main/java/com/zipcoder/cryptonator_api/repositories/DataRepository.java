package com.zipcoder.cryptonator_api.repositories;

import com.zipcoder.cryptonator_api.domain.Datum;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataRepository extends CrudRepository<Datum,Long> {

    Datum findDatumByCryptoAndTimestamp (String crypto, long timestamp);

    Iterable<Datum> findDataByCrypto (String crypto);

    Iterable<Datum> findDataByCryptoAndTimestampGreaterThanEqual (String crypto, Long timestamp);

    Iterable<Datum> findDataByTimestampGreaterThanEqual (Long timestamp);

}
