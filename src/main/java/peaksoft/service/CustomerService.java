package peaksoft.service;

import peaksoft.model.Customer;

public interface CustomerService {
    
    void saveCustomer(Customer customer);


    Customer getCustomerById(long id);

    void update(long id,Customer customer);
}
