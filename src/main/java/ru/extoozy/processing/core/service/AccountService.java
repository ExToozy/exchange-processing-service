package ru.extoozy.processing.core.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.extoozy.processing.api.dto.NewAccountDto;
import ru.extoozy.processing.store.model.AccountEntity;
import ru.extoozy.processing.store.repository.AccountRepository;

import java.math.BigDecimal;
import java.util.List;

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
    public AccountEntity addMoneyToAccount(String uuid, Long accountId, BigDecimal amount) {
        AccountEntity account = getAccountById(accountId);

        var newBalance = account.getBalance().add(amount);
        account.setBalance(newBalance);

        return accountRepository.save(account);
    }

    public AccountEntity getAccountById(Long id) {
        return accountRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Account with id '%s' not found"
                        .formatted(id))
                );
    }

    public List<AccountEntity> getAllAccounts(Long userId) {
        return accountRepository.findAllByUserId(userId);
    }

}
