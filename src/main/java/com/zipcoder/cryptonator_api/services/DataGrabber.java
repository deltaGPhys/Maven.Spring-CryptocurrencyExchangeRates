package com.zipcoder.cryptonator_api.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zipcoder.cryptonator_api.domain.Datum;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.LinkedHashMap;

@Service
public class DataGrabber implements Runnable{

    private static String[] codes = new String[] {"BTC", "BCH", "EOS", "ETH", "XRP"};

    private DataService dataService;

    public DataGrabber(DataService dataService) {
        this.dataService = dataService;
    }

    public void run() {
        try {
            RestTemplateBuilder builder = new RestTemplateBuilder();
            RestTemplate restTemplate = builder.build();
            ObjectMapper mapper = new ObjectMapper();

            for (String currency: codes) {
                String uriString = String.format("https://api.cryptonator.com/api/ticker/%s-usd",currency);
                //System.out.println(uriString);
                LinkedHashMap<String,Object> jsonObject = (LinkedHashMap<String, Object>) restTemplate.getForObject(uriString, Object.class);
                String output = jsonObject.toString();

                //System.out.println(jsonObject.toString());

                if (output.contains("success=true")) {
                    Datum datum = parseData(jsonObject);
                    if (datum != null) {
                        System.out.println(datum.getCrypto() + " " + datum.getTimestamp());
                        dataService.addDatum(datum);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Datum parseData (LinkedHashMap<String,Object> jsonObject) {
        HashMap<String,Object> result = new HashMap<String,Object>();
        try {
            long timestamp = new Long((Integer) jsonObject.get("timestamp"));
            LinkedHashMap<String, Object> ticker = (LinkedHashMap<String, Object>) jsonObject.get("ticker");
            String currency = (String) ticker.get("base");
            Double price = Double.parseDouble((String) ticker.get("price"));
            Double volume = Double.parseDouble((String) ticker.get("volume"));
            Double change = Double.parseDouble((String) ticker.get("change"));

            return new Datum(currency, price, volume, change, timestamp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
