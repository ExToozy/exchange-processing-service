package ru.extoozy.processing.core.currency_conventer;

import java.math.BigDecimal;

public interface CurrencyConverter {

    BigDecimal convert(String currencyFrom, String currencyTo, BigDecimal amount);

    Boolean isCompatible(String currencyFrom, String currencyTo);
}
