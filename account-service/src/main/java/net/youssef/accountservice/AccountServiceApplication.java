package net.youssef.accountservice;

import net.youssef.accountservice.clients.CustomerRestClient;
import net.youssef.accountservice.entities.BankAccount;
import net.youssef.accountservice.enums.AccountType;
import net.youssef.accountservice.repository.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountServiceApplication.class, args);
	}

	/*@Bean
	CommandLineRunner commandLineRunner(AccountRepository accountRepository, CustomerRestClient customerRestClient) {
		return args -> {

			customerRestClient.allCustomers().forEach(customer -> {
				BankAccount bankAccount1=BankAccount.builder()
						.accountID(UUID.randomUUID().toString())
						.currency("MAD")
						.balance(98000)
						.createdAt(LocalDate.now())
						.type(AccountType.CURRENT_ACCOUNT)
						.customerId(customer.getId())
						.build();

				BankAccount bankAccount2=BankAccount.builder()
						.accountID(UUID.randomUUID().toString())
						.currency("MAD")
						.balance(12000)
						.createdAt(LocalDate.now())
						.type(AccountType.SAVING_ACCOUNT)
						.customerId(customer.getId())
						.build();
				accountRepository.save(bankAccount1);
				accountRepository.save(bankAccount2);
			});
		};
	}
*/

}
