package ru.extoozy.processing.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.extoozy.processing.dto.NewAccountDto;
import ru.extoozy.processing.model.AccountEntity;
import ru.extoozy.processing.service.AccountService;

@RestController
@RequestMapping("/api/v1/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping
    public AccountEntity createAccount(@RequestBody NewAccountDto dto) {
        return accountService.createNewAccount(dto);
    }

}
