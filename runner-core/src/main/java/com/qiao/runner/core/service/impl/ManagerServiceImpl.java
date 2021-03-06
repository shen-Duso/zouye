package com.qiao.runner.core.service.impl;

import com.qiao.runner.core.domain.Manager;
import com.qiao.runner.core.repository.ManagerRepository;
import com.qiao.runner.core.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ManagerRepository managerRepository;

    @Override
    public Manager login(String username, String password) {
        return managerRepository.findByUsernameAndPassword(username, password);
    }

    @Override
    public Manager get(Long id) {
        return managerRepository.getOne(id);
    }

    @Override
    public Manager modifyPwd(Long id, String newPwd) {
        Manager manager = managerRepository.getOne(id);
        manager.setPassword(newPwd);
        return managerRepository.save(manager);
    }

    @Override
    public Manager create(Manager manager) {
        return managerRepository.save(manager);
    }
}
