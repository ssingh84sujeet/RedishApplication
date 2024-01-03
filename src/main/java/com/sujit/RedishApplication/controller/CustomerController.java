package com.sujit.RedishApplication.controller;

import com.sujit.RedishApplication.Hash.Customer;
import com.sujit.RedishApplication.Service.INTCustService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cust")
public class CustomerController {

    INTCustService service;

    @Autowired
    public CustomerController(INTCustService service) {
        this.service = service;
    }

    @PostMapping("/addCustomer")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer cust) {
        System.out.println("Request received");
        Customer customer = service.addCustomer(cust);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    @GetMapping("/showAll")
    public ResponseEntity<List<Customer>> getAllCustomer() {
        List<Customer> cust = service.getAllCustomer();
        return new ResponseEntity<>(cust, HttpStatus.ACCEPTED);
    }

    @GetMapping("/show/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Integer id) {
        Customer customer = service.getCustomerById(id);
        return new ResponseEntity<>(customer, HttpStatus.FOUND);
    }

    @DeleteMapping("/show/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Integer id) {
        String msg = service.deleteCustomer(id);
        return new ResponseEntity<>(msg, HttpStatus.ACCEPTED);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Integer id, @RequestParam Customer cust) {
        Customer customer = service.updateCustomer(id, cust);
        return new ResponseEntity<>(customer, HttpStatus.ACCEPTED);
    }

}
