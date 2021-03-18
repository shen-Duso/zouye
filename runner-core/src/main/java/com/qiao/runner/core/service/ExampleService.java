package com.qiao.runner.core.service;


import com.qiao.runner.core.domain.Example;

public interface ExampleService {

    public Example save(Example example);

    public Example findById(Long id);

}
