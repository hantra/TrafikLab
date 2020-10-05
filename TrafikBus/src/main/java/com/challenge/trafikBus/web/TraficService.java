package com.challenge.trafikBus.web;


import com.challenge.trafikBus.client.RestClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TraficService {

    @Autowired
    RestClient restClient;

    public void getTopTenBuses() {
        log.debug("get top ten = {}");
        restClient.getTopTenBuses();
    }
    public void getBusStopsForBusline(String busline) {
        log.debug("Incoming busline = {}", busline);
        restClient.getBusStopsForBusline(busline);
    }
}
