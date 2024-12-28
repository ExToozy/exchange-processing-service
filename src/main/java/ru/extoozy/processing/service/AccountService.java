package ru.extoozy.processing.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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

}
