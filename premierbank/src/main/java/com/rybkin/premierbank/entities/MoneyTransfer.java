package com.rybkin.premierbank.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "money_transfers")
@NoArgsConstructor
@Data
public class MoneyTransfer
{
    @Id
    @Column(name = "transaction_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "fk_sender_id", referencedColumnName = "client_id")
    private Client sender;

    @ManyToOne
    @JoinColumn(name = "fk_receiver_id", referencedColumnName = "client_id")
    private Client receiver;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "transfer_time")
    private LocalDateTime currentTime;

    public MoneyTransfer(int id, Client sender, Client receiver, BigDecimal amount) {
        this.id = id;
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
        this.currentTime = LocalDateTime.now();
    }
}
