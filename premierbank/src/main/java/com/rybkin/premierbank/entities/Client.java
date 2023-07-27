package com.rybkin.premierbank.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import java.util.List;

@Entity
@Table(name = "Clients")
@NoArgsConstructor
@Data
public class Client
{
    @Id
    @Column(name = "client_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "surname")
    private String surname;

    @Column(name = "name")
    private String name;

    @Column(name = "passport_number")
    private String passportNumber;

    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToMany(mappedBy = "client")
    @Cascade(org.hibernate.annotations.CascadeType.MERGE)
    private List<DebitAccount> debitAccounts;

    @OneToMany(mappedBy = "sender")
    @Cascade(org.hibernate.annotations.CascadeType.MERGE)
    private List<MoneyTransfer> senders;

    @OneToMany(mappedBy = "receiver")
    @Cascade(org.hibernate.annotations.CascadeType.MERGE)
    private List<MoneyTransfer> recipient;

    public Client(int id, String surname, String name, String passportNumber, String phoneNumber) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.passportNumber = passportNumber;
        this.phoneNumber = phoneNumber;
    }
}
