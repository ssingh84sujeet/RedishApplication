package com.sujit.RedishApplication.Service;

import com.sujit.RedishApplication.Dao.CustomerDao;
import com.sujit.RedishApplication.Hash.Customer;
import com.sujit.RedishApplication.utill.JsonConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements INTCustService {
    private static final String CACHE_NAME="customer_cache";
    @Autowired
    CustomerDao dao;
    Logger log = LoggerFactory.getLogger(CustomerService.class);

    @CachePut(key = "#cust.id",value = CACHE_NAME)
    public Customer addCustomer(Customer cust) {
        log.info("CustomerService :: addCustomer request recevied in service to add {}", JsonConverter.convertToJson(cust));
        return dao.addCustomer(cust);
    }

    @Cacheable(value = CACHE_NAME)
    public List<Customer> getAllCustomer() {
        log.info("CustomerService :: getAllCustomer getting all customers from DB");
        return dao.getAllCustomer();
    }
@Cacheable(key = "#id",value = CACHE_NAME)
    public Customer getCustomerById(Integer id) {
        log.info("CustomerService :: getCustomerById getting  customer by id from DB");
        return dao.getCustomerById(id);
    }
    @CacheEvict(key = "#id",value = CACHE_NAME)
    public String deleteCustomer(Integer id) {
        log.info("CustomerService :: deleteCustomer deleting customer from DB by id");
        return dao.deleteCustomer(id);
    }
    @CachePut(key = "#cust.id",value = CACHE_NAME)
    public Customer updateCustomer(Integer id, Customer cust) {
        log.info("CustomerService :: updateCustomer updating customer in DB by id");
        return dao.updateCustomer(id, cust);
    }

}
