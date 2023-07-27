package com.rybkin.premierbank.repositories;

import com.rybkin.premierbank.entities.BankEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankEmployeeRepository extends JpaRepository<BankEmployee, Integer> {

}
