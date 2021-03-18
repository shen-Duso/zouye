package com.qiao.runner.core.service.impl;

import com.qiao.runner.core.domain.Customer;
import com.qiao.runner.core.repository.CustomerRespository;
import com.qiao.runner.core.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRespository customerRespository;

    @Override
    public Customer register(Customer customer) {
        return customerRespository.save(customer);
    }

    @Override
    public Customer login(String username, String password) {
        return customerRespository.findByUsernameAndPassword(username, password);
    }

    @Override
    public Page<Customer> list(Pageable pageable) {
        return customerRespository.findAll(pageable);
    }

    @Override
    public Customer get(Long id) {
        return customerRespository.getOne(id);
    }

    @Override
    public Customer update(Customer customer) {
        return customerRespository.save(customer);
    }

    @Override
    public Customer applyToDistributor(Customer customer) {
        customer.setApplyStatus(1);
        return customerRespository.save(customer);
    }

    @Override
    public Customer confirmToDistributor(Customer customer, Integer status) throws Exception {
        //有相关的业务判断
        if (status == 2){
            customer.setApplyStatus(status);
            customer.setType(2);
            return customerRespository.save(customer);
        }else if (status == 9){
            customer.setApplyStatus(status);
            customer.setType(1);
            return customerRespository.save(customer);
        }else{
            //抛出异常
            throw  new Exception("参数错误");
        }

    }
}
