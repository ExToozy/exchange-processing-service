package ru.extoozy.processing.core.currency_conventer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.extoozy.processing.core.service.CurrencyService;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class AnotherCurrToRubConverter implements CurrencyConverter {

    private final CurrencyService currencyService;

    @Override
    public BigDecimal convert(String currencyFrom, String currencyTo, BigDecimal amount) {
        BigDecimal rateFrom = currencyService.loadCurrencyRate(currencyFrom);
        System.out.println(currencyFrom);
        return amount.multiply(rateFrom);

    }

    @Override
    public Boolean isCompatible(String currencyFrom, String currencyTo) {
        return !currencyFrom.equals("RUB") && currencyTo.equals("RUB");
    }
}
