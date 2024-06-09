package ru.netology.jdbc.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.jdbc.model.Customer;
import ru.netology.jdbc.model.Order;
import ru.netology.jdbc.repository.JDBCRepository;

import java.util.List;

@RestController
@AllArgsConstructor
public class JDBCController {
    private final JDBCRepository jdbcRepository;


    @GetMapping("/products/fetch-product")
    public List<String> getProductName(@RequestParam String name) {
        return jdbcRepository.getProductName(name);
    }
}
