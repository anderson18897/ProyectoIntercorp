package com.reto.intercop.controller;

import com.reto.intercop.model.Customer;
import com.reto.intercop.model.Indicator;
import com.reto.intercop.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/intercorp/customer")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/list")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        try {
            List<Customer> customers = customerRepository.findAll();

            if (customers.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(customers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Customer> createTutorial(@RequestBody Customer customer) {

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        try {
            Customer _customer = customerRepository.save(new Customer(
                    customer.getName(),
                    customer.getLastname(),
                    customer.getEmail(),
                    customer.getDni(),
                    formatter.format(new Date()),
                    customer.getDate_birth()
            ));
            return new ResponseEntity<>(_customer, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findby/{text}")
    public ResponseEntity<Customer> findByDni(@PathVariable("text") String text) {
        try {

            Customer customer = customerRepository.findBy(text);

            if (customer == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(customer, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/indicator")
    public ResponseEntity<List<List<Indicator>>> findByIndicator() {
        try {

            List<Indicator> customerInd = customerRepository.findByIndicator();
            List<Indicator> customerMax = customerRepository.findByIndicatorMax();
            List<Indicator> customerMin = customerRepository.findByIndicatorMin();
            List<List<Indicator>> customer = Arrays.asList(customerInd, customerMax, customerMin);

            if (customer == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(customer, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
