package com.bootcamp.bankaccount.business.impl;

import com.bootcamp.bankaccount.business.IBankAccountService;
import com.bootcamp.bankaccount.model.BankAccount;
import com.bootcamp.bankaccount.repository.IBankAccountRepository;
import com.bootcamp.bankaccount.utils.BankAccountStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Calendar;

@Service
public class BankAccountServiceImpl implements IBankAccountService {

    @Autowired
    private IBankAccountRepository bankAccountRepository;

    @Override
    public Mono<BankAccount> create(BankAccount bankAccount) {

        bankAccount.setStatus(BankAccountStatus.REGISTERED.name());
        bankAccount.setCreateAt(Calendar.getInstance().getTime());
        return bankAccountRepository.save(bankAccount);
    }

    @Override
    public Mono<BankAccount> findById(String id) {
        return bankAccountRepository.findById(id);
    }

    @Override
    public Flux<BankAccount> findAll() {
        return bankAccountRepository.findAll()
                .filter(p -> p.getStatus().equals(BankAccountStatus.REGISTERED.name()));
    }

    @Override
    public Mono<BankAccount> update(BankAccount bankAccount) {

        return bankAccountRepository.findById(bankAccount.getId())
                .filter(p -> p.getStatus().equals(BankAccountStatus.REGISTERED.name()))
                .switchIfEmpty(Mono.empty())
                .flatMap(bankAccountDB -> bankAccountRepository.save(bankAccount));
    }

    @Override
    public Mono<BankAccount> delete(String id) {
        return bankAccountRepository.findById(id)
                .switchIfEmpty(Mono.empty())
                .doOnNext(p -> p.setStatus(BankAccountStatus.DELETED.name()))
                .flatMap(bankAccountRepository::save);
    }
}
