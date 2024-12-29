package ru.extoozy.processing.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.extoozy.processing.api.dto.AddAccountMoneyDto;
import ru.extoozy.processing.api.dto.ExchangeMoneyDto;
import ru.extoozy.processing.api.dto.NewAccountDto;
import ru.extoozy.processing.core.service.AccountService;
import ru.extoozy.processing.core.service.ExchangeService;
import ru.extoozy.processing.store.model.AccountEntity;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/v1/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    private final ExchangeService exchangeService;

    @PostMapping
    public AccountEntity createAccount(@RequestBody NewAccountDto dto) {
        return accountService.createNewAccount(dto);
    }

    @PutMapping
    public AccountEntity putMoney(@RequestBody AddAccountMoneyDto dto) {
        return accountService.addMoneyToAccount(dto.getUuid(), dto.getAccountId(), dto.getAmount());
    }

    @PutMapping("/exchange")
    public BigDecimal exchange(@RequestBody ExchangeMoneyDto dto) {
        return exchangeService.exchangeCurrency(
                dto.getExchangeUuid(),
                dto.getFromAccountId(),
                dto.getToAccountId(),
                dto.getAmount()
        );
    }

}
