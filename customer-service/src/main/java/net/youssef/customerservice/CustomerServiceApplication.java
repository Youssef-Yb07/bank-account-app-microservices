package net.youssef.customerservice;

import net.youssef.customerservice.config.GlobalConfig;
import net.youssef.customerservice.entities.Customer;
import net.youssef.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties({GlobalConfig.class})
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	/*@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
		return args -> {

			List<Customer> customerList=List.of(
					Customer.builder()
							.firstName("Youssef")
							.lastName("Bouichenade")
							.email("youssef@gmail.com")
							.build(),
					Customer.builder()
							.firstName("micro")
							.lastName("micro")
							.email("micro@gmail.com")
							.build()
			);

			customerRepository.saveAll(customerList);

		};
	}*/

}
