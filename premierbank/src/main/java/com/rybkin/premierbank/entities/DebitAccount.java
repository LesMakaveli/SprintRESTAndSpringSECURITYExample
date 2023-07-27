package com.rybkin.premierbank.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "debit_accounts")
@NoArgsConstructor
@Data
public class DebitAccount
{
    @Id
    @Column(name = "debit_account_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "fk_client_id", referencedColumnName = "client_id")
    private Client client;

    @Column(name = "balance")
    private BigDecimal balance;

    @Column(name = "account_number")
    private String accountNumber;

    public DebitAccount(int id, Client client, BigDecimal balance, String accountNumber) {
        this.id = id;
        this.client = client;
        this.balance = balance;
        this.accountNumber = accountNumber;
    }
}
