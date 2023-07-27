package com.rybkin.premierbank.services;

import org.springframework.stereotype.Service;
import com.rybkin.premierbank.entities.DebitAccount;
import com.rybkin.premierbank.repositories.DebitAccountRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DebitAccountService {
    private DebitAccountRepository debitAccountRepository;

    public void setDebitAccountRepository(DebitAccountRepository debitAccountRepository) {
        this.debitAccountRepository = debitAccountRepository;
    }

    public List<DebitAccount> getAllDebitAccounts() {
        return debitAccountRepository.findAll();
    }

    public void saveDebitAccount(DebitAccount debitAccount) {
        debitAccountRepository.save(debitAccount);
    }

    public List<DebitAccount> getDebitAccount(int externalId) {
        List <DebitAccount> debitAccount = null;
        Optional<List<DebitAccount>> debitAccountOptional = debitAccountRepository.findByExternalId(externalId);
        if (debitAccountOptional.isPresent()) {
            debitAccount = debitAccountOptional.get();
        }
        return debitAccount;
    }

    public void deleteDebitAccount(int id) {
        debitAccountRepository.deleteById(id);
    }
}
