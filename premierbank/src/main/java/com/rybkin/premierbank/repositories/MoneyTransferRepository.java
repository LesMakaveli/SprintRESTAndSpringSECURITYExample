package com.rybkin.premierbank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.rybkin.premierbank.entities.MoneyTransfer;

import java.util.List;
import java.util.Optional;

public interface MoneyTransferRepository extends JpaRepository<MoneyTransfer, Integer> {
    @Query("SELECT m FROM MoneyTransfer m WHERE m.sender = :externalId OR m.receiver=:externalId")
    Optional <List<MoneyTransfer>> findByExternalId(@Param("externalId") int externalId);

    @Query("DELETE FROM MoneyTransfer m WHERE m.sender = :externalId OR m.receiver=:externalId")
     void deleteByExternalId (@Param("externalId") int externalId);
}
