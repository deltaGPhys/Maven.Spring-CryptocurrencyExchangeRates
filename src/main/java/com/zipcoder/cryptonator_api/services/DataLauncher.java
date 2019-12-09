package com.zipcoder.cryptonator_api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Component
public class DataLauncher implements CommandLineRunner {

    @Autowired
    DataService dataService;

    public void run(String...args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(new DataGrabber(dataService), 0, 60, TimeUnit.SECONDS);
    }

}
