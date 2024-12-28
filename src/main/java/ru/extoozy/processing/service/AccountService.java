package ru.extoozy.processing.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.extoozy.processing.dto.AddAccountMoneyDto;
import ru.extoozy.processing.dto.NewAccountDto;
import ru.extoozy.processing.model.AccountEntity;
import ru.extoozy.processing.repository.AccountRepository;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    @Transactional
    public AccountEntity createNewAccount(NewAccountDto dto) {
        AccountEntity account = AccountEntity.builder()
                .userId(dto.getUserId())
                .currencyCode(dto.getCurrencyCode())
                .balance(BigDecimal.ZERO)
                .build();

        return accountRepository.save(account);
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
    public AccountEntity addMoneyToAccount(AddAccountMoneyDto dto) {
        AccountEntity account = accountRepository
                .findById(dto.getAccountId())
                .orElseThrow(() -> new IllegalArgumentException("Account with id '%s' not found"
                        .formatted(dto.getAccountId()))
                );

        var newBalance = account.getBalance().add(dto.getAmount());
        account.setBalance(newBalance);
        return accountRepository.save(account);
    }


}
