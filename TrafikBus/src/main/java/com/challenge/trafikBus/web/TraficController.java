package com.challenge.trafikBus.web;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class TraficController {

    @Autowired
    TraficService traficService;

    @ApiOperation(value = "/topTen", notes = "xxx", tags = "", nickname = "xxx")
    @GetMapping(value = "/topTen", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> collectCalculatedFinancialEstimateResult() throws Exception {
        log.info("get data");
        System.out.println("restkontroller");
        traficService.getTopTenBuses();
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/busstops/{busline}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List> getBusStops(@PathVariable String busline) throws Exception {
        log.info("Collect from result = {} with busline={}", busline);

        if (busline == null || busline.isEmpty()) {
            log.error("busline can not be empty");
            throw new IllegalArgumentException("Busline is empty");
        }

        traficService.getBusStopsForBusline(busline);
        return ResponseEntity.ok().build();
    }
}