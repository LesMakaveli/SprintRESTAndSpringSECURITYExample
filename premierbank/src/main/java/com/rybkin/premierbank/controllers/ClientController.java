package com.rybkin.premierbank.controllers;

import com.rybkin.premierbank.entities.Client;
import com.rybkin.premierbank.entities.DebitAccount;
import com.rybkin.premierbank.entities.MoneyTransfer;
import com.rybkin.premierbank.services.ClientService;
import com.rybkin.premierbank.services.DebitAccountService;
import com.rybkin.premierbank.services.MoneyTransferService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController
{
    private ClientService clientService;
    private DebitAccountService debitAccountService;
    private MoneyTransferService moneyTransferService;

    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    public void setDebitAccountService(DebitAccountService debitAccountService) {
        this.debitAccountService = debitAccountService;
    }

    public void setMoneyTransferService(MoneyTransferService moneyTransferService) {
        this.moneyTransferService = moneyTransferService;
    }


    @GetMapping("/{id}")
    public Client getClient(@PathVariable int id) {
        return clientService.getClient(id);
    }

    @GetMapping("/{id}/debit-account")
    public List<DebitAccount> getDebitAccount(@PathVariable int id) {
        return debitAccountService.getDebitAccount(id);
    }

    @GetMapping("/{id}/money-transfer")
    public List<MoneyTransfer> getMoneyTransfer(@PathVariable int id){
        return moneyTransferService.getTransferHistoryOfOneClient(id);
    }
}
