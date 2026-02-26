package com.rasmoo.company.ordermanagement.application;

import com.rasmoo.company.ordermanagement.domain.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class FlushCommitDemo {

    static void main() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("orderManagementPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Customer customer = new Customer(
                "Tayane Pereira",
                "tayane@rasmoo.com",
                "12323245465",
                null,
                "ACTIVE"

        );

        em.persist(customer);

        em.flush();
        em.getTransaction().rollback();

        em.close();
        emf.close();

    }
}
