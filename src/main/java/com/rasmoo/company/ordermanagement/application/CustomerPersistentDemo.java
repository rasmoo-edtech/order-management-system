package com.rasmoo.company.ordermanagement.application;

import com.rasmoo.company.ordermanagement.domain.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CustomerPersistentDemo {

    static void main() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("orderManagementPU");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            Customer customer = new Customer(
                    "Ana Silva",
                    "ana_silva@rasmoo.com",
                    "111999999",
                    "11888888888",
                    "ACTIVE"

            );

            System.out.println("Estado transient: ID = " + customer.getId());

            em.persist(customer);
            em.getTransaction().commit();

            System.out.println("Estado MANAGED: ID = " + customer.getId());

        } finally {
            em.close();
            emf.close();
        }

    }
}
