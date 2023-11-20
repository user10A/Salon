package peaksoft.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.model.Customer;
import peaksoft.repo.CustomerRepo;
import peaksoft.service.CustomerService;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepo customerRepo;


    @Override
    public void saveCustomer(Customer customer) {
        customerRepo.save(customer);
    }

    @Override
    public Customer getCustomerById(long id) {
        return customerRepo.findById(id).orElseThrow(()->
                new RuntimeException("Customer not found by id: " + id));
    }

    @Override
    public void update(long id, Customer customer) {
        Customer customer1 = customerRepo.findById(id).orElseThrow(()->
                new RuntimeException("Customer not found by id: " + id));
        customer1.setName(customer.getName());
        customer1.setBookings(customer.getBookings());
        customerRepo.save(customer1);
    }
}
