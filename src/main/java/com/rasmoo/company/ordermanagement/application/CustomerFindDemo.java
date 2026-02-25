package com.rasmoo.company.ordermanagement.application;

import com.rasmoo.company.ordermanagement.domain.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CustomerFindDemo {

    static void main() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("orderManagementPU");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            Customer customer = em.find(Customer.class, 8L);

            System.out.println("Estado MANAGED: ID = " + customer.getId());

            em.getTransaction().commit();

        } finally {
            em.close();
            emf.close();
        }

    }
}
