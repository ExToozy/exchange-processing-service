package ru.extoozy.processing.core.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class CurrencyService {

    private final RestTemplate restTemplate;

    @Value("${service.currency.url}")
    private String currencyUrl;

    public BigDecimal loadCurrencyRate(String code) {
        return restTemplate.getForObject(
                currencyUrl + "/api/v1/currency/rate/{code}",
                BigDecimal.class,
                code
        );
    }
}
