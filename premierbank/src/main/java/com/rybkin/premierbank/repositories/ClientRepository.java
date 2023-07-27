package com.rybkin.premierbank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rybkin.premierbank.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
