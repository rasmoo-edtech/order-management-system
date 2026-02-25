package com.rasmoo.company.ordermanagement.application;

import com.rasmoo.company.ordermanagement.domain.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DirtyCheckingDemo {

    static void main() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("orderManagementPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Customer customer = em.find(Customer.class, 11L);

        customer.setPhone("11876543421");

        em.getTransaction().commit();
        em.close();
        emf.close();

    }
}
