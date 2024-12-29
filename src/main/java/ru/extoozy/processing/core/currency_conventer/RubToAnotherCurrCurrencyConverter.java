package ru.extoozy.processing.core.currency_conventer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.extoozy.processing.core.service.CurrencyService;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
@RequiredArgsConstructor
public class RubToAnotherCurrCurrencyConverter implements CurrencyConverter {

    private final CurrencyService currencyService;

    @Override
    public BigDecimal convert(String currencyFrom, String currencyTo, BigDecimal amount) {
        BigDecimal rateTo = currencyService.loadCurrencyRate(currencyTo);

        return amount.divide(rateTo, 4, RoundingMode.HALF_DOWN);
    }

    @Override
    public Boolean isCompatible(String currencyFrom, String currencyTo) {
        return currencyFrom.equals("RUB") && !currencyTo.equals("RUB");
    }
}
