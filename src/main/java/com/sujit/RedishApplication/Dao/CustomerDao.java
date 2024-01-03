package com.sujit.RedishApplication.Dao;

import com.sujit.RedishApplication.Hash.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDao {
    public static final String HASH_KEY="Customer";
    @Autowired
    @Qualifier(value = "templateMethod")
    RedisTemplate template;

    public Customer addCustomer(Customer cust){
        template.opsForHash().put(HASH_KEY,cust.getId(),cust);
        return cust;
    }

    public List<Customer> getAllCustomer(){
      return   template.opsForHash().values(HASH_KEY);
    }

    public Customer getCustomerById(Integer id){
        return (Customer) template.opsForHash().get(HASH_KEY,id);
    }

    public String deleteCustomer(Integer id){
        template.opsForHash().delete(HASH_KEY,id);
        return "Customer with :"+ id +"is deleted";
    }

    public Customer updateCustomer(Integer id,Customer cust){
      Customer c=  (Customer)  template.opsForHash().get(HASH_KEY,id);
      if(c!=null){
          c.setEmail(cust.getEmail());
          c.setDob(cust.getDob());
          c.setPhone(cust.getPhone());
          c.setLastName(cust.getLastName());
          c.setFirstName(cust.getFirstName());
          template.opsForHash().put(HASH_KEY,id,c);
      }else{
          throw new RuntimeException("Customer not found");
      }
      return c;
    }
}
