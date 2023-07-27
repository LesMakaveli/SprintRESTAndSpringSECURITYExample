package com.rybkin.premierbank.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "BankEmployees")
@NoArgsConstructor
@Data
public class BankEmployee
{
    @Id
    @Column(name = "bank_employee_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "surname")
    private String surname;

    @Column(name = "name")
    private String name;

    public BankEmployee(int id, String surname, String name) {
        this.id = id;
        this.surname = surname;
        this.name = name;
    }
}
