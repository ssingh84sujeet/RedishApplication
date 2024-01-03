package com.sujit.RedishApplication.Service;

import com.sujit.RedishApplication.Hash.Customer;

import java.util.List;

public interface INTCustService {
    Customer addCustomer(Customer cust);
    List<Customer> getAllCustomer();
    Customer getCustomerById(Integer id);
    String deleteCustomer(Integer id);
    Customer updateCustomer(Integer id, Customer cust);
}
