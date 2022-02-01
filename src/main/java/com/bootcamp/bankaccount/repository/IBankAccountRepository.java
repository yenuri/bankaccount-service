package com.bootcamp.bankaccount.repository;

import com.bootcamp.bankaccount.model.BankAccount;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface IBankAccountRepository extends ReactiveMongoRepository<BankAccount, String> {
}
