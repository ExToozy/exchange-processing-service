package ru.extoozy.processing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.extoozy.processing.model.AccountEntity;

public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
}
