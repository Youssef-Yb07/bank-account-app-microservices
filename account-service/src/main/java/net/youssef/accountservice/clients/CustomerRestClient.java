package net.youssef.accountservice.clients;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import net.youssef.accountservice.entities.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//Avec cette interface,
// on peut faire appel à des méthodes qui vont faire appel à des méthodes du service customer-service
// et qui vont nous retourner des objets de type Customer
//Donc il vont parcourir le discovery service pour trouver le service customer-service
//récupérer l'adresse IP et le port du service customer-service
//et faire appel à la méthode du service customer-service en se basant
//sur le chemin d'accès de la méthode du service customer-service
//@FeignClient est une annotation de Spring Cloud
// qui permet de faire appel à des services distants
//OpenFeign permet de creer des clients REST déclaratifs
@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClient {


    //CircuitBreaker est une annotation permettant de gérer les erreurs
    //si le service customer-service est indisponible
    //on va faire appel à la méthode getDefaultCustomer
    //qui va nous retourner un objet de type Customer
    //qui va contenir des valeurs par défaut
    //et donc si le service customer-service est indisponible le service account-service
    //va rester disponible mais si on utilise pas l'annotation CircuitBreaker
    //et que le service customer-service est indisponible
    //le service account-service va aussi être indisponible
    @CircuitBreaker(name = "customerService", fallbackMethod = "getDefaultCustomer")
    @GetMapping("/customers/{id}")
    Customer findCustomerById(@PathVariable Long id);

    @CircuitBreaker(name = "customerService", fallbackMethod = "DefaultGetAllCustomer")
    @GetMapping("/customers")
    List<Customer> allCustomers();

    default Customer getDefaultCustomer(Long id, Exception exception){
        Customer customer = new Customer();
        customer.setId(id);
        customer.setFirstName("Not Available");
        customer.setLastName("Not Available");
        customer.setEmail("Not Available");
        return customer;
    }

    default List<Customer> DefaultGetAllCustomer(Exception exception){
        return List.of();
    }
}
