package ru.extoozy.processing.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.extoozy.processing.store.model.AccountEntity;

import java.util.List;

public interface AccountRepository extends JpaRepository<AccountEntity, Long> {

    List<AccountEntity> findAllByUserId(Long userId);

}
