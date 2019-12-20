package net.codejava.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.codejava.dao.CustomerRepository;
import net.codejava.model.Customer;

@Service
public class CustomerService {
	@Autowired 
	CustomerRepository repo;
	
	public List<Customer> listAll() {
		return (List<Customer>) repo.findAll();
	}
	
	public void saveCustomer(Customer customer) {
		repo.save(customer) ;
	}
	
	public Customer get(long id) {
		Optional<Customer> result = repo.findById(id) ;
		return result.get() ;
	}
	
	public void delete(long id) {
		repo.deleteById(id);
	}
	
	public List<Customer> search(String keyword) {
		return repo.search(keyword) ;
	}

}
