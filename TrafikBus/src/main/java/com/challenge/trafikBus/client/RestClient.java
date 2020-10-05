package com.challenge.trafikBus.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import java.time.Duration;
import java.util.List;

@Component
@Slf4j
public class RestClient {

    private String apiKey = "dbffed2d71594c57adcbc27c8bf1f820";

    @Value("${trafic.endpoint.target}")
    String baseUrl;

    //private CorrelationIdBean correlationIdBean;

    public void getTopTenBuses() {

        String url = baseUrl;

        RestTemplate restTemplate = new RestTemplateBuilder()
                .setConnectTimeout(Duration.ofSeconds(5))
                .setReadTimeout(Duration.ofSeconds(5))
                .build();

        try {
            HttpHeaders httpHeaders = new HttpHeaders();
            //httpHeaders.set("Client-Correlation-Id", correlationIdBean.getCorrelationId());
            HttpEntity<List> request = new HttpEntity<>(httpHeaders);
            String endpoint = baseUrl + "/xx";
            //restTemplate.postForEntity(endpoint, request, Void.class);

            log.debug("Get top ten Result successfully");

        } catch (HttpClientErrorException e) {
            //log.error("Failed to send financial data to PCICalculatedFinancialEstimatesService code={}, message={} correlationId={}", e.getStatusCode(), e.getLocalizedMessage(), correlationIdBean.getCorrelationId());
            log.error("Failed to get data code={}, message={} ", e.getStatusCode(), e.getLocalizedMessage());

        } catch (Exception e){
            //log.error("Failed to get data message={} correlationId={}", e.getLocalizedMessage(), correlationIdBean.getCorrelationId());
            log.error("Failed to get data message={}", e.getLocalizedMessage());
        }
    }

    public void getBusStopsForBusline(String busline) {

        String url = baseUrl + "model=jour&" + "key=" + apiKey;

        RestTemplate restTemplate = new RestTemplateBuilder()
                .setConnectTimeout(Duration.ofSeconds(5))
                .setReadTimeout(Duration.ofSeconds(5))
                .build();

        try {
            HttpHeaders httpHeaders = new HttpHeaders();
            //httpHeaders.set("Client-Correlation-Id", correlationIdBean.getCorrelationId());
            httpHeaders.set("busline", busline);
            HttpEntity<List> request = new HttpEntity<>(httpHeaders);
            String endpoint = baseUrl + "/api/calculated-financial-estimates";
            //restTemplate.postForEntity(endpoint, request, Void.class);

            log.debug("Get bus stop Result successfully for busline={} ", busline);

        } catch (HttpClientErrorException e) {
            //log.error("Failed to send financial data to PCICalculatedFinancialEstimatesService code={}, message={} correlationId={}", e.getStatusCode(), e.getLocalizedMessage(), correlationIdBean.getCorrelationId());
            log.error("Failed to get data code={}, message={}", e.getStatusCode(), e.getLocalizedMessage());

        } catch (Exception e){
            //log.error("Failed to get data message={} correlationId={}", e.getLocalizedMessage(), correlationIdBean.getCorrelationId());
            log.error("Failed to get data message={}", e.getLocalizedMessage());
        }
    }
}
