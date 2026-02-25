package com.rasmoo.company.ordermanagement.application;

import com.rasmoo.company.ordermanagement.domain.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CustomerDetachedtDemo {

    static void main() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("orderManagementPU");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            Customer customer = new Customer(
                    "Fernando Sousa",
                    "fernando_sousa2@rasmoo.com",
                    "0087888S88",
                    null,
                    "ACTIVE"

            );

            em.persist(customer);
            em.getTransaction().commit();

            System.out.println("Estado MANAGED: ID = " + customer.getId());

            em.close();
            Customer customer1 = em.find(Customer.class, customer.getId());
            //DETACHED
            System.out.println("Estado DETACHED: ID = " + customer1.getFullName());

        } finally {

            emf.close();
        }

    }
}
