package ru.extoozy.processing.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.extoozy.processing.core.service.AccountService;
import ru.extoozy.processing.store.model.AccountEntity;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final AccountService accountService;

    @GetMapping("/{id}/account")
    public List<AccountEntity> getAllAccounts(@PathVariable Long id) {
        return accountService.getAllAccounts(id);
    }
}
