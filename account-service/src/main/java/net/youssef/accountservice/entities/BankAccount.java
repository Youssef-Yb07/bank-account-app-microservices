package net.youssef.accountservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.youssef.accountservice.enums.AccountType;

import java.time.LocalDate;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BankAccount {

    @Id
    private String accountID;

    private double balance;

    private LocalDate createdAt;

    private String currency;

    @Enumerated(EnumType.STRING)
    private AccountType type;

    //Dans le cas d'une Application monolithique, on aurait pu utiliser une relation OneToOne
    //Entre BankAccount et Customer, mais dans le cas d'une architecture microservices,
    //On utilise l'ID du Customer comme clé étrangère
    //Car la classe Customer n'existe pas dans le service Account
    //Et elle existe dans le service Customer (customer-service)
    private Long customerId;


    //ici on utilise l'annotation @Transient pour dire à JPA de ne pas persister cette propriété
    //car elle n'existe pas dans la table BankAccount
    //elle sera utilisée pour stocker les données du Customer
    //et pour les récupérer facilement
    @Transient
    private Customer customer;


    //En utilisant private Long customerId; en combinason avec  @Transient private Customer customer;
    //On peut récupérer les données du Customer en utilisant le customerId
    //et on peut aussi stocker les données du Customer dans l'objet customer
    //et les récupérer facilement en utilisant l'objet customer



}
