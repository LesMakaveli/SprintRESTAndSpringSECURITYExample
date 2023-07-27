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
@RequestMapping("/bank-employee")
public class BankEmployeeController
{
    private DebitAccountService debitAccountService;
    private ClientService clientService;
    private MoneyTransferService moneyTransferService;

    public void setDebitAccountService(DebitAccountService debitAccountService) {
        this.debitAccountService = debitAccountService;
    }

    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    public void setMoneyTransferService(MoneyTransferService moneyTransferService) {
        this.moneyTransferService = moneyTransferService;
    }

    @PostMapping("/addClient")
    public Client addNewClient(@RequestBody Client client) {
        clientService.saveClient(client);
        return client;
    }

    @PutMapping("/updateClient")
    public Client updateClient(@RequestBody Client client) {
        clientService.saveClient(client);
        return client;
    }

    @DeleteMapping("/deleteClient/{id}")
    public String deleteClient(@PathVariable int id) {
        clientService.deleteClient(id);
        return "Client with ID = " + id + " was deleted";
    }

    @GetMapping("/allAccounts")
    public List<DebitAccount> getAllAccount() {
        return debitAccountService.getAllDebitAccounts();
    }

    @PostMapping("/save-debitAccount")
    public DebitAccount saveDebitAccount(@RequestBody DebitAccount debitAccount) {
        debitAccountService.saveDebitAccount(debitAccount);
        return debitAccount;
    }

    @GetMapping("/getClient/{id}")
    public List<DebitAccount> getDebitAccount(@PathVariable int id) {
        return debitAccountService.getDebitAccount(id);
    }

    @GetMapping("/get-allMoneyTransfers")
    public List<MoneyTransfer> getMoneyTransfers() {
        return moneyTransferService.getEntireHistoryOfTransfers();
    }

    @GetMapping("/get-moneyTransfers/{id}")
    public List<MoneyTransfer> getClientTransfers(@PathVariable int id) {
        return moneyTransferService.getTransferHistoryOfOneClient(id);
    }

    @DeleteMapping("/delete-moneyTransfers/{id}")
    public void deleteMoneyTransfersClient(@PathVariable int id) {
        moneyTransferService.deleteMoneyTransfers(id);
    }
}
