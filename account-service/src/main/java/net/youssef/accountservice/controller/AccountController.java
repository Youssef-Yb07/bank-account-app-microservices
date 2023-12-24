package net.youssef.accountservice.controller;

import lombok.RequiredArgsConstructor;
import net.youssef.accountservice.clients.CustomerRestClient;
import net.youssef.accountservice.entities.BankAccount;
import net.youssef.accountservice.entities.Customer;
import net.youssef.accountservice.repository.AccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AccountRepository accountRepository;

    private final CustomerRestClient customerRestClient;

    @GetMapping("/accounts")
    public List<BankAccount> accountList(){

        List<BankAccount> accountList= accountRepository.findAll();

        accountList.forEach(account->{
            account.setCustomer(customerRestClient.findCustomerById(account.getCustomerId()));
        });

        return accountList;
    }

    @GetMapping("/accounts/{id}")
    public BankAccount bankAccountById(@PathVariable String id){

        BankAccount bankAccount= accountRepository.findById(id).orElseThrow();
        Customer customer=customerRestClient.findCustomerById(bankAccount.getCustomerId());
        bankAccount.setCustomer(customer);
        return bankAccount;
    }
}
