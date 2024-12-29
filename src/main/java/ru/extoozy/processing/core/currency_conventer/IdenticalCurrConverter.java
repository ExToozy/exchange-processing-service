package ru.extoozy.processing.core.currency_conventer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class IdenticalCurrConverter implements CurrencyConverter {

    @Override
    public BigDecimal convert(String currencyFrom, String currencyTo, BigDecimal amount) {
        return amount;
    }

    @Override
    public Boolean isCompatible(String currencyFrom, String currencyTo) {
        return currencyFrom.equals(currencyTo);
    }
}
