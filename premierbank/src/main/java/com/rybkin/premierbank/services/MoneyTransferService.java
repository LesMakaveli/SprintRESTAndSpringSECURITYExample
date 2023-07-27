package com.rybkin.premierbank.services;

import org.springframework.stereotype.Service;
import com.rybkin.premierbank.entities.MoneyTransfer;
import com.rybkin.premierbank.repositories.MoneyTransferRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MoneyTransferService
{
    private MoneyTransferRepository moneyTransferRepository;

    public MoneyTransferService(MoneyTransferRepository moneyTransferRepository) {
        this.moneyTransferRepository = moneyTransferRepository;
    }

    public List<MoneyTransfer> getEntireHistoryOfTransfers() {
        return moneyTransferRepository.findAll();
    }

    public void saveTranslationHistory(MoneyTransfer moneyTransfer) {
        moneyTransferRepository.save(moneyTransfer);
    }

    public List<MoneyTransfer> getTransferHistoryOfOneClient(int externalId) {
        List<MoneyTransfer> historyOfOneClient = null;
        Optional<List<MoneyTransfer>> optionalList = moneyTransferRepository.findByExternalId(externalId);
        if (optionalList.isPresent()) {
            historyOfOneClient = optionalList.get();
        }
        return historyOfOneClient;
    }

    public void deleteMoneyTransfers (int externalId) {
        moneyTransferRepository.deleteByExternalId(externalId);
    }
}
