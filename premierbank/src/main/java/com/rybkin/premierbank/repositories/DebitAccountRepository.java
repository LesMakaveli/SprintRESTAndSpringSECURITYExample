package com.rybkin.premierbank.repositories;

import com.rybkin.premierbank.entities.MoneyTransfer;
import org.springframework.data.jpa.repository.JpaRepository;
import com.rybkin.premierbank.entities.DebitAccount;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DebitAccountRepository extends JpaRepository<DebitAccount, Integer> {
    @Query("SELECT d FROM DebitAccount d WHERE d.client =:externalId")
    Optional<List<DebitAccount>> findByExternalId(@Param("externalId") int externalId);
}
