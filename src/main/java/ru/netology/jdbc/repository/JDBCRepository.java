package ru.netology.jdbc.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.netology.jdbc.model.Order;

import java.util.ArrayList;
import java.util.List;

@Repository
@AllArgsConstructor
public class JDBCRepository {
    @PersistenceContext
    private EntityManager entityManager;


    public List<String> getProductName(String name) {
        List<Order> orderList = entityManager.createNativeQuery("select * from netology.orders;", Order.class).getResultList();
        List<String> products = new ArrayList<>();
        for (Order order : orderList) {
            if (order.getCustomer().getName().equalsIgnoreCase(name)) {
                products.add(order.getProductName());
            }
        }
        return products;
    }
}