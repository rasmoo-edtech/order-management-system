package com.rasmoo.company.ordermanagement.application;

import com.rasmoo.company.ordermanagement.domain.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CustomerMergeDemo {

    static void main() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("orderManagementPU");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            Customer customer = new Customer(
                    "Fernando Sousa",
                    "felipe_alves2@rasmoo.com",
                    "111111111112",
                    null,
                    "ACTIVE"

            );

            em.persist(customer);
            em.getTransaction().commit();

            System.out.println("Estado MANAGED: ID = " + customer.getId());
            //DETACHED
            em.close();
            //MERGE
            EntityManager em2 = emf.createEntityManager();
            em2.getTransaction().begin();
            Customer customer1 = em2.merge(customer);
            Customer customer2 = em2.find(Customer.class, customer1.getId());
            System.out.println("Estado MANAGED apos merge: ID = " + customer2.getFullName());
            em2.getTransaction().commit();
            em2.close();

        } finally {

            emf.close();
        }

    }
}
