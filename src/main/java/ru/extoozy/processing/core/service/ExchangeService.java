package ru.extoozy.processing.core.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import ru.extoozy.processing.core.currency_conventer.CurrencyConverterFactory;
import ru.extoozy.processing.store.model.AccountEntity;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
@Slf4j
public class ExchangeService {

    private final AccountService accountService;

    private final CurrencyConverterFactory converterFactory;

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public BigDecimal exchangeCurrency(String uuid, Long fromAccountId, Long toAccountId, BigDecimal amount) {
        AccountEntity fromAccount = accountService.getAccountById(fromAccountId);
        AccountEntity toAccount = accountService.getAccountById(toAccountId);

        BigDecimal convertedValue = converterFactory
                .getConverter(fromAccount.getCurrencyCode(), toAccount.getCurrencyCode())
                .convert(fromAccount.getCurrencyCode(), toAccount.getCurrencyCode(), amount);

        accountService.addMoneyToAccount(uuid, fromAccountId, amount.negate());
        accountService.addMoneyToAccount(uuid, toAccountId, convertedValue);

        return convertedValue;
    }
}
