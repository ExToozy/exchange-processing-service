package ru.extoozy.processing.core.currency_conventer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CurrencyConverterFactory {

    private final List<CurrencyConverter> converters;

    public CurrencyConverter getConverter(String currencyFrom, String currencyTo) {
        return converters.stream()
                .filter(currencyConverter -> currencyConverter.isCompatible(currencyFrom, currencyTo))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unexpected currency codes"));
    }

}
