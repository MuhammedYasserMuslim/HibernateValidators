package com.spring.services;

import com.spring.model.Customer;
import com.spring.repository.CustomerRepository;
import com.spring.services.base.BaseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServices implements BaseServices<Customer, Long> {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public long count() {
        return customerRepository.count();
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void update(Customer customer) {
        customerRepository.save(customer);

    }

    @Override
    public void deleteById(Long id) {
        customerRepository.deleteById(id);
    }
}
