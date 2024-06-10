package ru.netology.jdbc.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class JDBCRepository {
    @PersistenceContext
    private EntityManager entityManager;


    public List<String> getProductName(String name) {
        return entityManager.createQuery("select O.productName " +
                        "from Customer C join Order O " +
                        "on C.id = O.customer.id " +
                        "where lower(C.name) = lower(:name)", String.class)
                .setParameter("name", name)
                .getResultList();
    }
}