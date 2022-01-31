package com.bootcamp.bankaccount.business;

import com.bootcamp.bankaccount.model.BankAccount;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IBankAccountService {

    Mono<BankAccount> create(BankAccount bankAccount);

    Mono<BankAccount> findById(String id);

    Flux<BankAccount> findAll();

    Mono<BankAccount> update(BankAccount bankAccount);

    Mono<BankAccount> delete(String id);

}
