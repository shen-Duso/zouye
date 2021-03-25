package com.qiao.runner.core.repository;

import com.qiao.runner.core.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

    public Customer findByUsernameAndPassword(String username, String password);

}
