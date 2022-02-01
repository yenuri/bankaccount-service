package com.bootcamp.bankaccount.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "bankAccount")
public class BankAccount {

    @Id
    private String id;
    private AccountType accountType;
    private Double commission;
    private Long numTransactions;
    private Customer customer;
    private Date createAt;
    private Double balance;
    private String status;
}
