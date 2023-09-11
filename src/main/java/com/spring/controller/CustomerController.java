package com.spring.controller;

import com.spring.model.Customer;
import com.spring.model.Person;
import com.spring.services.CustomerServices;
import com.spring.services.PersonServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Validated // in class to valid pattern (request param)
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerServices customerServices;

    @GetMapping("/count")
    public long count() {
        return customerServices.count();
    }

    @GetMapping("/customers")
    public List<Customer> findAll() {
        return customerServices.findAll();
    }

    @GetMapping("/customer")
    public Optional<Customer> findById(@RequestParam Long id) {
        return customerServices.findById(id);
    }

    @PostMapping("/customers")
    public Customer save(@RequestBody @Valid Customer customer) {
        customerServices.save(customer);
        return customer;
    }
    @PutMapping("/customers")
    public Customer update(@RequestBody @Valid Customer customer) {
        customerServices.save(customer);
        return customer;
    }

    @DeleteMapping("/customer")
    public Customer deleteById(@RequestParam Long id) {
        Customer customer;
        customer = customerServices.findById(id).get();
        customerServices.deleteById(id);
        return customer;
    }
}
