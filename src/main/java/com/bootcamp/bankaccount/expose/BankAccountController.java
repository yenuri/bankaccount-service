package com.bootcamp.bankaccount.expose;

import com.bootcamp.bankaccount.business.IBankAccountService;
import com.bootcamp.bankaccount.model.BankAccount;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RequestMapping(value = "/api/bankaccounts")
@RestController
public class BankAccountController {

    @Autowired
    private IBankAccountService bankAccountService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<BankAccount> create(@RequestBody BankAccount bankAccount) {
        log.info("<<<<< Create BankAccount >>>>>");
        return bankAccountService.create(bankAccount);
    }

    @GetMapping("/{id}")
    public Mono<BankAccount> finById(@PathVariable String id) {
        log.info("<<<<< Find One BankAccount >>>>>");
        return bankAccountService.findById(id);
    }

    @GetMapping("")
    public Flux<BankAccount> findAll() {
        log.info("<<<<< Find All BankAccounts >>>>>");
        return bankAccountService.findAll();
    }

    @PutMapping("")
    public Mono<ResponseEntity<BankAccount>> update(@RequestBody BankAccount bankAccount) {
        log.info("<<<<< Update BankAccount >>>>>");
        return bankAccountService.update(bankAccount)
                .flatMap(bankAccountUpdate -> Mono.just(ResponseEntity.ok(bankAccountUpdate)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @DeleteMapping("/{id}")
    public Mono<BankAccount> delete(@PathVariable String id) {
        log.info("<<<<< Delete BankAccount >>>>>");
        return bankAccountService.delete(id);
    }

}
